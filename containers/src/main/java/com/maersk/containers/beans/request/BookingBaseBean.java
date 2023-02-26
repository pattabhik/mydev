package com.maersk.containers.beans.request;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.maersk.containers.validators.OneOfIntegerValues;

/**
 * bean of container booking
 * 
 * @author Pattabhi
 *
 */
public class BookingBaseBean {
	@OneOfIntegerValues(values = { 20, 40 }, message = "The container size should be either 20 or 40.")
	private Integer containerSize;

	@Pattern(regexp="DRY|REEFER", message = "Invalid Container Type.")
	private String containerType;

	@Size(min = 5, max = 20, message = "The length of origin must be between 5 to 20 characters.")
	private String origin;

	@Size(min = 5, max = 20, message = "The length of destination must be between 5 to 20 characters.")
	private String destination;

	@Range(min = 1, max = 100, message = "The quantity must be between 1 to 100.")
	private Integer quantity;

	public void setContainerSize(Integer containerSize) {
		this.containerSize = containerSize;
	}

	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "BookingBaseBean [containerSize=" + containerSize + ", containerType=" + containerType + ", origin="
				+ origin + ", destination=" + destination + ", quantity=" + quantity + "]";
	}

}
