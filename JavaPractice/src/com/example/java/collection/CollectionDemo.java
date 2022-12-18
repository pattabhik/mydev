package com.example.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

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
	}

	private static void arrays() {
		final int[] intarr1 = new int[5];
		intarr1[0] = 1;
		final int[] intarr2 = new int[5];
		intarr2[0] = 1;

		System.out.println(Arrays.compare(intarr1, intarr2));
	}

	private static void iterator() {
		List<String> strgs = new ArrayList<>();
		strgs.add("10");
		strgs.add("20");
		strgs.add("30");
		strgs.add("40");

		ListIterator<String> listItrtr = strgs.listIterator();
		System.out.println("Length:" + strgs.size());
		while (listItrtr.hasNext()) {

			String next = listItrtr.next();
			System.out.println(next);
			// strgs.add("Ram");//not allowed
			// strgs.remove(next);//not allowed
			// listItrtr.remove();
		}
		strgs.add("50");
		System.out.println("Second time iteration");
		// listItrtr = strgs.iterator();
		System.out.println("Length:" + strgs.size());
		strgs.forEach(System.out::println);

		while (listItrtr.hasNext()) {

			String next = listItrtr.next();
			System.out.println(next);
			// strgs.add("Ram");
			// strgs.remove(next);
			// listItrtr.remove();
		}
	}

}
