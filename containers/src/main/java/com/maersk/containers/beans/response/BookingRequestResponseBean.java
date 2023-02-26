package com.maersk.containers.beans.response;

/**
 * Booking request's response bean
 * 
 * @author Pattabhi
 *
 */
public class BookingRequestResponseBean {
	private String bookingRef;

	public BookingRequestResponseBean(String bookingRef) {
		super();
		this.bookingRef = bookingRef;
	}

	public String getBookingRef() {
		return bookingRef;
	}

}
