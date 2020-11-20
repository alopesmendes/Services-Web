package fr.uge.corp.rentingapp.employee;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.observe.IObservateur;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.ifscars.renting.IRentingService.RentStatus;

@SuppressWarnings("serial")
public class Employee extends UnicastRemoteObject implements IEmployee{
	public static class Observateur extends UnicastRemoteObject implements IObservateur{
		
		private ICar car;
		private RentStatus status;
		private long id;
		private String model;
		
		
		public Observateur(long id) throws RemoteException {
			this.id = id;
			car = ICar.NULL_CAR;
			status = RentStatus.None;
			model = car.getModel();
		}

		@Override
		public void notifyChange(IRentingService service) throws RemoteException {
			switch (status) {
				case None: case Give:
					break;
				case Wait:
					car = service.getCar(id, model, true);
					status = car.isNull() ? RentStatus.Wait : RentStatus.Give;
					if (status == RentStatus.Give) {
						logger.log(Level.INFO, "You have rented "+car.getModel());
					}
				default:
					break;
			}
			//logger.log(Level.INFO, "status:"+status+", car:"+car.getModel()+", id:"+id);
		}
		
	}
	
	private final long id;
	private Observateur obs;

	
	private static final Logger logger = Logger.getLogger(Employee.class.getName());
	
	public Employee(long id) throws RemoteException {
		this.id = id;
		obs = new Observateur(id);
	}
	
	@Override
	public long getId() throws RemoteException {
		return id;
	}

	@Override
	public RentStatus request(String model, IRentingService service) throws RemoteException {
		Objects.requireNonNull(model);
		Objects.requireNonNull(service);
		obs.model = model;
		
		obs.status = service.getStatus(model);
		switch (obs.status) {
			case Give:
				obs.car = service.getCar(id, model, true);
				if (!obs.car.isNull()) {
					logger.log(Level.INFO, "You have rented "+obs.car.getModel());
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
		
		return obs.status;
	}

	@Override
	public void returnCar(String model, IRentingService service) throws RemoteException {
		if (!obs.car.isNull()) {
			service.returnCar(obs.car);
			obs.status = RentStatus.None;
			logger.log(Level.INFO, "you have return "+obs.car.getModel());
		}
	}

	@Override
	public IObservateur getObservateur() throws RemoteException {
		return obs;
	}

}
