package fr.uge.corp.ifscars.web;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.rpc.ServiceException;

import com.currencysystem.webservices.currencyserver.CurncsrvReturnRate;
import com.currencysystem.webservices.currencyserver.CurrencyServerLocator;
import com.currencysystem.webservices.currencyserver.CurrencyServerSoap;

import fr.uge.corp.ifscars.common.IRentingService;
import fr.uge.corp.ifscars.common.Rating;

public class IfsCars {

	private final CurrencyServerSoap currencyServer;
	private final IRentingService rentingService;
	private final Set<AvailableCar> cart = ConcurrentHashMap.newKeySet();
	
	public IfsCars() throws ServiceException, MalformedURLException, RemoteException, NotBoundException {
		this.currencyServer = new CurrencyServerLocator().getCurrencyServerSoap();
		this.rentingService = (IRentingService) Naming.lookup("rmi://localhost:1099/RentingServer");
	}
	
	public AvailableCar[] getAvailableCars(String currency) throws RemoteException {
		return rentingService.list(null, true, true).stream()
				.map(car -> {
					try {
						AverageRating avg = calculateAverageRating(rentingService.getRatingsForCar(car.getId()));
						return AvailableCar.from(car, avg, price -> fromEUR(currency, price));
					} catch (RemoteException e) {
						throw new RuntimeException(e);
					}
				})
				.toArray(AvailableCar[]::new);
	}
	
	public void addCarToCart(String model, long id) {
		
	}
	
	public AvailableCar[] getCarsInCart(String currency) {
		return null;
	}
	
	public void confirmPurchase(String bankAccountName) {
		
	}
	
	private long fromEUR(String currency, long amount) {
		if (currency.equals("EUR")) {
			return amount;
		}
		try {
			return ((Double) currencyServer.convert("", "EUR", currency, amount, true, "",
					CurncsrvReturnRate.curncsrvReturnRateNumber, "", "")).longValue();
		} catch (RemoteException e) {
			System.out.println("conversion error");
			throw new RuntimeException(e);
		}
	}
	
	private static AverageRating calculateAverageRating(List<Rating> ratings) {
		if (ratings.isEmpty()) {
			throw new IllegalStateException("Empty ratings");
		}
		long sumScore = 0, sumCond = 0;
		for (Rating r : ratings) {
			sumScore += r.getScore();
			sumCond += r.getCondition();
		}
		return new AverageRating(sumScore / (double) ratings.size(), sumCond / (double) ratings.size());
	}
}
