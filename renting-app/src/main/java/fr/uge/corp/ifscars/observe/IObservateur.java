package fr.uge.corp.ifscars.observe;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.renting.IRentingService;

public interface IObservateur extends Remote {
	void notifyChange(IRentingService service) throws RemoteException;
}
