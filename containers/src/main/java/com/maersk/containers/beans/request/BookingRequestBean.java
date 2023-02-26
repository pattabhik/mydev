package com.maersk.containers.beans.request;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;


/**
 * Booking request bean
 * 
 * @author Pattabhi
 *
 */
public class BookingRequestBean extends BookingBaseBean {
	@NotNull(message = "Invalid Timestamp.")
	private Timestamp timestamp;

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
