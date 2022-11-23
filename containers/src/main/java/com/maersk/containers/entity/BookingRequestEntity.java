package com.maersk.containers.entity;

import java.sql.Timestamp;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.maersk.containers.dao.DAOConstants;

/**
 * BookingRequest Entity
 * 
 * @author Pattabhi
 *
 */
@Table(DAOConstants.BOOKINGS_TABLE_NAME)
public class BookingRequestEntity {

	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
	private int bookingRef;
	@Column
	private String containerType;
	@Column
	private int containerSize;
	@Column
	private String origin;
	@Column
	private String destination;
	@Column
	private int quantity;
	@Column
	private Timestamp timestamp;
	
	/**
	 * @return the bookingRef
	 */
	public int getBookingRef() {
		return bookingRef;
	}

	/**
	 * @param bookingRef the bookingRef to set
	 */
	public void setBookingRef(int bookingRef) {
		this.bookingRef = bookingRef;
	}

	/**
	 * @return the containerType
	 */
	public String getContainerType() {
		return containerType;
	}

	/**
	 * @param containerType the containerType to set
	 */
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}

	/**
	 * @return the containerSize
	 */
	public int getContainerSize() {
		return containerSize;
	}

	/**
	 * @param containerSize the containerSize to set
	 */
	public void setContainerSize(int containerSize) {
		this.containerSize = containerSize;
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
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

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
