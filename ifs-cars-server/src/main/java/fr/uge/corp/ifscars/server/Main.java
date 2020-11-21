package fr.uge.corp.ifscars.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import fr.uge.corp.ifscars.cars.Car;
import fr.uge.corp.ifscars.cars.IStorage;
import fr.uge.corp.ifscars.cars.Storage;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.ifscars.renting.RentingService;

public class Main {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			IStorage storage = new Storage();
			storage.add(new Car("renault", 10_000), 2);
			storage.add(new Car("toyota", 20_000), 5);
			IRentingService service = new RentingService(storage);
			Naming.rebind("rmi://localhost:1099/RentingServer", service);
			System.out.println("IfsCars server: Hello world!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
