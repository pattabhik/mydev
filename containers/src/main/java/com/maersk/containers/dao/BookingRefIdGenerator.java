package com.maersk.containers.dao;

/**
 * Util class to generate the booking reference id
 * 
 * @author Pattabhi
 *
 */
public class BookingRefIdGenerator {

	private static int bookingRefNumbr = 957000000;

	public synchronized static int getNextBookingRef() {
		;
		return ++bookingRefNumbr;
	}
}
