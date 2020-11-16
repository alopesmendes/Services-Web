package fr.uge.corp.ifscars.cars;

import java.util.Objects;

@SuppressWarnings("serial")
public class Car implements ICar {
	private final String model;
	private final double price;
	
	public Car(String model, double price) {
		Objects.requireNonNull(model);
		if (price <= 0) {
			throw new IllegalArgumentException("price is equal or inferior to 0");
		}
		this.model = model;
		this.price = price;
	}
	
	@Override
	public String getModel() {
		return model;
	}

	@Override
	public double getPrice() {
		return price;
	}

}
