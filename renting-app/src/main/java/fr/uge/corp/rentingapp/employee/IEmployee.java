package fr.uge.corp.rentingapp.employee;

import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.observe.IObservateur;

/**
 * <p>The interface IEmployee will represent the different employees.</p>
 * An employee can request and return {@link ICar}, but also deposit and withdraw money. 
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IEmployee {
	
	/**
	 * @return Getter for id.
	 * @throws RemoteException
	 */
	long getId() throws RemoteException;
	
	/**
	 * This method will request a car and give it if it's possible.
	 * @param model of the {@link ICar}
	 * @throws RemoteException
	 */
	void request(String model) throws RemoteException;
	
	/**
	 * @param model
	 * @throws RemoteException
	 */
	void returnCar(String model, int rating, int condition) throws RemoteException;
	
	/**
	 * Asks to display the rating.
	 * @param model
	 * @throws RemoteException
	 */
	void ratingCar(String model) throws RemoteException;
	
	/**
	 * @return Getter for observateur.
	 * @throws RemoteException
	 */
	IObservateur getObservateur() throws RemoteException;
	
	
	/**
	 * @return a String with all rented cars.
	 * @throws RemoteException
	 */
	String allRentedCars() throws RemoteException;
}
