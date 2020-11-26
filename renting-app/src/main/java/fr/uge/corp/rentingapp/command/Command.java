package fr.uge.corp.rentingapp.command;

import java.rmi.RemoteException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.rating.Rating;
import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.rentingapp.client.IClient;

public class Command {
	private static final Logger logger = Logger.getLogger(Command.class.getName());
	
	private static void commandReturn(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] subcommand = command.split(" ");
		if (!verifyCommand(subcommand.length == 4, "@return [rating:double] [condition:double] [id:long] [model:String]")) {
			return;
		}
		ICar car = client.getCar(subcommand[3], Long.parseLong(subcommand[2]));
		if (car == null) {
			logger.log(Level.INFO, "You cannot return a car you don't have.");
			return;
		}
		int r, c;
		r = Integer.parseInt(subcommand[0]);
		c = Integer.parseInt(subcommand[1]);
		
		service.receiveCarReturnRequest(client, car, new Rating(r, c));
	}
	
	private static void commandRequest(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] subcommand = command.split(" ", 2);
		if (!verifyCommand(subcommand.length == 2, "@request [carId:long] [model:string]")) {
			return;
		}
		service.receiveCarRentingRequest(client, subcommand[1], Long.parseLong(subcommand[0]));
	}
	
	private static void commandShowCarsFromModel(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		if (service.getCar(command) == null) {
			logger.log(Level.INFO, "No car with the model:"+command+" exists");
			return;
		}
		logger.log(Level.INFO, service.displayCarsFromModel(command));
	}
	
	private static void commandHelp() {
		String msg = "\n\rName : @return, Description : returns a car with a rating, Arguments : [rating:double] [condition:double] [id:long] [model:String]\n\r"
				+ "Name : @rating, Description : show the rating of a car, Arguments : [id:long] [model:String]\n\r"
				+ "Name : @request, Description : request a car, Arguments : [carId:long] [model:string]\n\r"
				+ "Name : @show, Description : shows all cars of same model, Arguments : [model:String]\n\r"
				+ "Name : @all, Description : shows all currently rented cars\n\r"
				+ "Name : @quit, Description : closes client\n\r";
		logger.log(Level.INFO, msg);
				
	}
	
	private static void commandRating(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		
		String[] subcommand = command.split(" ", 2);
		if (!verifyCommand(subcommand.length == 2, "@rating [id:long] [model:String]")) {
			return;
		}
		if (service.getCar(subcommand[1]) == null) {
			logger.log(Level.INFO, "No car with the model:"+subcommand[1]+" exists");
			return;
		}
		logger.log(Level.INFO, service.displayRatings(subcommand[1], Long.parseLong(subcommand[0])));
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
	
	
	private static void commandNoArgument(String command, IRentingService service, IClient client) throws RemoteException {
		switch (command) {
			case "@all": commandAll(client);
				break;
			case "@help": commandHelp();
				break;
			default:
				break;
		}
	}
	
	private static void commandWithArgument(String command, String argument, IRentingService service, IClient client) throws RemoteException {
		switch (command) {
			case "@request": commandRequest(argument, service, client);
				break;
			case "@rating": commandRating(argument, service, client);
				break;
			case "@return": commandReturn(argument, service, client);
				break;
			case "@show": commandShowCarsFromModel(argument, service, client);
				break;
			default:
				break;
		}
	}
		
	public static void command(String line, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(line);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] command = line.split(" ", 2);
		if (command.length == 0) {
			return;
		} else if (command.length == 1) {
			commandNoArgument(command[0], service, client);
		} else {
			commandWithArgument(command[0], command[1], service, client);
		}
	}
	
	public static boolean quit(String line) {
		Objects.requireNonNull(line);
		
		return line.equals("@quit");
	}
}
