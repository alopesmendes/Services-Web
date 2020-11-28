package fr.uge.corp.ifscars.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.uge.corp.ifscars.common.Car;
import fr.uge.corp.ifscars.common.IClient;
import fr.uge.corp.ifscars.common.IRentingService;
import fr.uge.corp.ifscars.common.Rating;

public class RentingService extends UnicastRemoteObject implements IRentingService {

	private static final Logger LOGGER = Logger.getLogger(RentingService.class.getName());

	private final Storage storage;
	private final Map<Long, Queue<IClient>> rentingRequestsPerCar = new ConcurrentHashMap<>();
	private final Map<Long, List<Rating>> ratings = new ConcurrentHashMap<>();
	private final Map<Long, Set<Long>> rentCarsPerClient = new ConcurrentHashMap<>();

	public RentingService(Storage storage) throws RemoteException {
		Objects.requireNonNull(storage);
		this.storage = storage;
	}

	@Override
	public Car getCar(long carId) throws RemoteException {
		return storage.get(carId);
	}

	@Override
	public List<Car> list(String modelFilter, boolean showAvailableOnly, boolean showRatedOnly) throws RemoteException {
		return storage.search(modelFilter, showAvailableOnly)
				.filter(car -> !showRatedOnly || !ratings.getOrDefault(car.getId(), Collections.emptyList()).isEmpty())
				.collect(Collectors.toList());
	}

	@Override
	public void receiveCarRentingRequest(IClient client, long carId) throws RemoteException {
		Objects.requireNonNull(client);
		if (carsForClient(client.getId()).contains(carId)) {
			throw new IllegalStateException("client is already renting this car");
		}
		LOGGER.log(Level.INFO, "Client " + client.getId() + " requested to rent car id " + carId);
		queueForCar(carId).add(client);
		processQueue(carId);
	}

	@Override
	public void receiveCarReturnRequest(IClient client, long carId, Rating rating) throws RemoteException {
		Objects.requireNonNull(client);
		Objects.requireNonNull(rating);
		if (!carsForClient(client.getId()).remove(carId)) {
			throw new IllegalStateException("client has not rent this car");
		}
		LOGGER.log(Level.INFO, "Client " + client.getId() + " returned car id " + carId + " with rating " + rating);
		ratings.computeIfAbsent(carId, k -> Collections.synchronizedList(new ArrayList<>())).add(rating);
		storage.release(carId);
		client.returnCar(storage.get(carId));
		processQueue(carId);
	}

	@Override
	public List<Rating> getRatingsForCar(long carId) throws RemoteException {
		return ratings.getOrDefault(carId, Collections.emptyList());
	}

	@Override
	public List<Car> listCarsRentByClient(IClient client) throws RemoteException {
		return carsForClient(client.getId()).stream()
				.map(storage::get)
				.collect(Collectors.toList());
	}

	private void processQueue(long carId) throws RemoteException {
		Queue<IClient> queue = queueForCar(carId);
		if (queue.isEmpty()) {
			return;
		}
		Car car;
		if ((car = storage.acquire(carId)) != null) {
			IClient client = queue.remove();
			carsForClient(client.getId()).add(car.getId());
			client.receiveCar(car);
		}
	}

	private Queue<IClient> queueForCar(long carId) {
		return rentingRequestsPerCar.computeIfAbsent(carId, k -> new ConcurrentLinkedQueue<>());
	}
	
	private Set<Long> carsForClient(long clientId) {
		return rentCarsPerClient.computeIfAbsent(clientId, k -> ConcurrentHashMap.newKeySet());
	}
}
