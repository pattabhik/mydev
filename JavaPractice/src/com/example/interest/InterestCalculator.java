package com.example.interest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class InterestCalculator {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fromDtStr = "26/04/2024";
		String toDtStr = "25/04/2025";

		// year,month,day
		LocalDate fromDate = LocalDate.parse(fromDtStr, dtf);
		LocalDate toDate = LocalDate.parse(toDtStr, dtf);
		long noOfDays = ChronoUnit.DAYS.between(fromDate, toDate) + 1;
		int principal = 200000;
		double rate = (double) 2 / 100;
		double months = (double) noOfDays / 30;
		double intrst = principal * rate * months;
		System.out.println("To Pay:" + (principal + intrst) + ", Principal:" + principal + ", " + "Days: " + noOfDays
				+ "(" + months + " months), Interest: " + intrst);
	}

}
