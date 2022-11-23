package com.example.java.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.example.java.ps.CustomePredicate;

public class StreamsDemo {

	public static void main(String[] args) {
		// finding a missing number
		/*
		 * Integer[] arr = { 1, 4, 6, 8, 5, 2, 3 }; // Arrays.sort(arr); List<Integer>
		 * asList = Arrays.asList(arr); Set<Integer> set = new HashSet<>(); //
		 * set.forEach(null); asList.forEach(null); asList.stream().filter(i -> { //
		 * System.out.println(i); return true; });
		 */
		Integer[] arr = { 1, 4, 6, 8, 5, 2, 3 };
		List<Integer> asList = Arrays.asList(arr);

		Stream<String> strings = Stream.of("Pankaj", "Janaki", "Juhitha", "Amit", "David", "Lisa");
		Stream<Integer> numbers = Stream.of(6, 2, 3, 4, 5);
		Stream<Integer> numbers1 = Stream.of(1, 2, 3, 4, 5);
		Stream<Integer> numbers2 = Stream.ofNullable(100);

		CustomePredicate custPrd = new CustomePredicate();
		System.out.println(custPrd.test("Pattabhi"));
		Optional<Integer> optnInt = numbers.reduce((i, j) -> i * j);
		if (optnInt.isPresent()) {
			// System.out.println(optnInt.get());
		}

		// System.out.println(numbers.count());
		// System.out.println(numbers.noneMatch(i -> i < 0));
		/*
		 * Optional<String> optnName = numbers.filter(str ->
		 * str.startsWith("P")).findFirst(); if (optnName.isPresent()) {
		 * System.out.println("Name found:" + optnName.get()); } else {
		 * System.out.println("Name not found"); }
		 */
		// List<String> strList = numbers.filter(s ->
		// s.startsWith("J")).collect(Collectors.toList());

		// numbers2.takeWhile(x -> x > 2).forEach(System.out::println);
		// System.out.println("Drop While");
		// numbers1.dropWhile(x -> x > 2).forEach(System.out::println);
		// Stream.iterate(1, x -> x + 1).limit(100).forEach(System.out::println);

		// Map<String, String> hm = new HashMap<>();
		// hm.entrySet();

	}

}
