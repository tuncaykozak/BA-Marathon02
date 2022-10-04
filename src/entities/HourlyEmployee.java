package entities;

import java.time.LocalDate;

public class HourlyEmployee extends Employee {

	
	private static final long serialVersionUID = 1L;
	
	private double hourlyWage;
	private int[] hoursOfWorked;
	
	public HourlyEmployee() {
		
	}

	public HourlyEmployee(String firstName, String lastName, LocalDate hiringDate, LocalDate terminationDate, double hourlyWage) {
		super(firstName, lastName, hiringDate, terminationDate);
		this.hourlyWage = hourlyWage;

	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public int[] getHoursOfWorked() {
		return hoursOfWorked;
	}

	public void setHoursOfWorked(int[] hoursOfWorked) {
		this.hoursOfWorked = hoursOfWorked;
	}

}
