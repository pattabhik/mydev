package com.example.java.recursion;

/**
 * 0 1 1 2 3 5 8 13 ...
 * 
 * @author Pattabhi
 */

public class FibonaciSeries {

	public static void main(String[] args) {
		int num1 = 0;
		int num2 = 1;
		System.out.print(num1 + " " + num2 + " ");
		FibonaciSeries.printFibonaciSeries(num1, num2, 15);
	}

	private static void printFibonaciSeries(int num1, int num2, int noOf) {
		if (num2 >= noOf) {
			// System.out.print(num2 + " ");
			return;
		}
		System.out.print(num1 + num2 + " ");
		
		printFibonaciSeries(num2, num1 + num2, noOf);
	}
}
