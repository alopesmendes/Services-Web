package fr.uge.corp.ifscars.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import fr.uge.corp.ifscars.cars.Car;
import fr.uge.corp.ifscars.cars.Storage;
import fr.uge.corp.ifscars.command.Command;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.ifscars.renting.RentingService;

public class Main {
	

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			Storage storage = new Storage();
			storage.add(new Car("renault", 1, 10_000));
			storage.add(new Car("renault", 2, 10_000));
			IRentingService service = new RentingService(storage);
			storage.add(new Car("toyota", 1, 20_000));
			Naming.rebind("rmi://localhost:1099/RentingServer", service);
			System.out.println("IfsCars server: Hello world!");
			try (Scanner scanner = new Scanner(System.in)) {
				while (scanner.hasNextLine()) {
					Command.command(scanner.nextLine(), storage);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
