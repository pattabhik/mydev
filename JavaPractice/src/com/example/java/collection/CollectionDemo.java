package com.example.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 * @author Pattabhi
 *
 */
public class CollectionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// CollectionDemo.arrays();
		CollectionDemo.iterator();
		CollectionDemo.listIterator();
		Iterator<String> i;
		Vector<String> v;

		// CollectionDemo.printArrays();

		Map<String, String> gfg = new HashMap<String, String>();

		// enter name/url pair
		gfg.put("GFG", "geeksforgeeks.org");
		gfg.put("Practice", "practice.geeksforgeeks.org");
		gfg.put("Code", "code.geeksforgeeks.org");
		gfg.put("Quiz", "www.geeksforgeeks.org");

		// using for-each loop for iteration over Map.entrySet()
		/*
		 * for (Map.Entry<String, String> entry : gfg.entrySet())
		 * System.out.println("Key = " + entry.getKey() + ", Value = " +
		 * entry.getValue());
		 */
	}

	private static void printArrays() {
		int[] intarr = new int[10];
		intarr[0] = 10;
		intarr[1] = 20;
		intarr[2] = 30;
		intarr[3] = 40;
		intarr[4] = 50;

		System.out.println("printArrays(): " + Arrays.toString(intarr));

	}

	private static void stackOperation() {
		Stack<String> st = new Stack<>();
	}
	private static void arrays() {
		final int[] intarr1 = new int[5];
		intarr1[0] = 1;
		final int[] intarr2 = new int[5];
		intarr2[0] = 1;

		System.out.println(Arrays.compare(intarr1, intarr2));
	}

	private void setDemo() {
		Set<String> sets = new HashSet<>();
		sets.add("one");

	}

	private static void iterator() {
		List<String> strgs = new ArrayList<>();
		strgs.add("10");
		strgs.add("20");
		strgs.add("30");
		strgs.add("40");

		Iterator<String> listItrtr = strgs.iterator();
		System.out.println("First time Length: " + strgs.size());
		while (listItrtr.hasNext()) {
			String next = listItrtr.next();
			System.out.println(next);
			// strgs.add("Ram");// not allowed
			// strgs.remove(next);//not allowed
			listItrtr.remove();
		}
		strgs.add("50");
		// listItrtr.set(String.valueOf(num + 10));
		System.out.println("Second time iteration");
		listItrtr = strgs.iterator();
		System.out.println("Second time Length: " + strgs.size());
		// strgs.forEach(System.out::println);

		while (listItrtr.hasNext()) {

			String next = listItrtr.next();
			System.out.println(next);
			// strgs.add("Ram");
			// strgs.remove(next);
			// listItrtr.remove();
		}
	}

	private static void listIterator() {
		List<String> strgs = new ArrayList<>();
		strgs.add("10");
		strgs.add("20");
		strgs.add("30");
		strgs.add("40");
		int num = 40;
		ListIterator<String> listItrtr = strgs.listIterator();
		System.out.println("First time Length: " + strgs.size());
		while (listItrtr.hasNext()) {

			String next = listItrtr.next();
			System.out.println("First time: " + next);
			// strgs.add("Ram");// not allowed
			// strgs.remove(next);//not allowed
			listItrtr.remove();
			listItrtr.add(String.valueOf(num = num + 10));

		}
		strgs.add("50");
		// listItrtr.set(String.valueOf(num + 10));
		System.out.println("Second time iteration");
		listItrtr = strgs.listIterator();
		System.out.println("Second time Length: " + strgs.size());
		// strgs.forEach(System.out::println);

		while (listItrtr.hasNext()) {

			String next = listItrtr.next();
			System.out.println("Second time: " + next);
			// strgs.add("Ram");
			// strgs.remove(next);
			// listItrtr.remove();
		}
	}

}
