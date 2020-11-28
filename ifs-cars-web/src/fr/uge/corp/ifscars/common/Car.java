package fr.uge.corp.ifscars.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * The class Car implements {@link ICar}.
 * 
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public class Car implements Serializable {
	
	private final long id;
	private final String model;
	private final long price;

	public Car(long id, String model, long price) {
		if (id < 0) {
			throw new IllegalArgumentException("id < 0");
		}
		Objects.requireNonNull(model);
		if (price <= 0) {
			throw new IllegalArgumentException("price <= 0");
		}
		this.id = id;
		this.model = model;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getModel() {
		return model;
	}

	public long getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "id:" + id + " model:" + model + " price:" + price + "EUR";
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Car)) {
			return false;
		}
		Car car = (Car) obj;
		return id == car.id && price == car.price && car.model.equals(model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, model, price);
	}

}
