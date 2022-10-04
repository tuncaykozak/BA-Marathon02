package business;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.stream.Collectors;

import entities.Employee;
import entities.FullTimeEmployee;
import entities.HourlyEmployee;

public class Accounting {

	public static void showSalaries(EmployeeSorting employees, LocalDate date) {
		
		
		ArrayList<Employee> currentEmployees = (ArrayList<Employee>) employees.getEmployees()
				.stream().filter(employee -> employee.getTerminationDate().isAfter(date) && employee.getHiringDate().isBefore(date) )
				.collect(Collectors.toList());
		
		for (Employee employee : currentEmployees) {
			
			double salary = 0;
			
			if(employee instanceof FullTimeEmployee)
				salary = ((FullTimeEmployee) employee).getMonthlyWage() * 1.25;
			
			if(employee instanceof HourlyEmployee)
				salary = (((HourlyEmployee) employee).getHourlyWage() * ((HourlyEmployee) employee).getHoursOfWorked()[(int) (ChronoUnit.MONTHS.between(employee.getHiringDate(), date))]) * 1.08;
			
			System.out.println(employee.toString() + " Salary = " + salary);
			
			
		}
		
	}

}
