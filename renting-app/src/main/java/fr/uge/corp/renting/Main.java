package fr.uge.corp.renting;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.rentingapp.client.Client;
import fr.uge.corp.rentingapp.client.IClient;
import fr.uge.corp.rentingapp.command.Command;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());


	public static void main(String[] args) {
		try {
			System.out.println("Renting app: Hello world!");
			IRentingService service = (IRentingService) Naming.lookup("rmi://localhost:1099/RentingServer");
			long id = Long.parseLong(args[0]);
			if (!service.subscribe(id)) {
				logger.log(Level.SEVERE, "id already used");
				return;
			}
			IClient client = new Client(Long.parseLong(args[0]));
			try (Scanner sc = new Scanner(System.in)) {
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if (Command.quit(line)) {
						logger.log(Level.INFO, "Log out");
						System.exit(0);
					}					
					Command.command(line, service, client);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
}
