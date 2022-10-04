package entities;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private static int employeeCounter = 9996;

	private final String employeeId; 
	private final String firstName; 
	private final String lastName; 
	private LocalDate hiringDate;
	private LocalDate terminationDate;
	
	public Employee(String firstName, String lastName, LocalDate hiringDate, LocalDate terminationDate) {		
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.hiringDate = hiringDate;
		this.terminationDate = terminationDate;
		this.employeeId = setEmployeeId(hiringDate);
	
	}
	
		
	public Employee() {
		this.employeeId = "";
		this.firstName = "";
		this.lastName = "";
	}


	@Override
	public String toString() {
		return getEmployeeId() + " " + firstName + " " + lastName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	private static String setEmployeeId(LocalDate hiringDate) {
		int year = hiringDate.getYear();
		String id = String.format("%d/%04d", year, ((employeeCounter % 9999) + 1));
		employeeCounter++;
		
		return id;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getHiringDate() {
		return hiringDate;
	}

	public void setHiringDate(LocalDate hiringDate) {
		this.hiringDate = hiringDate;
	}

	public LocalDate getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(LocalDate terminationDate) {
		this.terminationDate = terminationDate;
	}

}
