package fr.uge.corp.ifscars.cars;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
public class Storage {

	private final Map<String, Map<ICar, Boolean>> storage;

	/**
	 * Constructs a empty storage.
	 * @throws RemoteException
	 */
	public Storage() {
		storage = new HashMap<>();
	}

	public void add(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		Map<ICar, Boolean> stock = storage.computeIfAbsent(car.getModel(), __ -> new HashMap<>());
		stock.put(car, true);
	}


	public ICar take(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		if (!storage.containsKey(car.getModel())) {
			throw new IllegalArgumentException("does not exist in storage");
		}
		if (car != null) {
			Map<ICar, Boolean> sc = storage.get(car.getModel());
			sc.put(car, false);
			storage.put(car.getModel(), sc);
		}
		return car;
	}
	
	public ICar get(String model) {
		Objects.requireNonNull(model);
		if (!storage.containsKey(model)) {
			return null;
		}
		return storage.get(model).keySet().stream().findFirst().get();
	}
	
	public List<ICar> getAllCars()  {
		List<ICar> cars = new ArrayList<>();
		for (Map<ICar, Boolean> sc : storage.values()) {
			for (ICar car : sc.keySet()) {
				cars.add(car);
			}
		}
		return cars;
	}

	public boolean exists(String model) {
		Objects.requireNonNull(model);
		return storage.containsKey(model);
	}

	public String display() throws RemoteException {
		StringJoiner sj = new StringJoiner(", ", "<", ">");
		for (Map<ICar, Boolean> sc : storage.values()) {
			for (ICar car : sc.keySet()) {
				sj.add(car.display());
			}
		}
		return sj.toString();	
	}

	public boolean available(String model)  {
		for (boolean availables : storage.getOrDefault(model, new HashMap<ICar, Boolean>()).values()) {
			if (availables) {
				return true;
			}
		}
		return false;
	}

	public List<ICar> getAvailableCars(String model) {
		List<ICar> cars = new ArrayList<ICar>();
		for (Entry<ICar, Boolean> car : storage.get(model).entrySet()) {
			if (car.getValue()) {
				cars.add(car.getKey());
			}
		}
		return cars;
	}

}
