package fr.uge.corp.ifscars.cars;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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

	private static class StockCar {
		private final ICar car;
		private boolean available;

		public StockCar(ICar car, boolean available) {
			this.car = car;
			this.available = available;
		}

		@Override
		public String toString() {
			try {
				return car.display()+"->"+available;
			} catch (RemoteException e) {
				throw new RuntimeException(e);
			}
		}
	}

	private final Map<String, Map<Long, StockCar>> storage;

	/**
	 * Constructs a empty storage.
	 * @throws RemoteException
	 */
	public Storage() {
		storage = new HashMap<>();
	}

	/**
	 * Adds a car in the storage.
	 * @param car added.
	 * @throws RemoteException
	 */
	public void add(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		Map<Long, StockCar> stock = storage.computeIfAbsent(car.getModel(), __ -> new HashMap<>());
		stock.put(car.getId(), new StockCar(car, true));
	}


	/**
	 * Takes the {@link ICar} from the storage.
	 * @param car taken
	 * @return Return the taken {@link ICar}
	 * @throws RemoteException
	 */
	public ICar take(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		if (!storage.containsKey(car.getModel())) {
			throw new IllegalArgumentException("does not exist in storage");
		}
		if (car != null) {
			Map<Long, StockCar> sc = storage.get(car.getModel());
			sc.put(car.getId(), new StockCar(car, false));
			storage.put(car.getModel(), sc);
		}
		return car;
	}

	/**
	 * @param model of the {@link ICar}
	 * @return Gets a {@link ICar} from the model.
	 */
	public ICar getCar(String model, long id) {
		Objects.requireNonNull(model);
		if (!storage.containsKey(model)) {
			return null;
		}
		return storage.get(model).get(id).car;
	}
	
	public List<ICar> getCarsModel(String model) {
		Objects.requireNonNull(model);
		if (!storage.containsKey(model)) {
			return null;
		}
		return storage.get(model).values().stream().map(sc -> sc.car).collect(Collectors.toList());
	}
	
	public ICar getModel(String model) {
		Objects.requireNonNull(model);
		if (!storage.containsKey(model)) {
			return null;
		}
		return storage.get(model).values().stream().findFirst().get().car;
	}

	/**
	 * @return All cars in storage.
	 */
	public List<ICar> getAllCars()  {
		List<ICar> cars = new ArrayList<>();
		for (Map<Long, StockCar> stocks : storage.values()) {
			for (StockCar sc : stocks.values()) {
				cars.add(sc.car);
			}
		}
		return cars;
	}

	/**
	 * @param model of the {@link ICar}
	 * @return Verify's if the car is in the storage.
	 */
	public boolean exists(String model) {
		Objects.requireNonNull(model);
		return storage.containsKey(model);
	}

	/**
	 * @return Display's the storage.
	 * @throws RemoteException
	 */
	public String display() throws RemoteException {
		/*
		StringJoiner sj = new StringJoiner(", ", "<", ">");
		for (Map<Long, StockCar> stocks : storage.values()) {
			for (StockCar car : stocks.values()) {
				sj.add(car.toString());
			}
		}*/
		return storage.values().stream().
				flatMap(x -> x.values().stream()).map(StockCar::toString).
				collect(Collectors.joining(", ", "<", ">"));	
	}
	
	public String displayStockCar(ICar car) throws RemoteException {
		Objects.requireNonNull(car);
		return car.display()+" available:"+storage.get(car.getModel()).get(car.getId()).available;
	}

	/**
	 * @param model of the {@link ICar}.
	 * @return Verify's if the model of a {@link ICar} is available.
	 */
	public boolean availableModel(String model)  {
		/*
		if (!storage.containsKey(model)) {
			return false;
		}
		
		for (StockCar stockCar : storage.get(model).values()) {
			if (stockCar.available) {
				return true;
			}
		}
		*/
		return storage.containsKey(model) && storage.get(model).values().stream().anyMatch(p -> p.available);
	}
	
	public boolean availableCar(ICar car) throws RemoteException {
		return storage.containsKey(car.getModel()) && storage.get(car.getModel()).containsKey(car.getId())
				&& storage.get(car.getModel()).get(car.getId()).available;
	}

	/**
	 * @param car a {@link ICar}
	 * @return Verify's if the {@link ICar} is available.
	 * @throws RemoteException
	 */
	public boolean availableModel(ICar car) throws RemoteException {
		if (!storage.containsKey(car.getModel()) || !storage.get(car.getModel()).containsKey(car.getId())) {
			return false;
		}
		return storage.get(car.getModel()).get(car.getId()).available;
	}

	/**
	 * @param model of the {@link ICar}
	 * @return A List of all available {@link ICar} from model.
	 */
	public List<ICar> getAvailableCars(String model) {
		List<ICar> cars = new ArrayList<ICar>();
		for (StockCar stockCar : storage.get(model).values()) {
			if (stockCar.available) {
				cars.add(stockCar.car);
			}
		}
		return cars;
	}

}
