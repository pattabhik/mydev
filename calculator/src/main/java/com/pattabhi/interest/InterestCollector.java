package com.pattabhi.interest;

public class InterestCollector {

	public static void main(String[] args) {
		// yyyy-mm-dd
		InterestCalculatorInput input = new InterestCalculatorInput.Builder().setFromDtStr("2024-09-06")
				.setToDtStr("2024-12-16").setPrincipal(200000).setRate(1.5).build();
		System.out.println(input);

		PayingBy payingBy = PayingBy.NONE;

		switch (payingBy) {
		case ME:
			InterestCalculator.calculateGrossAmountPayToMe(input);
			break;
		case TO_OTHERS:
			InterestCalculator.calculateGrossAmountToOthers(input);
			break;
		default:
			InterestCalculator.calculateGrossAmountPayToMe(input);
			InterestCalculator.calculateGrossAmountToOthers(input);
		}
	}


}
