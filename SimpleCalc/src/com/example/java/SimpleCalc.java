package com.example.java;

import java.util.Scanner;

public class SimpleCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		System.out.print("Enter integer value:");
		String intStr = scnr.nextLine();
		int strToInt = Integer.parseInt(intStr);
		System.out.print("Enter numeric value:");
		String numrStr = scnr.nextLine();
		float strToFloat = Float.parseFloat(numrStr);
		System.out.println("The Answer is:" + (strToInt + strToFloat));
		scnr.close();
	}

}
