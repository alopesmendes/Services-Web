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
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.cars.Storage;
import fr.uge.corp.ifscars.rating.IRating;
import fr.uge.corp.rentingapp.client.IClient;

public class RentingService extends UnicastRemoteObject implements IRentingService {
	
	public static enum RentStatus {
		None, Wait, Give
	}
	
	private final Storage storage;
	private final Map<ICar, Map<Long, IClient>> waitingRequests;
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
		ICar car = storage.getModel(model);
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
			if (storage.availableModel(c.getModel())) {
				cars[i++] = c;
			}
		}
		return cars;
	}
	
	private void processQueue(IClient client, ICar car, RentStatus status) throws RemoteException {
		IClient c = client;
		if (storage.availableCar(car)) {
			if (status == RentStatus.Wait) {
				Optional<Long> shortest = waitingRequests.get(car).keySet().stream().min(Long::compare);
				if (shortest.isPresent()) {
					status = RentStatus.Give;
					Map<Long, IClient> rs = waitingRequests.get(car);
					c = rs.get(shortest.get());
					rs.remove(shortest.get());
					waitingRequests.put(car, rs);
				}
			}
			if (status == RentStatus.Give) {
				c.receiveCar(car);
				storage.take(car);
			}
		}		
	}
	
	@Override
	public void receiveCarRentingRequest(IClient client, String model, long id) throws RemoteException {
		Objects.requireNonNull(client);
		Objects.requireNonNull(model);
		logger.log(Level.INFO, "Rent request for model:"+model);
		if (!storage.exists(model)) {
			client.refusedRequest("The following model:"+model+" does not exist");
			return;
		}
		ICar car = storage.getCar(model, id);
		if (car == null) {
			client.refusedRequest("The following model:"+model+" with the id:"+id+" does not exist");
			return;
		}
		RentStatus status = RentStatus.Give;
		if (!storage.availableModel(model)) {
			client.refusedRequest("Wait ...");
			Map<Long, IClient> map = waitingRequests.computeIfAbsent(car, __ -> new ConcurrentHashMap<>());
			map.put(System.currentTimeMillis(), client);
			waitingRequests.put(car, map);
			status = RentStatus.Wait;
		}
		
		processQueue(client, storage.getCar(model, id), status);		
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
		RentStatus status = waitingRequests.get(car) == null || waitingRequests.get(car).size() == 0 ? RentStatus.None : RentStatus.Wait;
		processQueue(client, car, status);
		
	}

	@Override
	public ICar getCar(String model) throws RemoteException {
		Objects.requireNonNull(model);
		return storage.getModel(model);
	}

	@Override
	public String displayRatings(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		/*
		List<IRating> rs =  ratings.getOrDefault(car, new ArrayList<>());
		StringJoiner sj = new StringJoiner(", ", "[", "]");
		for (IRating rating : rs) {
			sj.add(rating.display());
		}*/
		return ratings.getOrDefault(car, new ArrayList<IRating>()).stream().
		map(arg0 -> {
			try {
				return arg0.display();
			} catch (RemoteException e) {
				throw new RuntimeException(e);
			}
		}).collect(Collectors.joining(", ", "[", "]"));
	}

	@Override
	public String displayCarsFromModel(String model) throws RemoteException {
		return storage.getCarsModel(model).stream().map(car -> {
			try {
				return storage.displayStockCar(car)+" ratings:"+displayRatings(car);
			} catch (RemoteException e) {
				throw new RuntimeException();
			}
		}).collect(Collectors.joining(", ", "{", "}"));
	}

}
