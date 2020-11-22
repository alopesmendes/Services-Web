package fr.uge.corp.rentingapp.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;

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
	 * Notification of refused request.
	 * @param msg explaining why the request was refused. 
	 * @throws RemoteException
	 */
	void refusedRequest(String msg) throws RemoteException;
	
	/**
	 * Will receive a {@link ICar} from the server.
	 * @param car received from server
	 * @throws RemoteException
	 */
	void receiveCar(ICar car) throws RemoteException;
	
	/**
	 * Will return a {@link ICar} to the server.
	 * @param car returned to server.
	 * @throws RemoteException
	 */
	void returnCar(ICar car) throws RemoteException;
	
	/**
	 * Gets the {@link ICar} rented by the client 
	 * @param model of the {@link ICar}
	 * @return a rented {@link ICar}
	 * @throws RemoteException
	 */
	ICar getCar(String model) throws RemoteException;
	
	/**
	 * @return Display's all currently rented cars.
	 * @throws RemoteException
	 */
	String displayCurrentlyRentedCars() throws RemoteException;
}
