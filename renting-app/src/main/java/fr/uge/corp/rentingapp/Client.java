package fr.uge.corp.rentingapp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.common.Car;
import fr.uge.corp.ifscars.common.IClient;

public class Client extends UnicastRemoteObject implements IClient {
	
	private static final Logger LOGGER = Logger.getLogger(Client.class.getName());
	
	private final long id;
	
	public Client(long id) throws RemoteException {
		this.id = id;
	}
	
	@Override
	public long getId() throws RemoteException {
		return id;
	}

	@Override
	public void receiveCar(Car car) throws RemoteException {
		LOGGER.log(Level.INFO, "you have received " + car);
	}

	@Override
	public void returnCar(Car car) throws RemoteException {
		LOGGER.log(Level.INFO, "you have returned " + car);
	}

}
