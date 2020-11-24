package fr.uge.corp.rentingapp.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.ICar;

public class Client extends UnicastRemoteObject implements IClient {
	
	private final long id;
	private static final Logger logger = Logger.getLogger(Client.class.getName()); 
	private final Map<String, ICar> rentedCars;
	
	public Client(long id) throws RemoteException {
		this.id = id;
		rentedCars = new HashMap<String, ICar>();
	}

	@Override
	public void refusedRequest(String msg) throws RemoteException {
		logger.log(Level.INFO, msg);
	}

	@Override
	public void receiveCar(ICar car) throws RemoteException {
		if (!rentedCars.containsKey(car.getModel())) {
			rentedCars.put(car.getModel(), car);
			logger.log(Level.INFO, "you have rented ["+car.display()+"]");
		}
	}

	@Override
	public void returnCar(ICar car) throws RemoteException {
		rentedCars.remove(car.getModel());
		logger.log(Level.INFO, "you have return ["+car.display()+"]");
	}

	@Override
	public ICar getCar(String model) throws RemoteException {
		return rentedCars.get(model);
	}

	@Override
	public String displayCurrentlyRentedCars() throws RemoteException {
		StringJoiner sj = new StringJoiner("\n\t", "{\n", "\n}");
		for (ICar car : rentedCars.values()) {
			sj.add(car.display());
		}
		return sj.toString();
	}

	@Override
	public long getId() throws RemoteException {
		return id;
	}

}
