package fr.uge.corp.ifscars.renting;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.rating.IRating;
import fr.uge.corp.rentingapp.client.IClient;

/**
 * <p>The interface IRentingService will be the renting service.</p>
 * This service will allow the employee to rent a car but also get the cars back with a {@link Rating}.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IRentingService extends Remote {
	
	/**
	 * Allows a client to subcribe to the renting service.
	 * @param id of client
	 * @throws RemoteException
	 */
	public boolean subscribe(long id) throws RemoteException;
	
	
	/**
	 * @param model of the {@link ICar}
	 * @return Gets a {@link ICar} of this model.
	 * @throws RemoteException
	 */
	ICar getCar(String model) throws RemoteException;
	
	/**
	 * @return An array of all cars available.
	 * @throws RemoteException
	 */
	ICar[] getAllCars() throws RemoteException;
	
	
	/**
	 * Receives a renting request and notify's the server.
	 * The server will give the client the car if it's available.
	 * @param client that request the {@link ICar}.
	 * @param model of the {@link ICar}.
	 * @param id of the {@link ICar}.
	 * @throws RemoteException
	 */
	void receiveCarRentingRequest(IClient client, String model, long id) throws RemoteException;
	
	/**
	 * Receives a return request and notify's the server.
	 * The server will take back the {@link ICar} with it's {@link IRating}.
	 * And if there are {@link IClient} waiting for the {@link ICar} it will notify them.
	 * @param client that return the {@link ICar}
	 * @param car returned.
	 * @param rating of the {@link ICar}
	 * @throws RemoteException
	 */
	void receiveCarReturnRequest(IClient client, ICar car, IRating rating) throws RemoteException;
	
	
	/**
	 * @param model of the {@link ICar}
	 * @param id of the {@link ICar}
	 * @return Display's all {@link IRating} of a {@link ICar}.
	 * @throws RemoteException
	 */
	String displayRatings(String model, long id) throws RemoteException;
	
	
	/**
	 * @param model
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	String displayAverageRating(String model, long id) throws RemoteException;
	
	boolean isAvailable(String model, long id) throws RemoteException;
	
	/**
	 * @param model of the {@link ICar}
	 * @return Display's all the cars from a model.
	 * @throws RemoteException
	 */
	String displayCarsFromModel(String model) throws RemoteException;
		
	/**
	 * @return Display of the renting service.
	 * @throws RemoteException
	 */
	String display() throws RemoteException;
	
	
	
}
