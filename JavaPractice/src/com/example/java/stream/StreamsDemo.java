package com.example.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {

	public static void main(String[] args) {
		// finding a missing number
		/*
		 * Integer[] arr = { 1, 4, 6, 8, 5, 2, 3 }; // Arrays.sort(arr); List<Integer>
		 * asList = Arrays.asList(arr); Set<Integer> set = new HashSet<>(); //
		 * set.forEach(null); asList.forEach(null); asList.stream().filter(i -> { //
		 * System.out.println(i); return true; });
		 */
		Stream<String> numbers = Stream.of("Pankaj", "Janaki", "Juhitha", "Amit", "David", "Lisa");
		// Stream.of(1, 2, 3, 4, 5);
		/*
		 * Optional<Integer> optnInt = numbers.reduce((i, j) -> i * j); if
		 * (optnInt.isPresent()) { System.out.println(optnInt.get()); }
		 */

		// System.out.println(numbers.count());
		// System.out.println(numbers.noneMatch(i -> i < 0));
		/*
		 * Optional<String> optnName = numbers.filter(str ->
		 * str.startsWith("P")).findFirst(); if (optnName.isPresent()) {
		 * System.out.println("Name found:" + optnName.get()); } else {
		 * System.out.println("Name not found"); }
		 */
		List<String> strList = numbers.filter(s -> s.startsWith("J")).collect(Collectors.toList());

	}

}
