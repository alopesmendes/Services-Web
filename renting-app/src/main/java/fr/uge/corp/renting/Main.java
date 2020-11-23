package fr.uge.corp.renting;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.rentingapp.client.Client;
import fr.uge.corp.rentingapp.client.Command;
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
				while (true) {
					if (sc.hasNextLine()) {
						if (Command.quit(command[0])) {
							break;
						}					
						Command.command(sc.nextLine(), service, client);
					}
				}
				logger.log(Level.INFO, "end of program");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
