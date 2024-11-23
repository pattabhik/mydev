package com.example.primitive;

public class MinMaxValues {

	public static void main(String[] args) {
		int minValue = Short.MIN_VALUE - 1;
		int maxValue = Short.MAX_VALUE + 1;
		// -32768, 32767
		// -32769, 32768
		// System.out.println(minValue + ", " + maxValue);

		int i = 10, k = 10;
		k = i++ + k;
		// System.out.println(k);

		boolean input1 = true, input2 = false; // Line 1
		boolean result1 = input1 = !input1; // Line 2
		boolean result2 = input2 = input1; // Line 3
		boolean result3 = input1 == (result1 = !input2); // Line 4
		// System.out.println(input1 + " " + input2 + " " + result2 + " " + result3);
		String arg = "hello";
		String hello="hello";
		StringBuilder sb = new StringBuilder(arg);
		System.out.print(arg.equals(sb) + " ");
		System.out.print((hello.equals(arg)) + " ");
		System.out.print((hello==arg));
	}


}
