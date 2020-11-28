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
	
	public void addCarToCart(String cartName, long id) {
		ifsCars.addCarToCart(cartName, id);
	}
	
	public AvailableCar[] getCarsInCart(String cartName, String currency) throws RemoteException {
		return ifsCars.getCarsInCart(cartName, currency);
	}
	
	public void confirmPurchase(String cartName, String bankAccountName) throws RemoteException {
		ifsCars.confirmPurchase(cartName, bankAccountName);
	}
}
