package com.maersk.containers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.maersk.containers.beans.request.BookingRequestResponseBean;
import com.maersk.containers.beans.response.CheckAvailabilityResponseBean;
import com.maersk.containers.constants.ControllerConstants;
import com.maersk.containers.dao.BookingDAO;
import com.maersk.containers.dao.BookingRefIdGenerator;
import com.maersk.containers.entity.BookingRequestEntity;
import com.maersk.containers.resttemplate.RestClientConstant;
import com.maersk.containers.resttemplate.RestTemplateClient;
import com.maersk.containers.resttemplate.response.bean.CheckAvailabilityResponse;

/**
 * Booking Service class
 * 
 * @author Pattabhi
 *
 */
@Service
public class BookingService {

	@Autowired
	@Qualifier(ControllerConstants.REST_TEMPLATE_CLIENT_PROXY_QUALIFIER)
	private transient RestTemplateClient restTemplt;

	@Autowired
	private transient BookingDAO bookingDAO;

	/**
	 * it will check the availability of containers by invoiking another REST URL
	 * 
	 * @return
	 */
	public CheckAvailabilityResponseBean checkAvailability() {
		final CheckAvailabilityResponseBean bean = new CheckAvailabilityResponseBean();
		final CheckAvailabilityResponse resp = (CheckAvailabilityResponse) restTemplt
				.invoke(RestClientConstant.CHECK_AVAILABLE_URL, null, CheckAvailabilityResponse.class);
		if (resp != null && resp.getAvailableSpace() > 0) {
			bean.setAvailable(true);
		}

		return bean;
	}

	/**
	 * It will save the booking request in db
	 * 
	 * @param entity
	 * @return
	 */
	public BookingRequestResponseBean createContainerRequest(final BookingRequestEntity entity) {
		final BookingRequestResponseBean respBean = new BookingRequestResponseBean();
		entity.setBookingRef(BookingRefIdGenerator.getNextBookingRef());
		bookingDAO.insert(entity);
		respBean.setBookingRef(entity.getBookingRef());

		return respBean;
	}

}
