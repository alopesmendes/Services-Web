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
	 * Will receive a {@link Car} from the server.
	 * @param car received from server
	 * @throws RemoteException
	 */
	void receiveCar(Car car) throws RemoteException;
	
	/**
	 * Will return a {@link Car} to the server.
	 * @param car returned to server.
	 * @throws RemoteException
	 */
	void returnCar(Car car) throws RemoteException;
}
