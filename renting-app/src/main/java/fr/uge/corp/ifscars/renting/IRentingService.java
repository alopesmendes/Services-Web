package fr.uge.corp.ifscars.renting;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.observe.IObserve;
import fr.uge.corp.ifscars.rating.Rating;

/**
 * <p>The interface IRentingService will be the renting service.</p>
 * This service will allow the employee to rent a car but also get the cars back with a {@link Rating}.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IRentingService extends Remote, IObserve {
	
	public static enum RentStatus {
		None, Wait, Give
	}
	
	/**
	 * The method will verify if the car exists firstly.
	 * Then it will verify it there's the certain model still in stock and return it.
	 * Otherwise it return the NullCar and puts the id on the waiting list.
	 * @param id asking for the {@link ICar}
	 * @param model of the {@link ICar}
	 * @param money deposit for the {@link ICar}
	 * @return the car if all conditions are met otherwise NullCar.
	 * @throws RemoteException
	 */
	ICar getCar(long id, String model, boolean condition) throws RemoteException;
	
		
	/**
	 * Returns 0 if the {@link ICar} corresponding to the model does not exist.
	 * Otherwise returns the price.
	 * @param model the model of the {@link ICar}
	 * @return 0 if does not exist otherwise the price.
	 * @throws RemoteException
	 */
	double getCarPrice(String model) throws RemoteException;
	
	
	/**
	 * Will get the status of the following model.
	 * @param model of {@link ICar}
	 * @return Getter for status from model
	 * @throws RemoteException
	 */
	RentStatus getStatus(String model) throws RemoteException;
		
	/**
	 * Returns a rent car.
	 * @param car the {@link ICar} returned.
	 */
	void returnCar(ICar car) throws RemoteException;
	
	void notifyObservateurs() throws RemoteException;
		
	String display() throws RemoteException;
	
}
