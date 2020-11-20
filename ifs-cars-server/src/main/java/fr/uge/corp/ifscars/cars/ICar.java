package fr.uge.corp.ifscars.cars;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collections;
import java.util.List;

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
	
	
	
	List<Rating> ratings() throws RemoteException;
	
	
	/**
	 * @return false by default.
	 */
	default boolean isNull() throws RemoteException{
		return false;
	}
	
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
		public List<Rating> ratings() throws RemoteException {
			return Collections.unmodifiableList(Collections.emptyList());
		}
	}
}
