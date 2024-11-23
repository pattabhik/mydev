package com.example.java.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringsDemo {

	public static void main(String[] args) {

		// counting each char appearance in a string
		String str = "Pattabhiramaiah";
		System.out.println(str.toCharArray());

		Map<String, Long> charGrpingCount = Arrays.stream(str.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(charGrpingCount);
		
		// finding the duplicate char
		String str2="Pattabhiramaiah";
		List<String> duplctChar = Arrays.stream(str2.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey)
				.collect(Collectors.toList());
		System.out.println(duplctChar);
		// find the unique element in a given string
		String str3 = "Pattabhiramaiah";
		String firstOcrns = Arrays.stream(str3.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
		System.out.println(firstOcrns);

		// how to get the 2nd highest mark student
		List<Student> students = new ArrayList<>();
		students.add(new Student("A", 100));
		students.add(new Student("B", 900));
		students.add(new Student("C", 300));
		students.add(new Student("D", 600));
		students.add(new Student("E", 500));
		Student stdntStrms = students.stream().sorted(Comparator.comparingInt(Student::getTotalMarks).reversed())
				.skip(1).findFirst().get();

		System.out.println(stdntStrms);

		Stream<Integer> intStrm = Stream.of(9, 3, 5, 6, 8, 6);
		// intStrm.forEach(num -> System.out.println(num));
		intStrm.sorted().distinct().forEach(num -> System.out.println(num));

		// System.out.println(intStrm1);

		// find the longest string in the array
		Stream<String> strngStrm = Stream.of("one", "two2", "three", "fourfour");
		System.out.println(strngStrm.reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2).get());

		// start with specific number
		Stream<Integer> intStrm1 = Stream.of(12, 34, 54, 100);
		List<String> strNum = intStrm1.map(intNum -> String.valueOf(intNum)).collect(Collectors.toList()).stream()
				.filter(strNum2 -> strNum2.startsWith("1")).collect(Collectors.toList());

		System.out.println(strNum);
	}

}

class Student {
	String name;
	int totalMarks;

	public Student(String name, int totalMarks) {
		this.name = name;
		this.totalMarks=totalMarks;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", totalMarks=" + totalMarks + "]";
	}

}
