package com.example.java.recursion;

/**
 *
 * @author Pattabhi
 */
public class MagicNums {

	public static void main(String[] args) {
		int numb = 196;
		int digtsSum = 0;
		while (numb > 0) {
			digtsSum += numb % 10;
			numb /= 10;
			if (numb == 0 && digtsSum > 9) {
				numb = digtsSum;
			digtsSum = 0;
		}
		}

		System.out.println(digtsSum);

	}

}
