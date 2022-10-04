package entities;

import java.time.LocalDate;

public class FullTimeEmployee extends Employee {

	private static final long serialVersionUID = 1L;
	
	private double monthlyWage;
	
	public FullTimeEmployee() {
		super();
	}
	
	public FullTimeEmployee(String firstName, String lastName, LocalDate hiringDate, LocalDate terminationDate, double monthlyWage) {
		super(firstName, lastName, hiringDate, terminationDate);
		this.monthlyWage = monthlyWage;
	}
	
	public double getMonthlyWage() {
		return monthlyWage;
	}

	public void setMonthlyWage(double monthlyWage) {
		this.monthlyWage = monthlyWage;
	}

}
