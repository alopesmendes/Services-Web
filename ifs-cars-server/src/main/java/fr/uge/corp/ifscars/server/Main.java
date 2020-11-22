package fr.uge.corp.ifscars.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.uge.corp.ifscars.cars.Car;
import fr.uge.corp.ifscars.cars.Storage;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.ifscars.renting.RentingService;

public class Main {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Storage storage = new Storage();
			storage.add(new Car("renault", 1, 10_000));
			storage.add(new Car("renault", 2, 10_000));
			storage.add(new Car("toyota", 1, 20_000));
			IRentingService service = new RentingService(storage);
			Naming.rebind("rmi://localhost:1099/RentingServer", service);
			System.out.println("IfsCars server: Hello world!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
