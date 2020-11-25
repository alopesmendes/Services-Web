package fr.uge.corp.ifscars.command;

import java.rmi.RemoteException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.cars.Car;
import fr.uge.corp.ifscars.cars.ICar;
import fr.uge.corp.ifscars.cars.Storage;

public class Command {
	private static final Logger logger = Logger.getLogger(Command.class.getName());
	
	private static void commandAddCar(String line, Storage storage) throws RemoteException {
		String[] commands = line.split(" ", 3);
		if (verifyCommand(commands.length == 3, "@add [id:long] [price:double] [model:String]")) {
			long id =  Long.parseLong(commands[0]);
			double price = Double.parseDouble(commands[1]);
			String model = commands[2];
			ICar car = new Car(model, id, price);
			storage.add(car);
			logger.log(Level.INFO, "Added ["+car.display()+"] to the storage");
		}
	}
	
	private static void commandRemoveCar(String line, Storage storage) throws RemoteException {
		String[] commands = line.split(" ", 2);
		if (verifyCommand(commands.length == 2, "@remove [id:long] [model:String]")) {
			long id =  Long.parseLong(commands[0]);
			String model = commands[1];
			ICar car = storage.remove(model, id);
			if (car == null) {
				logger.log(Level.INFO, "Car with id:"+id+", and model:"+model+" does not exist.");
			} else {
				logger.log(Level.INFO, "Removed ["+car.display()+"] of the storage");
			}
		}
	}
	
	private static void commandAll(Storage storage) throws RemoteException {
		logger.log(Level.INFO, storage.display());
	}
	
	private static boolean verifyCommand(boolean verifyFormat, String format) {
		if (!verifyFormat) {
			logger.log(Level.WARNING, "Bad Format : "+format);
		}
		return verifyFormat;
	}
	
	private static void commandNoArguments(String command, Storage storage) throws RemoteException {
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
		String msg = "\r\nName : @remove, Description : removes car from model, Arguments : [id:long] [model:String]\n\r"
				+ "Name : @all, Description : shows all currently cars\n\r"
				+ "Name : @add, Description : add a car to storage, Arguments : [id:long] [price:double] [model:String]t\n\r";
		logger.log(Level.INFO, msg);
				
	}
	
	private static void commandWithArguments(String command, String argument, Storage storage) throws RemoteException {
		switch (command) {
			case "@add": commandAddCar(argument, storage);
				break;
			case "@remove": commandRemoveCar(argument, storage);
				break;
			default:
				break;
		}
	}
	
	public static void command(String line, Storage storage) throws RemoteException {
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
