package fr.uge.corp.ifscars.rating;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;


/**
 * <p>The interface IRating will be the rate a {@link ICar}.</p>
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
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
	
	/**
	 * @return String of rating.
	 * @throws RemoteException
	 */
	String display() throws RemoteException;
	
	
}
