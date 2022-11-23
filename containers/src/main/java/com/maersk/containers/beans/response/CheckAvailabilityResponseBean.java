package com.maersk.containers.beans.response;

/**
 * Check availability request's response bean
 * 
 * @author Pattabhi
 *
 */
public class CheckAvailabilityResponseBean {
	private boolean available;

	/**
	 * @return the available
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * @param available the available to set
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}

}
