package business.comparators;

import java.util.Comparator;

import entities.Employee;

public class OrderByName implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {

		return ((employee1.getFirstName() + employee1.getLastName())
				.compareToIgnoreCase((employee2.getFirstName() + employee2.getLastName())));
	}

}
