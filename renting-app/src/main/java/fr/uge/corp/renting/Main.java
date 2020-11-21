package fr.uge.corp.renting;

import java.rmi.Naming;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.rentingapp.employee.Employee;
import fr.uge.corp.rentingapp.employee.IEmployee;

public class Main {
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	
	public static void main(String[] args) {
		try {
			System.out.println("Renting app: Hello world!");
			IRentingService service = (IRentingService) Naming.lookup("rmi://localhost:1099/RentingServer");
			IEmployee e1 = new Employee(Long.parseLong(args[0]), service);
			service.subscribe(e1.getObservateur());
			
			try (Scanner sc = new Scanner(System.in)) {
				String[] command = new String[] {""};
				while (!command[0].equals("@q")) {
					if (sc.hasNextLine()) { 
						command = sc.nextLine().split(" ", 2);
						if (command[0].equals("@return")) {
							String[] subcommand = command[1].split(" ");
							e1.returnCar(subcommand[0], Integer.parseInt(subcommand[1]), Integer.parseInt(subcommand[2]));
						} 
						if (command.length == 2 && command[0].equals("@request")) {
							e1.request(command[1]);
							
						}
						if (command.length == 2 && command[0].equals("@rating")) {
							e1.ratingCar(command[1]);
						}
						if (command.length == 1 && command[0].equals("@all")) {
							logger.log(Level.INFO, e1.allRentedCars());
						}
						service.notifyObservateurs();
						
					}
					
					Thread.sleep(1_000);
				}
			}	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
