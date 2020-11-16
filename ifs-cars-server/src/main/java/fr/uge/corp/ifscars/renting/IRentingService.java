package fr.uge.corp.ifscars.renting;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.rating.Rating;

/**
 * <p>The interface IRentingService will be the renting service.</p>
 * This service will allow the employee to rent a car but also get the cars back with a {@link Rating}.
 * @author Ailton LOPES MENDES
 * @author Gérald LIN
 * @author Alexandre MIRANDA
 * @version 1.8
 *
 */
public interface IRentingService extends Remote {
	String display() throws RemoteException;
}
