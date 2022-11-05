package com.example.java.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(122);
		GenericsDemo.printList(list);
	}

	public static void printList(List<?> list) {
		System.out.println("Printed: " + list.toString());
	}

}
