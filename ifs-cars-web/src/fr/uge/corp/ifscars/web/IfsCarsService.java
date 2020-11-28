package fr.uge.corp.ifscars.web;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class IfsCarsService {
	
	private final IfsCars ifsCars;
	
	public IfsCarsService() throws ServiceException, MalformedURLException, RemoteException, NotBoundException {
		this.ifsCars = new IfsCars();
	}

	public AvailableCar[] getAvailableCars(String currency) throws RemoteException {
		return ifsCars.getAvailableCars(currency);
	}
	
	public void addCarToCart(String model, long id) {
		ifsCars.addCarToCart(model, id);
	}
	
	public AvailableCar[] getCarsInCart(String currency) {
		return ifsCars.getCarsInCart(currency);
	}
	
	public void confirmPurchase(String bankAccountName) {
		ifsCars.confirmPurchase(bankAccountName);
	}
}
