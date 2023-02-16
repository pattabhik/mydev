package com.maersk.containers.dao;

/**
 * Util class to generate the booking reference id
 * 
 * @author Pattabhi
 *
 */
public class BookingRefIdGenerator {
	/**
	 * This is the temporary way to generate the next sequence as the current
	 * development is for one time test case will not see the duplicates
	 * 
	 * In real scenario, usually it will be a sequence in RDBMS or time in
	 * milliseconds or we can create a table with id column and select the previous
	 * id value and increment the value by 1 and update back the id table with new
	 * id value with in synchronization block of code. So, we can avoid getting
	 * duplicate ids
	 * 
	 */
	private static int bookingRefNumbr = 957000000;

	public synchronized static int getNextBookingRef() {
		return ++bookingRefNumbr;
	}
}
