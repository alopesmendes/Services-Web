package fr.uge.corp.rentingapp;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.common.IClient;
import fr.uge.corp.ifscars.common.IRentingService;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) throws Exception {
		IRentingService service = (IRentingService) Naming.lookup("rmi://localhost:1099/RentingServer");
		long id = Long.parseLong(args[0]);
		IClient client = new Client(id);
		logger.info("Client started");
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (Command.quit(line)) {
					logger.log(Level.INFO, "Log out");
					System.exit(0);
					return;
				}
				try {
					Command.command(line, service, client);
				} catch (RuntimeException e) {
					System.err.println("Error while handling command " + line);
					e.printStackTrace();
					continue;
				}
			}
		}
	}
}
