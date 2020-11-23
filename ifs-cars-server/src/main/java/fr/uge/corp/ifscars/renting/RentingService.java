package fr.uge.corp.ifscars.renting;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.cars.Storage;
import fr.uge.corp.ifscars.rating.IRating;
import fr.uge.corp.rentingapp.client.IClient;

public class RentingService extends UnicastRemoteObject implements IRentingService {
	
	public static enum RentStatus {
		None, Wait, Give
	}
	
	private final Storage storage;
	private final Map<String, Map<Long, IClient>> waitingRequests;
	private final Map<ICar, List<IRating>> ratings;
	private static final Logger logger = Logger.getLogger(RentingService.class.getName());

	public RentingService(Storage storage) throws RemoteException {
		Objects.requireNonNull(storage);
		this.storage = storage;
		waitingRequests = new ConcurrentHashMap<>();
		ratings=new HashMap<>();
	}

	@Override
	public String display() throws RemoteException {
		return storage.display();
	}

	@Override
	public double getCarPrice(String model) throws RemoteException {
		ICar car = storage.get(model);
		if (car==null) {
			return 0;
		}
		return car.getPrice() / 2;
	}

	@Override
	public ICar[] getAllCars() throws RemoteException {
		Set<ICar> cs = ratings.keySet();
		ICar[] cars = new ICar[cs.size()];
		int i = 0;
		for (ICar c : cs) {
			if (storage.available(c.getModel())) {
				cars[i++] = c;
			}
		}
		return cars;
	}
	
	private void processQueue(IClient client, ICar car, RentStatus status) throws RemoteException {
		IClient c = client;
		if (storage.available(car.getModel())) {
			if (status == RentStatus.Wait) {
				Optional<Long> shortest = waitingRequests.get(car.getModel()).keySet().stream().min(Long::compare);
				if (shortest.isPresent()) {
					status = RentStatus.Give;
					Map<Long, IClient> rs = waitingRequests.get(car.getModel());
					c = rs.get(shortest.get());
					rs.remove(shortest.get());
					waitingRequests.put(car.getModel(), rs);
				}
			}
			if (status == RentStatus.Give) {
				ICar carAvailable = storage.getAvailableCars(car.getModel()).get(0);
				c.receiveCar(carAvailable);
				storage.take(carAvailable);
			}
		}		
	}
	
	@Override
	public void receiveCarRentingRequest(IClient client, String model) throws RemoteException {
		Objects.requireNonNull(client);
		Objects.requireNonNull(model);
		logger.log(Level.INFO, "Rent request for model:"+model);
		if (!storage.exists(model)) {
			client.refusedRequest("The following model:"+model+" does not exist");
		}
		RentStatus status = RentStatus.Give;
		if (!storage.available(model)) {
			client.refusedRequest("Wait ...");
			Map<Long, IClient> map = waitingRequests.computeIfAbsent(model, __ -> new ConcurrentHashMap<>());
			map.put(System.currentTimeMillis(), client);
			waitingRequests.put(model, map);
			status = RentStatus.Wait;
		}
		
		processQueue(client, storage.get(model), status);		
	}

	@Override
	public void receiveCarReturnRequest(IClient client, ICar car, IRating rating) throws RemoteException {
		Objects.requireNonNull(client);
		Objects.requireNonNull(rating);
		Objects.requireNonNull(car);
		logger.log(Level.INFO, "Return request for car:["+car.display()+"] with a rating of ["+rating.display()+"]");
		ratings.computeIfAbsent(car, __ -> new ArrayList<>()).add(rating);
		storage.add(car);
		client.returnCar(car);
		RentStatus status = waitingRequests.get(car.getModel()) == null || waitingRequests.get(car.getModel()).size() == 0?RentStatus.None:RentStatus.Wait;
		processQueue(client, car, status);
		
	}

	@Override
	public ICar getCar(String model) throws RemoteException {
		Objects.requireNonNull(model);
		return storage.get(model);
	}

	@Override
	public String displayRatings(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		List<IRating> rs =  ratings.getOrDefault(car, new ArrayList<>());
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for (IRating rating : rs) {
			sj.add(rating.display());
		}
		return sj.toString();
	}

}
