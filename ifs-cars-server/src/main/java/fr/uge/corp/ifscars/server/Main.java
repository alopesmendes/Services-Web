package fr.uge.corp.ifscars.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import fr.uge.corp.ifscars.common.Car;
import fr.uge.corp.ifscars.common.IRentingService;

public class Main {
	

	public static void main(String[] args) throws Exception {
		LocateRegistry.createRegistry(1099);
		Storage storage = new Storage();
		storage.add(new Car(1, "renault", 1_000_000));
		storage.add(new Car(2, "renault", 1_000_000));
		IRentingService service = new RentingService(storage);
		storage.add(new Car(3, "toyota", 2_000_000));
		Naming.rebind("rmi://localhost:1099/RentingServer", service);
		System.out.println("Server started, exposed rmi://localhost:1099/RentingServer");
		try (Scanner scanner = new Scanner(System.in)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				try {
					Command.command(line, storage);
				} catch (RuntimeException e) {
					System.err.println("Error while handling command " + line);
					e.printStackTrace();
					continue;
				}
			}
		}
	}
}
