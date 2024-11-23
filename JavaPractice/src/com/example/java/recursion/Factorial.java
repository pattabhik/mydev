package com.example.java.recursion;

/**
 *
 * @author Pattabhi
 */

public class Factorial {

	public static void main(String[] args) {
		/**
		 * 5! = 1*2*3*4*5
		 */
		System.out.println(Factorial.factorial(5, 1));
	}

	private static int factorial(int num, int factrl) {
		if (num != 0)
			factrl = num * factorial((num - 1), factrl);
		return factrl;
	}
}
