package fr.uge.corp.ifscars.cars;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import fr.uge.corp.ifscars.rating.Rating;

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
	double getPrice() throws RemoteException;
	
	
	
	/**
	 * @return An array of all ratings.
	 * @throws RemoteException
	 */
	Rating[] ratings() throws RemoteException;
	
	/**
	 * @return the average {@link Rating} of the car.
	 * @throws RemoteException
	 */
	Rating averageRating() throws RemoteException;
	

	/**
	 * @param rating
	 * @param condition
	 * @throws RemoteException
	 */
	void addRating(double rating, double condition) throws RemoteException;
	
	/**
	 * @return false by default.
	 */
	default boolean isNull() throws RemoteException{
		return false;
	}
	
	String display() throws RemoteException;
	
	/**
	 * The car that represent the Null Car.
	 */
	static ICar NULL_CAR = NullCar.create();	
	
	/**
	 * <p>The class NullCar will represent the null object of {@link ICar}.</p>
	 * The method isNull will return true.
	 * @author Ailton LOPES MENDES
	 * @author Gérald LIN
	 * @author Alexandre MIRANDA
	 * @version 1.8
	 *
	 */
	@SuppressWarnings("serial")
	static class NullCar extends UnicastRemoteObject implements ICar {
		
		private NullCar() throws RemoteException {
		}
		
		private static NullCar create() {
			try {
				return new NullCar();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public String getModel() throws RemoteException{
			return "";
		}

		@Override
		public double getPrice() throws RemoteException{
			return 0;
		}
		
		/**
		 * @return true is NullCar
		 */
		@Override
		public boolean isNull() throws RemoteException{
			return true;
		}

		@Override
		public Rating[] ratings() throws RemoteException {
			return new Rating[1];
		}

	

		@Override
		public Rating averageRating() throws RemoteException {
			return new Rating(0, 0);
		}

		@Override
		public void addRating(double rating, double condition) throws RemoteException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String display() throws RemoteException {
			// TODO Auto-generated method stub
			return "";
		}
	}
}
