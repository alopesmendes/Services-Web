package fr.uge.corp.ifscars.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>The interface IClient will represent a client.</p>
 * A client can send and receive notifications.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IClient extends Remote {
	
	/**
	 * @return Getter for id.
	 * @throws RemoteException
	 */
	long getId() throws RemoteException;
	
	/**
	 * Callback invoked remotely by the server when a car renting request is
	 * fulfilled.
	 * 
	 * @param car the car received from server
	 * @throws RemoteException
	 */
	void onCarReceived(Car car) throws RemoteException;
}
