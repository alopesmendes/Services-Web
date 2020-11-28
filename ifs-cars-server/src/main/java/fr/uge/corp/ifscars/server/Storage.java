package fr.uge.corp.ifscars.server;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

import fr.uge.corp.ifscars.common.Car;

/**
 * Stores all cars and whether they are available or not. It is possible to add,
 * remove cars and mark existing ones as available/unavailable.
 * 
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 */
public class Storage {

	private static class StoredCar {
		private final Car car;
		private final boolean available;

		public StoredCar(Car car, boolean available) {
			this.car = car;
			this.available = available;
		}

		@Override
		public String toString() {
			return car + " available:" + available;
		}
	}

	private final Map<Long, StoredCar> storage = new ConcurrentHashMap<>();

	/**
	 * Adds a car in the storage.
	 * 
	 * @param car added
	 */
	public void add(Car car) {
		Objects.requireNonNull(car);
		storage.put(car.getId(), new StoredCar(car, true));
	}

	/**
	 * Removes a car from the storage.
	 * 
	 * @param model of the {@link Car}.
	 * @param id    of the {@link Car}
	 */
	public Car remove(long id) {
		StoredCar stored = storage.remove(id);
		return stored == null ? null : stored.car;
	}

	/**
	 * Attempts to acquire the {@link Car} from the storage. If successful, the car
	 * will be marked as unavailable.
	 * 
	 * @param id id of the car to acquire
	 * @return the taken {@link Car}, or null if not available
	 * @throws IllegalArgumentException if id does not exist in storage
	 */
	public Car acquire(long id) {
		StoredCar stored = storage.get(id);
		if (stored == null) {
			throw new NoSuchElementException("Car with id " + id + " not found");
		}
		if (!stored.available || !storage.replace(id, stored, new StoredCar(stored.car, false))) {
			return null;
		}
		return stored.car;
	}

	/**
	 * Attempts to release a {@link Car} previously acquired. If successful, the car
	 * will be marked as available again.
	 * 
	 * @param id id of the car to release
	 * @throws IllegalArgumentException if id does not exist in storage
	 */
	public void release(long id) {
		StoredCar stored = storage.get(id);
		if (stored == null) {
			throw new NoSuchElementException("Car with id " + id + " not found");
		}
		if (!stored.available) {
			storage.replace(id, stored, new StoredCar(stored.car, true));
		}
	}

	/**
	 * Returns the {@link Car} instance associated with this id. It does not check
	 * for availability and calling this method won't make the car unavailable.
	 * 
	 * @param id the id of the {@link Car}
	 * @return a {@link Car}
	 * @throws NoSuchElementException if id is not found
	 */
	public Car get(long id) {
		StoredCar stored = storage.get(id);
		if (stored == null) {
			throw new NoSuchElementException("Car with id " + id + " not found");
		}
		return stored.car;
	}

	/**
	 * Lists the cars in the storage.
	 * 
	 * @param modelFilter       if not null, only show cars for a specific model. If
	 *                          null, show any model
	 * @param showAvailableOnly if true, cars that are not available will not be
	 *                          returned
	 * @return the list of cars matching the request
	 */
	public Stream<Car> search(String modelFilter, boolean showAvailableOnly) {
		return storage.values().stream()
				.filter(stored -> (!showAvailableOnly || stored.available)
						&& (modelFilter == null || stored.car.getModel().equals(modelFilter)))
				.map(stored -> stored.car);
	}

}
