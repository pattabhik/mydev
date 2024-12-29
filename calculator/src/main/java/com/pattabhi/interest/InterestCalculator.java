package com.pattabhi.interest;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class InterestCalculator {

	/**
	 * this will be used when I want to calculate the amount that others will pay to
	 * me
	 */
	protected static void calculateGrossAmountPayToMe(InterestCalculatorInput input) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate fromDate = LocalDate.parse(input.getFromDtStr(), dtf);
		LocalDate toDate = LocalDate.parse(input.getToDtStr(), dtf);
		long noOfDays = ChronoUnit.DAYS.between(fromDate, toDate);
		double months = (double) noOfDays / 30;
		double interestAmount = input.getPrincipal() * input.getInterestPercentage() * months;
		System.out.println("Paying to me:" + (input.getPrincipal() + interestAmount) + ", Principal:" + input.getPrincipal()
				+ ", "
				+ "Days: " + noOfDays + "(" + months + " months), Interest: " + interestAmount);
	}

	/**
	 * this will be used when I want to calculate the amount to pay to some others
	 */
	protected static void calculateGrossAmountToOthers(InterestCalculatorInput input) {
		Period diff = Period.between(LocalDate.parse(input.getFromDtStr()), LocalDate.parse(input.getToDtStr()));
		// calculate the interest for months
		double monthlyInterest = input.getPrincipal() * input.getInterestPercentage() * 1;
		double totalMonthlyInterest = monthlyInterest * diff.getMonths();
		double dailyInterestAccrued = (monthlyInterest / 30) * diff.getDays();
		double totalInterest = totalMonthlyInterest + dailyInterestAccrued;
		double toPay = (input.getPrincipal() + totalInterest);
		System.out.println("To Pay:" + toPay + ", Principal:" + input.getPrincipal() + ", " + diff.getMonths()
				+ " months, " + diff.getDays() + "days, Interest: " + totalInterest);
	}
}
