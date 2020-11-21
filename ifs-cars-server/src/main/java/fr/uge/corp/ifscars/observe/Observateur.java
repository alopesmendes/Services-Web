package fr.uge.corp.ifscars.observe;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.corp.ifscars.renting.IRentingService;

public class Observateur extends UnicastRemoteObject implements IObservateur {

	public Observateur() throws RemoteException {
	}

	@Override
	public void notifyChange(IRentingService service) throws RemoteException {

	}

}
