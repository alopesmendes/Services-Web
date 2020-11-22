package fr.uge.corp.rentingapp.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.uge.corp.ifscars.cars.ICar;

public interface IClient extends Remote {
	void refusedRequest(String msg) throws RemoteException;
	
	void receiveCar(ICar car) throws RemoteException;
	
	void returnCar(ICar car) throws RemoteException;
	
	ICar getCar(String model) throws RemoteException;
	
	String displayCurrentlyRentedCars() throws RemoteException;
}
