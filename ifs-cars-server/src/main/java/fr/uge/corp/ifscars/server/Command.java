package fr.uge.corp.ifscars.server;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.uge.corp.ifscars.common.Car;

public class Command {
	private static final Logger logger = Logger.getLogger(Command.class.getName());
	
	private static void commandAddCar(String line, Storage storage) {
		String[] commands = line.split(" ", 3);
		if (verifyCommand(commands.length == 3, "@add [id:long] [price:long] [model:String]")) {
			long id = Long.parseLong(commands[0]);
			long price = Long.parseLong(commands[1]);
			String model = commands[2];
			Car car = new Car(id, model, price);
			storage.add(car);
			logger.log(Level.INFO, "Added [" + car + "] to the storage");
		}
	}
	
	private static void commandRemoveCar(String line, Storage storage) {
		String[] commands = line.split(" ", 2);
		if (verifyCommand(commands.length == 1, "@remove [id:long]")) {
			long id = Long.parseLong(commands[0]);
			Car car = storage.remove(id);
			if (car == null) {
				logger.log(Level.INFO, "Car with id:" + id + " does not exist.");
			} else {
				logger.log(Level.INFO, "Removed [" + car + "] of the storage");
			}
		}
	}
	
	private static void commandAll(Storage storage) {
		logger.log(Level.INFO, storage.search(null, false)
				.map(Car::toString)
				.collect(Collectors.joining(", ", "[", "]")));
	}
	
	private static boolean verifyCommand(boolean verifyFormat, String format) {
		if (!verifyFormat) {
			logger.log(Level.WARNING, "Bad Format : " + format);
		}
		return verifyFormat;
	}
	
	private static void commandNoArguments(String command, Storage storage) {
		switch (command) {
			case "@all": commandAll(storage);
				break;
			case "@help": commandHelp();
				break;
			default:
				break;
		}
	}
	
	private static void commandHelp() {
		String msg = "\r\nName : @remove, Description : removes car from model, Arguments : [id:long]\n\r"
				+ "Name : @all, Description : shows all currently cars\n\r"
				+ "Name : @add, Description : add a car to storage, Arguments : [id:long] [price:long] [model:String]t\n\r";
		logger.log(Level.INFO, msg);
				
	}
	
	private static void commandWithArguments(String command, String argument, Storage storage) {
		switch (command) {
			case "@add": commandAddCar(argument, storage);
				break;
			case "@remove": commandRemoveCar(argument, storage);
				break;
			default:
				break;
		}
	}
	
	public static void command(String line, Storage storage) {
		Objects.requireNonNull(storage);
		Objects.requireNonNull(line);
		String[] commands = line.split(" ", 2);
		if (commands.length == 0) {
			return;
		} else if (commands.length == 1) {
			commandNoArguments(commands[0], storage);
		} else {
			commandWithArguments(commands[0], commands[1], storage);
		}
		
	}
}	
