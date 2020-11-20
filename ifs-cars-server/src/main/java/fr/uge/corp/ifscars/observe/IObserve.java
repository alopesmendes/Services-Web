package fr.uge.corp.ifscars.observe;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IObserve extends Remote {
	void subscribe(IObservateur obs) throws RemoteException;
}
