package fr.uge.corp.rentingapp.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.uge.corp.ifscars.cars.ICar;

public class Client extends UnicastRemoteObject implements IClient {
	
	private final long id;
	private static final Logger logger = Logger.getLogger(Client.class.getName()); 
	private final Map<String, Map<Long, ICar>> rentedCars;
	
	public Client(long id) throws RemoteException {
		this.id = id;
		rentedCars = new HashMap<>();
	}

	@Override
	public void refusedRequest(String msg) throws RemoteException {
		logger.log(Level.INFO, msg);
	}

	@Override
	public void receiveCar(ICar car) throws RemoteException {
		if (!rentedCars.containsKey(car.getModel()) || !rentedCars.get(car.getModel()).containsKey(car.getId())) {
			Map<Long, ICar> map = rentedCars.computeIfAbsent(car.getModel(), __ -> new HashMap<>());
			map.put(car.getId(), car);
			rentedCars.put(car.getModel(), map);
			logger.log(Level.INFO, "you have rented ["+car.display()+"]");
		}
	}

	@Override
	public void returnCar(ICar car) throws RemoteException {
		rentedCars.computeIfAbsent(car.getModel(), __ -> new HashMap<>()).remove(car.getId());
		logger.log(Level.INFO, "you have return ["+car.display()+"]");
	}

	@Override
	public ICar getCar(String model, long id) throws RemoteException {
		if (!rentedCars.containsKey(model)) {
			return null;
		}
		return rentedCars.get(model).get(id);
	}

	@Override
	public String displayCurrentlyRentedCars() throws RemoteException {
		
		return rentedCars.values().stream().flatMap(x -> x.values().stream()).
				map(x -> {
					try {
						return x.display();
					} catch (RemoteException e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.joining(", ", "<", ">"));
	}

	@Override
	public long getId() throws RemoteException {
		return id;
	}

}
