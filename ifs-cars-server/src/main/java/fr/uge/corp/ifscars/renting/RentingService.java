package fr.uge.corp.ifscars.renting;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.corp.ifscars.cars.Storage;

@SuppressWarnings("serial")
public class RentingService extends UnicastRemoteObject implements IRentingService {
	private final Storage storage;

	public RentingService(Storage storage) throws RemoteException {
		this.storage = storage;
	}

	@Override
	public String display() throws RemoteException {
		return storage.display();
	}

}
