package fr.uge.corp.renting;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.rating.Rating;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.rentingapp.client.Client;
import fr.uge.corp.rentingapp.client.IClient;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String[] args) {
		try {
			System.out.println("Renting app: Hello world!");
			IRentingService service = (IRentingService) Naming.lookup("rmi://localhost:1099/RentingServer");
			IClient client = new Client(Long.parseLong(args[0]));
			try (Scanner sc = new Scanner(System.in)) {
				String[] command = new String[] {""};
				while (!command[0].equals("@quit")) {
					if (sc.hasNextLine()) {
						command = sc.nextLine().split(" ", 2);
						if (command[0].equals("@return")) {
							String[] subcommand = command[1].split(" ");
							service.receiveCarReturnRequest(client, client.getCar(subcommand[0]), 
									new Rating(Double.parseDouble(subcommand[1]), Double.parseDouble(subcommand[2])));
						} 
						if (command.length == 2 && command[0].equals("@request")) {
							service.receiveCarRentingRequest(client, command[1]);
						}
						if (command.length == 2 && command[0].equals("@rating")) {
							logger.log(Level.INFO, service.displayRatings(service.getCar(command[1])));
						}
						
						if (command.length == 1 && command[0].equals("@all")) {
							logger.log(Level.INFO, client.displayCurrentlyRentedCars());
						}
					}
					Thread.sleep(1_000);
				}
				logger.log(Level.INFO, "end of program");
			}			
			//service.receiveCarReturnRequest(client, client.getCar("renault"), new Rating(2, 4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
