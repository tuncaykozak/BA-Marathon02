package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import business.Accounting;
import business.EmployeeSorting;
import entities.FullTimeEmployee;
import entities.HourlyEmployee;


public class Company {
	
	

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		menu();
		
	}

	private static void menu() throws FileNotFoundException, ClassNotFoundException, IOException {
		
		EmployeeSorting employeeSorting = setData();
		selectionMenu(employeeSorting);	
		
	}

	private static EmployeeSorting setData() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		EmployeeSorting employeeSorting = new EmployeeSorting();
		
		try {
			DataSerilizator.dataSerilization();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		FullTimeEmployee employee1 = new FullTimeEmployee();
		try (ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream("employee1.txt"))) {
			employee1 = (FullTimeEmployee) objectInputStream1.readObject();
		}
		employeeSorting.getEmployees().add(employee1);
		
		HourlyEmployee employee2 = new HourlyEmployee();
		try (ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream("employee2.txt"))) {
			employee2 = (HourlyEmployee) objectInputStream2.readObject();
		}
		employeeSorting.getEmployees().add(employee2);
		
		HourlyEmployee employee3 = new HourlyEmployee();
		try (ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream("employee3.txt"))) {
			employee3 = (HourlyEmployee) objectInputStream3.readObject();
		}
		employeeSorting.getEmployees().add(employee3);
	
		FullTimeEmployee employee4 = new FullTimeEmployee();
		try (ObjectInputStream objectInputStream4 = new ObjectInputStream(new FileInputStream("employee4.txt"))) {
			employee4 = (FullTimeEmployee) objectInputStream4.readObject();
		}
		employeeSorting.getEmployees().add(employee4);
		
		FullTimeEmployee employee5 = new FullTimeEmployee();
		try (ObjectInputStream objectInputStream5 = new ObjectInputStream(new FileInputStream("employee5.txt"))) {
			employee5 = (FullTimeEmployee) objectInputStream5.readObject();
		}
		employeeSorting.getEmployees().add(employee5);
	
		HourlyEmployee employee6 = new HourlyEmployee();
		try (ObjectInputStream objectInputStream6 = new ObjectInputStream(new FileInputStream("employee6.txt"))) {
			employee6 = (HourlyEmployee) objectInputStream6.readObject();
		}
		employeeSorting.getEmployees().add(employee6);
	
		
		return employeeSorting;
	}
	
	private static void selectionMenu(EmployeeSorting employeeSorting) {
		
		Scanner keyboard = new Scanner(System.in);
		
		int selection = 0;
		
		while(selection != 5) {
			System.out.print("***WELCOME TO EMPLOYEE MANAGEMENT SYSTEM***\n" +
							   "1 - Show Employees\n" +
							   "2 - Show Employess sorted by Employee Name\n" +
							   "3 - Show Employess sorted by Hiring Date\n" +
							   "4 - Show Salaries (Accounting)\n" +
							   "5 - EXIT\n\n" + 
							   "Enter your operation : ");
			
				try {
					selection = keyboard.nextInt();
					if(selection < 1 || selection >6) {
						System.err.println("Invalid Selection!");
						System.out.println("-------------------------------------------------------");
					}else
						System.out.println("-------------------------------------------------------");
						operationSelected(selection, employeeSorting);
				} catch (InputMismatchException exception) {
					String wrongSelection = keyboard.next();
					System.err.println(wrongSelection + " is not a number!");
					System.out.println("-------------------------------------------------------");
				}		
			
		}	
		
	}

	private static void operationSelected(int selection, EmployeeSorting employeeSorting) {
		
		switch (selection) {
		case 1:
			 employeeSorting.getAllEmployees();
			 returningMenu();
			break;
		case 2:
			 employeeSorting.getEmployeesByName();
			 returningMenu();
			break;
		case 3 :
			 employeeSorting.getEmployeesByHiringDate();
			 returningMenu();
			 break;
		case 4 :
			 dateInput(employeeSorting);
			 returningMenu();
			 break;
		case 5 :
			turnOff();			 
		default:
			break;
		}
		
	}

	private static void returningMenu() {
		Scanner keyboard = new Scanner(System.in);
		
		char selection = 'N';
		
		while(selection == 'N') {
		System.out.print("\nDo you want to return Menu (Y / N) ");
		selection = keyboard.nextLine().equalsIgnoreCase("y") ? 'Y' : 'N';
		}
		
		System.out.print("Returning Menu.");
		int i = 0;
		while (i != 2) {
			i++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("\n---------------------------------------------------");
		
		
		
	}
	
	private static void dateInput(EmployeeSorting employeeSorting) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Date of accounting (YYYY MM DD) : ");
        int year = keyboard.nextInt();
        int month = keyboard.nextInt();
        int day = keyboard.nextInt();
        
        LocalDate date = LocalDate.of(year, month, day);
        
        System.out.println("---------------------------------------------------");
        
		Accounting.showSalaries(employeeSorting, date);
		
	}
	
	private static void turnOff() {
		int i = 3;
		while (i > 0) {
			System.out.println("Turning off in " + i + " sn");
			i--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println(System.lineSeparator().repeat(100));
		System.out.println("Turned OFF!");
		System.exit(0);

	}

}
