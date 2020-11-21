package fr.uge.corp.rentingapp.employee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.observe.IObservateur;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.ifscars.renting.IRentingService.RentStatus;

@SuppressWarnings("serial")
public class Employee extends UnicastRemoteObject implements IEmployee{
	public static class Observateur extends UnicastRemoteObject implements IObservateur{
		
		private Map<String, ICar> cars;
		private RentStatus status;
		private final long id;
		private String model;
		
		
		public Observateur(long id) throws RemoteException {
			this.id = id;
			cars = new HashMap<>();
			status = RentStatus.None;
			model = ICar.NULL_CAR.getModel();
		}

		@Override
		public void notifyChange(IRentingService service) throws RemoteException {
			switch (status) {
				case None: case Give:
					break;
				case Wait:
					ICar car = service.rentCar(id, model, true);
					status = car.isNull() ? RentStatus.Wait : RentStatus.Give;
					if (status == RentStatus.Give) {
						logger.log(Level.INFO, "You have rented "+car.getModel());
						cars.put(model, car);
					}
				default:
					break;
			}
		}
		
	}
	
	private final long id;
	private Observateur obs;
	private final IRentingService service;

	
	private static final Logger logger = Logger.getLogger(Employee.class.getName());
	
	public Employee(long id, IRentingService service) throws RemoteException {
		Objects.requireNonNull(service);
		if (id < 0) {
			
		}
		this.id = id;
		this.service = service;
		obs = new Observateur(id);
	}
	
	@Override
	public long getId() throws RemoteException {
		return id;
	}

	@Override
	public void request(String model) throws RemoteException {
		Objects.requireNonNull(model);
		Objects.requireNonNull(service);
		if (obs.cars.containsKey(model)) {
			logger.log(Level.INFO, "Already rented the model:"+model);
			return;
		}
		obs.model = model;
		
		obs.status = service.getStatus(model);
		switch (obs.status) {
			case Give:
				ICar car = service.rentCar(id, model, true);
				if (!car.isNull()) {
					logger.log(Level.INFO, "You have rented "+car.getModel());
					obs.cars.put(model, car);
				} else {
					obs.status = RentStatus.Wait;
					logger.log(Level.INFO, "Wait ...");
				}
				break;
			case Wait:
				logger.log(Level.INFO, "Wait ...");
				break;
			case None: 
				logger.log(Level.INFO, "The following model:<"+model+"> is not available");
			default:
				break;
		}
		
	}

	@Override
	public void returnCar(String model, int rating, int condition) throws RemoteException {
		if (obs.cars.containsKey(model)) {
			ICar car = obs.cars.get(model);
			car.addRating(rating, condition);
			service.returnCar(car);
			obs.status = RentStatus.None;
			logger.log(Level.INFO, "you have return "+car.getModel());
			obs.cars.remove(model);
		}
	}

	@Override
	public IObservateur getObservateur() throws RemoteException {
		return obs;
	}

	@Override
	public String allRentedCars() throws RemoteException {
		StringJoiner sj = new StringJoiner(", ", "<", ">");
		for (String m : obs.cars.keySet()) {
			sj.add(m);
		}
		return sj.toString();
	}

	@Override
	public void ratingCar(String model) throws RemoteException {
		ICar car = service.getCar(model);
		if (!car.isNull()) {
			logger.log(Level.INFO, car.display());
		}
		
	}

}
