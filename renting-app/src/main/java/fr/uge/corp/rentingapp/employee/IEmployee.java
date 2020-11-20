package fr.uge.corp.rentingapp.employee;

import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.observe.IObservateur;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.ifscars.renting.IRentingService.RentStatus;

/**
 * <p>The interface IEmployee will represent the different employees.</p>
 * An employee can request and return {@link ICar}, but also deposit and withdraw money. 
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IEmployee {
	
	long getId() throws RemoteException;
	
	RentStatus request(String model, IRentingService service) throws RemoteException;
	
	void returnCar(String model, IRentingService service) throws RemoteException;
	
	IObservateur getObservateur() throws RemoteException;
	
}
