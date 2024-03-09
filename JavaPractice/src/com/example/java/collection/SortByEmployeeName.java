package com.example.java.collection;

import java.util.Comparator;

/**
 *
 * @author Pattabhi
 */

public class SortByEmployeeName implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}

}
