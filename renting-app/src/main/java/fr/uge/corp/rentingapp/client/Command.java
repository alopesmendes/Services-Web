package fr.uge.corp.rentingapp.client;

import java.rmi.RemoteException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.rating.Rating;
import fr.uge.corp.ifscars.renting.IRentingService;

public class Command {
	private static final Logger logger = Logger.getLogger(Command.class.getName());
	
	private static void commandReturn(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] subcommand = command.split(" ");
		if (!verifyCommand(subcommand.length == 3, "@return car rating condition")) {
			return;
		}
		ICar car = client.getCar(subcommand[0]);
		if (car == null) {
			logger.log(Level.WARNING, "You cannot return a car you don't have.");
			return;
		}
		double r, c;
		r = Double.parseDouble(subcommand[1]);
		c = Double.parseDouble(subcommand[2]);
		
		service.receiveCarReturnRequest(client, car, new Rating(r, c));
	}
	
	private static void commandRequest(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		service.receiveCarRentingRequest(client, command);
	}
	
	private static void commandRating(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		ICar car = service.getCar(command);
		if (car == null) {
			logger.log(Level.WARNING, "The following model:["+command+"] does not exist");
			return;
		}
		logger.log(Level.INFO, service.displayRatings(service.getCar(command)));
	}
	
	private static void commandAll(IClient client) throws RemoteException {
		logger.log(Level.INFO, client.displayCurrentlyRentedCars());
	}
	
	private static boolean verifyCommand(boolean verifyFormat, String format) {
		if (!verifyFormat) {
			logger.log(Level.WARNING, "Bad Format : "+format);
		}
		return verifyFormat;
	}

		
	public static void command(String line, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(line);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] command = line.split(" ", 2);
		if (command.length == 0) {
			return;
		}
		switch (command[0]) {
			case "@request":
				if (verifyCommand(command.length == 2, "@request [model:String]")) {
					commandRequest(command[1], service, client);
				}
				break;
			case "@rating":
				if (verifyCommand(command.length == 2, "@rating [model:String]")) {
					commandRating(command[1], service, client);
				}
				break;
			case "@all":
				if (verifyCommand(command.length == 1, "@all")) {
					commandAll(client);
				}
				break;
			case "@return":
				commandReturn(command[1], service, client);
				break;
			default:
				break;
		}
	}
	
	public static boolean quit(String line) {
		Objects.requireNonNull(line);
		return line.equals("@quit");
	}
}
