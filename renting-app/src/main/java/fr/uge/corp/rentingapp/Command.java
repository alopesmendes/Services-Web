package fr.uge.corp.rentingapp;

import java.rmi.RemoteException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.common.IClient;
import fr.uge.corp.ifscars.common.IRentingService;
import fr.uge.corp.ifscars.common.Rating;

public class Command {
	private static final Logger logger = Logger.getLogger(Command.class.getName());
	
	private static void commandReturn(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] subcommand = command.split(" ");
		if (!verifyCommand(subcommand.length == 3, "@return [id:long] [rating:int] [condition:int]")) {
			return;
		}
		int r, c;
		long carId = Long.parseLong(subcommand[0]);
		r = Integer.parseInt(subcommand[1]);
		c = Integer.parseInt(subcommand[2]);
		service.receiveCarReturnRequest(client, carId, new Rating(r, c));
	}
	
	private static void commandRequest(String command, IRentingService service, IClient client) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		Objects.requireNonNull(client);
		String[] subcommand = command.split(" ", 2);
		if (!verifyCommand(subcommand.length == 1, "@request [carId:long]")) {
			return;
		}
		service.receiveCarRentingRequest(client, Long.parseLong(subcommand[0]));
	}
	
	private static void commandShowCarsFromModel(String command, IRentingService service) throws RemoteException {
		Objects.requireNonNull(command);
		Objects.requireNonNull(service);
		logger.log(Level.INFO, service.list(command, true, false).toString());
	}
	
	private static void commandHelp() {
		String msg = "\n\rName : @return, Description : returns a car with a rating, Arguments : [id:long] [rating:int] [condition:int]\n\r"
				+ "Name : @rating, Description : show the rating of a car, Arguments : [id:long]\n\r"
				+ "Name : @request, Description : request a car, Arguments : [carId:long]\n\r"
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
		if (!verifyCommand(subcommand.length == 1, "@rating [id:long]")) {
			return;
		}
		long carId = Long.parseLong(subcommand[0]);
		logger.log(Level.INFO, service.getRatingsForCar(carId).toString());
	}
	
	private static void commandAll(IRentingService service, IClient client) throws RemoteException {
		logger.log(Level.INFO, service.listCarsRentByClient(client).toString());
	}
	
	private static boolean verifyCommand(boolean verifyFormat, String format) {
		if (!verifyFormat) {
			logger.log(Level.WARNING, "Bad Format : "+format);
		}
		return verifyFormat;
	}
	
	
	private static void commandNoArgument(String command, IRentingService service, IClient client) throws RemoteException {
		switch (command) {
			case "@all": commandAll(service, client);
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
			case "@show": commandShowCarsFromModel(argument, service);
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
