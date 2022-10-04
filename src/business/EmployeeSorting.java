package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import business.comparators.OrderByEmployeeId;
import business.comparators.OrderByHiringDate;
import business.comparators.OrderByName;
import entities.Employee;

public class EmployeeSorting {
	
	private ArrayList<Employee> employees = new ArrayList<Employee>();	
	
	public  void getAllEmployees() { // default (ordered by EmployeeId)
	
		Collections.sort(employees, new OrderByEmployeeId());		
		showEmployees(employees);
		
	}
	
	public  void getEmployeesByName() {
				
		Collections.sort(employees, new OrderByName());		
		showEmployees("Employees are sorted by Name : ",employees);		
		
	}		

	public  void getEmployeesByHiringDate() {
		
		Collections.sort(employees, new OrderByHiringDate());		
		showEmployees("Employees are sorted by Hiring Date: ", employees);	
	}	
	
	private  void showEmployees(List<Employee> orderedEmployees) {
		for(Employee employee : orderedEmployees  ) {
			System.out.println(employee);
		}
		
		
	}
	
	private  void showEmployees(String sortingInfo, List<Employee> orderedEmployees) {
		System.out.println(sortingInfo + "\n");
		for(Employee employee : orderedEmployees  ) {
			System.out.println(employee);
		}
		
	}	
	
	public  List<Employee> getEmployees() {
		return employees;
	}	

}
