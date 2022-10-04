package test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import entities.FullTimeEmployee;
import entities.HourlyEmployee;

public class DataSerilizator {
	
	public static void dataSerilization() throws FileNotFoundException, IOException {
		
		
		// counter started from 9997 to can check 10000 limit and also employees will be added chronological. Some of them are quitted 
		
				FullTimeEmployee employee1 = new FullTimeEmployee("Tuncay", "Kozak", LocalDate.of(2022, 1, 20), LocalDate.of(2026, 10, 10), 15000 );
				try (ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(new FileOutputStream("employee1.txt"))) {
					objectOutputStream1.writeObject(employee1);
				}
				HourlyEmployee employee2 = new HourlyEmployee("Samet", "Kulla", LocalDate.of(2022, 2, 20), LocalDate.of(2023, 11, 27), 50 );
				employee2.setHoursOfWorked(new int[] {20, 20, 15, 25, 18, 20, 10});
				try (ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream("employee2.txt"))) {
					objectOutputStream2.writeObject(employee2);
				}
				HourlyEmployee employee3 = new HourlyEmployee("Yasin", "Celik", LocalDate.of(2022, 3, 21), LocalDate.of(2024, 1, 2), 100 );
				employee3.setHoursOfWorked(new int[] {20, 15, 20, 25, 20, 20});
				try (ObjectOutputStream objectOutputStream3 = new ObjectOutputStream(new FileOutputStream("employee3.txt"))) {
					objectOutputStream3.writeObject(employee3);
				}
				FullTimeEmployee employee4 = new FullTimeEmployee("Eren", "Uygur", LocalDate.of(2022, 4, 7), LocalDate.of(2022, 7, 5), 25000 ); 
				try (ObjectOutputStream objectOutputStream4 = new ObjectOutputStream(new FileOutputStream("employee4.txt"))) {
					objectOutputStream4.writeObject(employee4);
				}
				FullTimeEmployee employee5 = new FullTimeEmployee("Mehmet Akif", "Tanisik", LocalDate.of(2022, 5, 11), LocalDate.of(2022, 10, 10), 25000 );
				try (ObjectOutputStream objectOutputStream5 = new ObjectOutputStream(new FileOutputStream("employee5.txt"))) {
					objectOutputStream5.writeObject(employee5);
				}
				HourlyEmployee employee6 = new HourlyEmployee("Remzi", "Gelmez", LocalDate.of(2022, 6, 19), LocalDate.of(2022, 8, 29), 70 ); 
				employee6.setHoursOfWorked(new int[] {20, 15, 5});
				try (ObjectOutputStream objectOutputStream6 = new ObjectOutputStream(new FileOutputStream("employee6.txt"))) {
					objectOutputStream6.writeObject(employee6);
				}
	}

}
