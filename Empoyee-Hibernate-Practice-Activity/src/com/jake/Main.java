package com.jake;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// setup to collect user data
		try (Scanner in = new Scanner(System.in)) {
			
			// prompt for user input
			System.out.println("What would you like to do?\n");
			System.out.println("1. Add a new employee");
			System.out.println("2. Retrieve an employee");
			System.out.println("3. Update an employee");
			System.out.println("4. Delete an employee");
			
			String input = in.nextLine();
			
			if(input.equals("1")) {
				CreateEmployee create = new CreateEmployee();
				
				System.out.println("Please enter employee information:\n");
				
				System.out.println("\nFirst Name: \n");
				String firstName = in.nextLine();
				
				System.out.println("\nLast Name: \n");
				String lastName = in.nextLine();
				
				System.out.println("\nCompany: \n");
				String company = in.nextLine();
				
				create.saveEmployee(firstName, lastName, company);
			}
			else if(input.equals("2")) {
				ReadEmployee read = new ReadEmployee();
				
				System.out.println("\nPlease enter an ID to retrieve: ");
				String id = in.nextLine();
				
				System.out.println(read.readStudent(id));
			}
			else if(input.equals("3")) {
				UpdateEmployee update = new UpdateEmployee();
				
				System.out.println("\nPlease enter an ID for an employee you would like to update: ");
				
				int id = Integer.parseInt(in.nextLine());
				
				System.out.println("\nFirst Name: \n");
				String firstName = in.nextLine();
				
				System.out.println("\nLast Name: \n");
				String lastName = in.nextLine();
				
				System.out.println("\nCompany: \n");
				String company = in.nextLine();
				
				update.updateEmployee(id, firstName, lastName, company);
				
			}
			else if(input.equals("4")) {
				DeleteEmployee delete = new DeleteEmployee();
				
				System.out.println("\nPlease enter an ID to delete: ");
				
				int id = Integer.parseInt(in.nextLine());
				
				delete.deleteEmployee(id);
			}
			else {
				
			}
		}
	}
}
