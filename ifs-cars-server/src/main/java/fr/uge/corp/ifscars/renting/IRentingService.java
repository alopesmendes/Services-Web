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
	
	public static enum RentStatus {
		None, Wait, Give
	}
	
	ICar getCar(String model) throws RemoteException;
	
	ICar[] getAllCars() throws RemoteException;
		
	/**
	 * Returns 0 if the {@link ICar} corresponding to the model does not exist.
	 * Otherwise returns the price.
	 * @param model the model of the {@link ICar}
	 * @return 0 if does not exist otherwise the price.
	 * @throws RemoteException
	 */
	double getCarPrice(String model) throws RemoteException;
	
	void receiveCarRentingRequest(IClient client, String model) throws RemoteException;
	
	void receiveCarReturnRequest(IClient client, ICar car, IRating rating) throws RemoteException;
	
	String displayRatings(ICar car) throws RemoteException;
		
	String display() throws RemoteException;
	
	
	
}
