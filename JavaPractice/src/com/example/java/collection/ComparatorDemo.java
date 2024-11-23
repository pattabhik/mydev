package com.example.java.collection;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Pattabhi
 */

public class ComparatorDemo {

	public static void main(String[] args) {
		ArrayList<String> alStr = new ArrayList<>();
		alStr.add("Ramaiah");
		alStr.add("Pattabhi");
		Collections.sort(alStr);
		System.out.println(alStr);

		ArrayList<Integer> alStr1 = new ArrayList<>();
		alStr1.add(23);
		alStr1.add(12);
		Collections.sort(alStr1);
		System.out.println(alStr1);

		ArrayList<Employee> alStr2 = new ArrayList<>();
		alStr2.add(new Employee("Ramaiah", 39, 60000.00));
		alStr2.add(new Employee("Pattabhi", 40, 65000.00));
		Collections.sort(alStr2, new SortByEmployeeName());
		System.out.println(alStr2);
		Employee e = new Employee("Pattabhi", 40, 65000.00);
		final int a;
		a = 10;
		ComparatorDemo.varargsMethod();
	}

	public static void varargsMethod(String... strings) {
		System.out.println("varargsMethod size:" + strings.length);
	}
}
