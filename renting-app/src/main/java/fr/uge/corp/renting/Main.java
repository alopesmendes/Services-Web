package fr.uge.corp.renting;

import java.rmi.Naming;
import java.util.Scanner;

import fr.uge.corp.ifscars.renting.IRentingService;
import fr.uge.corp.rentingapp.employee.Employee;
import fr.uge.corp.rentingapp.employee.IEmployee;

public class Main {
	
	
	public static void main(String[] args) {
		try {
			System.out.println("Renting app: Hello world!");
			IRentingService service = (IRentingService) Naming.lookup("rmi://localhost:1099/RentingServer");
			IEmployee e1 = new Employee(Long.parseLong(args[0]));
			
			service.subscribe(e1.getObservateur());
			try (Scanner sc = new Scanner(System.in)) {
				String[] command = new String[] {""};
				while (!command[0].equals("@q")) {
					if (sc.hasNextLine()) { 
						command = sc.nextLine().split(" ", 2);
						if (command.length == 2 && command[0].equals("@r")) {
							e1.returnCar(command[1], service);
							service.notifyObservateurs();
						} 
						if (command.length == 2 && command[0].equals("@d")) {
							e1.request(command[1], service);
							service.notifyObservateurs();
						}
					}
					
					Thread.sleep(1_000);
				}
			}	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
