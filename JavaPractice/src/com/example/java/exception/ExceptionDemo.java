package com.example.java.exception;

/**
 * @author Pattabhi
 *
 */
public class ExceptionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			System.out.println("before exit");
			throw new Error();
		} catch (Exception exp) {
			System.out.println("Catch block");
		} finally {
			System.out.println("finally block");
		}
		System.out.println("ExceptionDemo commit to feature branch changes welcome");
	}

}
