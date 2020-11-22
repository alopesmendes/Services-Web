package fr.uge.corp.ifscars.rating;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRating extends Remote {
	/**
	 * @return Getter for rating
	 * @throws RemoteException
	 */
	double getRating() throws RemoteException;
	
	/**
	 * @return Getter for condition
	 * @throws RemoteException
	 */
	double getCondition() throws RemoteException;
	
	String display() throws RemoteException;
	
	
}
