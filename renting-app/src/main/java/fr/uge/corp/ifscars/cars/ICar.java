package fr.uge.corp.ifscars.cars;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <p>The interface ICar will represent the different cars.</p>
 * Each ICar will have a model and a price. By default the price is in euro (EUR).
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface ICar extends Remote {
	/**
	 * @return Getter for model.
	 */
	String getModel() throws RemoteException;
	
	/**
	 * @return Getter for price.
	 */
	long getPrice() throws RemoteException;
	
	/**
	 * @return Getter for id.
	 */
	long getId() throws RemoteException;
	
	
	String display() throws RemoteException;
		
}
