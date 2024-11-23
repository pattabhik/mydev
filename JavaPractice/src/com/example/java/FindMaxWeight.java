package com.example.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class FindMaxWeight {
	public static void main(String args[]) {
		List<Integer> intList = new ArrayList<>();
		intList.addAll(Arrays.asList(12, 9, 15, 34, 12));
		intList.add(21);
		// System.out.println(calcMaxWeight(intList));
		// failFast();
		failFastList();
		CopyOnWriteArrayList<Integer> cow = new CopyOnWriteArrayList<>();

		cow.add(110);

		ArrayList<Integer> al = new ArrayList<>();
		al.add(null);

		Vector<Integer> v = new Vector<>();
		v.add(null);
	}

	public static void failFast() {
		Map<String, String> empName = new HashMap<String, String>();
		empName.put("Sam Hanks", "New york");
		empName.put("Will Smith", "LA");
		empName.put("Scarlett", "Chicago");
		Iterator iterator = empName.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(empName.get(iterator.next()));
			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			empName.put("Istanbul", "Turkey");
		}
	}

	public static void failSafe() {
		java.util.concurrent.ConcurrentHashMap<String, String> empName = new java.util.concurrent.ConcurrentHashMap<String, String>();
		empName.put("Sam Hanks", "New york");
		empName.put("Will Smith", "LA");
		empName.put("Scarlett", "Chicago");
		Iterator iterator = empName.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(empName.get(iterator.next()));
			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			empName.put("Istanbul", "Turkey");
		}
	}

	public static void failFastList() {
		List<String> empName = new ArrayList<String>();
		empName.add("New york");
		empName.add("LA");
		empName.add("Chicago");
		// ListIterator<String> iterator = empName.listIterator();
		Iterator<String> iterator = empName.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			// iterator.add("Turkey");
		}
		
		System.out.println("After added");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
		}
	}

	public static void failSafeList() {
		java.util.concurrent.ConcurrentHashMap<String, String> empName = new java.util.concurrent.ConcurrentHashMap<String, String>();
		empName.put("Sam Hanks", "New york");
		empName.put("Will Smith", "LA");
		empName.put("Scarlett", "Chicago");
		Iterator iterator = empName.keySet().iterator();
		while (iterator.hasNext()) {
			System.out.println(empName.get(iterator.next()));
			// adding an element to Map
			// exception will be thrown on next call
			// of next() method.
			empName.put("Istanbul", "Turkey");
		}
	}

	public static int calcMaxWeight(List<Integer> list) {
		List<Integer> list2 = recusiveChecker(list);
		System.out.println(list2.toString());
		Collections.sort(list2);
		return list2.get(list2.size() - 1);
	}

	public static List<Integer> recusiveChecker(List<Integer> list) {
		List<Integer> list2 = new ArrayList<>();
		int size = list.size();
		boolean match = false;
		for (int i = 0; i < size; i++) {
			if (i != (size - 1) && list.get(i) < list.get(i + 1)) {
				list2.add((list.get(i) + list.get(i + 1)));
				i++;
				match = true;
			} else {
				list2.add(list.get(i));
			}
		}
		if (match) {
			recusiveChecker(list2);
		}
		return list2;
	}
}
