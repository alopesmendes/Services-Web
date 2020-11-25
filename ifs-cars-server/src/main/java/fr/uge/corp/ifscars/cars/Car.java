package fr.uge.corp.ifscars.cars;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

/**
 * The class Car implements {@link ICar}.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public class Car extends UnicastRemoteObject implements ICar {
	private final String model;
	private final double price;
	private final long id;
	
	public Car(String model, long id, double price) throws RemoteException{
		Objects.requireNonNull(model);
		if (price <= 0) {
			throw new IllegalArgumentException("price <= 0");
		}
		if (id < 0) {
			throw new IllegalArgumentException("id < 0");
		}
		this.model = model;
		this.price = price;
		this.id = id;
	}
	
	@Override
	public String getModel() throws RemoteException {
		return model;
	}

	@Override
	public double getPrice() throws RemoteException{
		return price;
	}

	@Override
	public String display() throws RemoteException{
		return "id:"+id+" model:"+model+" price:"+price+"EUR";
	}

	@Override
	public long getId() throws RemoteException{
		return id;
	}
	
	@Override
	public int hashCode() {
		return model.hashCode() ^ Long.hashCode(id) ^ Double.hashCode(price);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Car)) {
			return false;
		}
		Car car = (Car) obj;
		return id == car.id && price == car.price && car.model.equals(model);
	}

}
