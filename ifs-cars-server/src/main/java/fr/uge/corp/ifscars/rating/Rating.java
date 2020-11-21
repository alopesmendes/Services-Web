package fr.uge.corp.ifscars.rating;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import fr.uge.corp.ifscars.cars.ICar;

/**
 * <p>The Rating class will allow the employees to rate the {@link ICar}.</p>
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public class Rating extends UnicastRemoteObject implements Remote{
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
	
	/**
	 * @return Getter for rating
	 * @throws RemoteException
	 */
	public double getRating() throws RemoteException {
		return rating;
	}



	/**
	 * @return Getter for condition
	 * @throws RemoteException
	 */
	public double getCondition() throws RemoteException {
		return condition;
	}
	
	
	/**
	 * @param ratings the list of Ratings.
	 * @return the average Rating from the list.
	 * @throws RemoteException
	 */
	public static Rating average(List<Rating> ratings) throws RemoteException {
		double sumR = 0;
		double sumC = 0;
		for (Rating r : ratings) {
			sumR += r.rating;
			sumC += r.condition;
		}
		return new Rating(sumR / ratings.size(), sumC / ratings.size());
	}
	
	public String display() throws RemoteException {
		return "rating:"+rating+"/5 , condition:"+condition+"/5";
	}
	
	
}
