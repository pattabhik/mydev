package com.example.java.recursion;

/**
 *
 * @author Pattabhi
 */

public class StringPolyndrome {

	public static void main(String[] args) {
		System.out.println("Polyndrome word:" + StringPolyndrome.isWordPolyndrome("Pattabhi"));
	}

	private static String isWordPolyndrome(String polyndrome) {
		System.out.println("polyndrome:" + polyndrome);
		if (polyndrome == null || polyndrome.length() == 0) {
			return "";
		}

		return polyndrome.charAt(polyndrome.length() - 1)
				+ isWordPolyndrome(polyndrome.substring(0, polyndrome.length() - 1));
	}
}
