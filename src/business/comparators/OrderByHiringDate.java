package business.comparators;

import java.util.Comparator;

import entities.Employee;

public class OrderByHiringDate implements Comparator<Employee> {

	@Override
	public int compare(Employee employee1, Employee employee2) {

		return (employee1.getHiringDate().compareTo(employee2.getHiringDate()));
	}

}
