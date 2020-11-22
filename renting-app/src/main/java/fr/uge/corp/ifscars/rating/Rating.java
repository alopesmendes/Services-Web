package fr.uge.corp.ifscars.rating;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.corp.ifscars.cars.ICar;

/**
 * <p>The Rating class will allow the employees to rate the {@link ICar}.</p>
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public class Rating extends UnicastRemoteObject implements IRating{
	private final double rating;
	private final double condition;
	
	/**
	 * Constructs a Rating with rating and condition
	 * @param rating of the car.
	 * @param condition of the car.
	 * @throws RemoteException
	 */
	public Rating(double rating, double condition) throws RemoteException {
		if (rating < 0 || rating > 5) {
			throw new IllegalArgumentException("rating is < 0 or > 5");
		}
		if (condition < 0 || condition > 5) {
			throw new IllegalArgumentException("condition is < 0 or >5");
		}
		this.rating = rating;
		this.condition = condition;
	}
	
	@Override
	public double getRating() throws RemoteException {
		return rating;
	}



	@Override
	public double getCondition() throws RemoteException {
		return condition;
	}
	
	@Override
	public String display() throws RemoteException {
		return "rating:"+rating+"/5 , condition:"+condition+"/5";
	}
	
	
}
