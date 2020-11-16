package fr.uge.corp.ifscars.cars;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * <p>The class Storage will stock all the {@link ICar} and the quantity.</p>
 * This class will also give cars if demanded and possible.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 * 
 */
@SuppressWarnings("serial")
public class Storage implements Serializable {
	
	static class StockCar {
		private final ICar car;
		private int quantity;
		
		/**
		 * Constructs that stocks a car and its quantity.
		 * @param car the {@link ICar}.
		 * @param quantity the number of {@link ICar} available.
		 */
		public StockCar(ICar car, int quantity) {
			this.car = car;
			this.quantity = quantity;
		}
	}
	
	private final Map<String, StockCar> storage;

	/**
	 * Constructs a empty storage.
	 */
	public Storage() {
		storage = new HashMap<>();
	}
	
	/**
	 * Adds a car and it's quantity from the car model.
	 * If the car already exists in the storage will increase it's quantity.
	 * @param car the {@link ICar}
	 * @param quantity the number of {@link ICar}
	 */
	public void add(ICar car, int quantity) {
		Objects.requireNonNull(car);
		if (quantity <= 0) {
			throw new IllegalArgumentException("quantity is equal or inferior to 0.");
		}
		storage.merge(car.getModel(), new StockCar(car, quantity), (a, b) -> new StockCar(car, a.quantity + b.quantity));
	}
	
	/**
	 * @param model of the {@link ICar}
	 * @return the {@link ICar} from it's model.
	 */
	public ICar get(String model) {
		return storage.get(model).car;
	}
	
	public String display() {
		StringJoiner sj = new StringJoiner(", ", "<", ">");
		for (StockCar sc : storage.values()) {
			sj.add(sc.car.getModel() +":"+ sc.quantity);
		}
		return sj.toString();	
	}
	
	
	
}
