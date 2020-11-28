package fr.uge.corp.ifscars.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * <p>
 * The interface IRentingService will be the renting service.
 * </p>
 * This service will allow the employee to rent a car but also get the cars back
 * with a {@link Rating}.
 * 
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IRentingService extends Remote {

	/**
	 * Returns the {@link Car} instance associated with this id. It does not check
	 * for availability and calling this method won't make the car unavailable.
	 * 
	 * @param carId the id of the {@link Car}
	 * @return a {@link Car}
	 * @throws NoSuchElementException if id is not found
	 * @throws RemoteException
	 */
	Car getCar(long carId) throws RemoteException;

	/**
	 * Lists the cars offered by the renting service.
	 * 
	 * @param modelFilter       if not null, only show cars for a specific model. If
	 *                          null, show any model
	 * @param showAvailableOnly if true, cars that are not available will not be
	 *                          returned
	 * @param showRatedOnly     if true, cars that have no rating will not be
	 *                          returned
	 * @return the list of cars matching the request
	 * @throws RemoteException
	 */
	List<Car> list(String modelFilter, boolean showAvailableOnly, boolean showRatedOnly) throws RemoteException;

	/**
	 * Invoked remotely by the client to request the renting of a car. The server
	 * will later invoke {@link IClient#receiveCar(Car)} on the given client when
	 * the car is available.
	 * 
	 * @param client client that requests the car
	 * @param carId  id of the car.
	 * @throws RemoteException
	 */
	void receiveCarRentingRequest(IClient client, long carId) throws RemoteException;

	/**
	 * Invoked remotely by the client to return a car that was previously rent. The
	 * rating will be saved, and it will notify other clients that are waiting for
	 * this car, if any.
	 * 
	 * @param client client that returns the car
	 * @param carId  the id of the car returned.
	 * @param rating of the car
	 * @throws RemoteException
	 */
	void receiveCarReturnRequest(IClient client, long carId, Rating rating) throws RemoteException;

	/**
	 * Gets the ratings for the given car id.
	 * 
	 * @param carId the id of the car
	 * @return a list of ratings
	 * @throws RemoteException
	 */
	List<Rating> getRatingsForCar(long carId) throws RemoteException;
	
	/**
	 * Lists all cars that are currently rent by the given client.
	 * 
	 * @param client the client
	 * @return the list of cars rent by the client
	 * @throws RemoteException
	 */
	List<Car> listCarsRentByClient(IClient client) throws RemoteException;
}
