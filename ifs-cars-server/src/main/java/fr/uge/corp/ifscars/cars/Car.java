package fr.uge.corp.ifscars.cars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import fr.uge.corp.ifscars.rating.Rating;

/**
 * The class Car implements {@link ICar}.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
@SuppressWarnings("serial")
public class Car extends UnicastRemoteObject implements ICar {
	private final String model;
	private final double price;
	private final List<Rating> ratings;
	
	public Car(String model, double price) throws RemoteException{
		Objects.requireNonNull(model);
		if (price <= 0) {
			throw new IllegalArgumentException("price is equal or inferior to 0");
		}
		this.model = model;
		this.price = price;
		ratings = new ArrayList<Rating>();
	}
	
	@Override
	public String getModel() throws RemoteException{
		return model;
	}

	@Override
	public double getPrice() throws RemoteException{
		return price;
	}


	@Override
	public Rating[] ratings() throws RemoteException {
		Rating[] rs = new Rating[ratings.size()];
		for (int i = 0; i < ratings.size(); i++) {
			rs[i] = ratings.get(i);
		}
		return rs;
	}


	@Override
	public Rating averageRating() throws RemoteException {
		double sumR = 0;
		double sumC = 0;
		for (Rating r : ratings) {
			sumR += r.getRating();
			sumC += r.getCondition();
		}
		return new Rating(sumR / ratings.size(), sumC / ratings.size());
	}

	@Override
	public void addRating(double rating, double condition) throws RemoteException {
		ratings.add(new Rating(rating, condition));
		
	}

	@Override
	public String display() throws RemoteException {
		return model + " " + averageRating().display();
	}

}
