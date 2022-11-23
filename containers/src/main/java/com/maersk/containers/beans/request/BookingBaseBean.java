package com.maersk.containers.beans.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.maersk.containers.enums.ContainerTypeEnum;

/**
 * base bean of container booking
 * 
 * @author Pattabhi
 *
 */
public class BookingBaseBean {
	@Range(min = 20, max = 40, message = "The container size should be 20 or 40.")
	private Integer containerSize;

	@NotNull
	private ContainerTypeEnum containerType;

	@Size(min = 5, max = 20, message = "The length of origin must be between 5 to 20 characters.")
	private String origin;

	@Size(min = 5, max = 20, message = "The length of destination must be between 5 to 20 characters.")
	private String destination;

	@Range(min = 1, max = 100, message = "The quantity must be between 1 to 100.")
	private Integer quantity;

	/**
	 * @return the containerSize
	 */
	public Integer getContainerSize() {
		return containerSize;
	}
	/**
	 * @param containerSize the containerSize to set
	 */
	public void setContainerSize(Integer containerSize) {
		this.containerSize = containerSize;
	}
	/**
	 * @return the containerType
	 */
	public ContainerTypeEnum getContainerType() {
		return containerType;
	}
	/**
	 * @param containerType the containerType to set
	 */
	public void setContainerType(ContainerTypeEnum containerType) {
		this.containerType = containerType;
	}
	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}
	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	/**
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
