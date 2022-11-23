package com.maersk.containers.dao;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.maersk.containers.entity.BookingRequestEntity;

/**
 * DAO class for Booking request entity CRUD operations
 * 
 * @author Pattabhi
 *
 */
@Repository
public interface BookingDAO extends CassandraRepository<BookingRequestEntity, Integer> {
}
