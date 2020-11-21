package fr.uge.corp.ifscars.cars;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * <p>The interface IStorage will stock all the {@link ICar} and the quantity.</p>
 * This interface will also give cars if demanded and possible.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 * 
 */
public interface IStorage extends Remote {
	/**
	 * Adds a car and it's quantity from the car model.
	 * If the car already exists in the storage will increase it's quantity.
	 * @param car the {@link ICar}
	 * @param quantity the number of {@link ICar}
	 * @throws RemoteException
	 */
	void add(ICar car, int quantity) throws RemoteException;
	
	/**
	 * Getter for {@link ICar} from model.
	 * @param model of the {@link ICar}
	 * @return the {@link ICar} from it's model.
	 * @throws RemoteException
	 */
	ICar take(String model) throws RemoteException;
	
	/**
	 * @param model
	 * @return Getter of car from model.
	 * @throws RemoteException
	 */
	ICar get(String model) throws RemoteException;
	
	/**
	 * @return Gets all cars in stock.
	 * @throws RemoteException
	 */
	List<ICar> getAllCars() throws RemoteException;
	
	/**
	 * @param model of the {@link ICar}
	 * @return true if the model exists in the storage.
	 * @throws RemoteException
	 */
	boolean exists(String model) throws RemoteException;
	
	String display() throws RemoteException;
	
}
