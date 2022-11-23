package com.maersk.containers.beans.request;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;


/**
 * Booking request request bean
 * 
 * @author Pattabhi
 *
 */
public class BookingRequestBean extends BookingBaseBean {
	@NotNull
	private Timestamp timestamp;

	/**
	 * @return the timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
