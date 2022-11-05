package com.example.java.threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArraySort {

	public static void main(String[] args) {
		// finding a missing number
		Integer[] arr = { 1, 4, 6, 8, 5, 2, 3 };
		Arrays.sort(arr);
		List<Integer> asList = Arrays.asList(arr);
		for (int i = 0; i < arr[arr.length - 1]; i++) {
			if (!asList.contains(i)) {
				// System.out.println("Missing number is:" + i);
			}
		}

		// finding any two numbers are equal to 19
		int equalToNum = 12;

		List<Integer> numrsAsList = Arrays.asList(5,7,1,2,8,4,3);
		for (int num : numrsAsList) {
			for (int num2 : numrsAsList) {
				if (equalToNum == (num + num2)) {
					// System.out.println("Equal found");
				}
			}
		}

		// merge 2 sorted linked lists
		LinkedList<Integer> l1 = new LinkedList<>();
		LinkedList<Integer> l2 = new LinkedList<>();
		// reverse words
		String word = "Hello World";
		char wordChar[] = word.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (int i = wordChar.length - 1; i > -1; i--) {
			builder.append(wordChar[i]);
		}
		// System.out.println("Reversed string: " + builder.toString());

		// no of ways
		int[] coins = { 1, 2, 5 };
		int totalAmnt = 7;
		List<String> matches = new ArrayList();
		
		for (int j = 0; j < coins.length; j++) {
			StringBuilder bldr = new StringBuilder();
			// coin self counting
			int addedcon = (coins[j] + coins[j]);
			bldr.append(coins[j] + ",");
			while (addedcon <= totalAmnt) {
				bldr.append(coins[j] + ",");
				if (addedcon == totalAmnt) {
					bldr.append("\n");
					matches.add(bldr.toString());
					bldr = new StringBuilder();
				}
				addedcon += coins[j];
			}
			bldr = new StringBuilder();
			// bldr.append("\n");
			for (int i = j + 1; i < coins.length; i++) {
				addedcon = (coins[j] + coins[i]);
				bldr.append(coins[j] + ",");
				while (addedcon <= totalAmnt) {
					bldr.append(coins[i] + ",");
					if (addedcon == totalAmnt) {
						bldr.append("\n");
						matches.add(bldr.toString());
						bldr = new StringBuilder();
					}
					addedcon += coins[i];
				}
				bldr.append("\n");
			}
		}
		// matches.forEach(System.out::println);
		// System.out.println("Matches are:" + matches.toString());
		int[] denominations = new int[] { 1, 2, 5 };
		int amount = 7;
		int result = solveCoinChange(denominations, amount);
		System.out.print("SolveCoinChange(" + Arrays.toString(denominations) + ", " + amount + ") = ");
		System.out.print(result);
	}

	static int solveCoinChange(int[] denominations, int amount) {
		int[] solution = new int[amount + 1];
		solution[0] = 1;

		for (int den : denominations) {
			for (int i = den; i < (amount + 1); ++i) {
				System.out.println(solution[i]);
				solution[i] += solution[i - den];
				System.out.println(solution[i]);
			}
		}
		return solution[solution.length - 1];
	}

	static int findMissing(int[] input) {
		// calculate sum of all integers
		// in input list
		int actualSum = 0;
		for (Integer x : input) {
			actualSum += x;
		}
		int n = input.length;

		int sumOfN = (n * (n + 1)) / 2;
		System.out.println("sumOfN:" + sumOfN);
		return sumOfN - actualSum;
	}


}
