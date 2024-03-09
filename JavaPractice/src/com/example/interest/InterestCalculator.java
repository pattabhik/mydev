package com.example.interest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class InterestCalculator {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fromDtStr = "01/01/2024";
		String toDtStr = "20/02/2024";

		// year,month,day
		LocalDate fromDate = LocalDate.parse(fromDtStr, dtf);
		LocalDate toDate = LocalDate.parse(toDtStr, dtf);
		long noOfDays = ChronoUnit.DAYS.between(fromDate, toDate);
		int principal = 400000;
		double rate = (double) 2.0 / 100;
		double months = (double) noOfDays / 30;
		double intrst = principal * rate * months;
		System.out.println("To Pay:" + (principal + intrst) + ", Principal:" + principal + ", " + "Days: " + noOfDays
				+ ", Interest: " + intrst + ", Months: " + months);
	}

}
