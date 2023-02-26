package com.maersk.containers.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.maersk.containers.beans.request.BookingRequestBean;
import com.maersk.containers.beans.request.CheckAvailabilityBean;
import com.maersk.containers.beans.response.CheckAvailabilityResponse;
import com.maersk.containers.constants.ControllerMappings;
import com.maersk.containers.constants.ExceptionConstants;
import com.maersk.containers.dao.BookingDAO;
import com.maersk.containers.dao.BookingRefIdGenerator;
import com.maersk.containers.entity.BookingRequestEntity;
import com.maersk.containers.exception.DAOException;
import com.maersk.containers.log.LoggerUtil;
import com.maersk.containers.resttemplate.RestTemplateClient;

/**
 * Booking Service class
 * 
 * @author Pattabhi
 *
 */
@Service
public class BookingService {

	private static final Logger LOG = LoggerFactory.getLogger(BookingService.class);

	@Autowired
	@Qualifier(ControllerMappings.REST_TEMPLATE_CLIENT_PROXY_QUALIFIER)
	private transient RestTemplateClient restTemplt;

	@Autowired
	private transient BookingDAO bookingDAO;

	@Value("${external.service.url.check.availability}")
	private String checkAvlbltyUrl;

	/**
	 * it will check the availability of containers by invoking another external
	 * service URL
	 * 
	 * @return
	 */
	@Cacheable(cacheNames = "containersSearch", keyGenerator = "searchKeyGenerator")
	public CheckAvailabilityResponse checkAvailability(final CheckAvailabilityBean chkAvlbltyBean) {
		return (CheckAvailabilityResponse) restTemplt
				.invoke(checkAvlbltyUrl, chkAvlbltyBean, CheckAvailabilityResponse.class);
	}

	/**
	 * It will save the booking request in db
	 * 
	 * @param entity
	 * @return
	 */
	public BookingRequestEntity createContainerRequest(final BookingRequestBean bookRqstBean) {
		BookingRequestEntity bookngRqstEntity = new BookingRequestEntity();
		BeanUtils.copyProperties(bookRqstBean, bookngRqstEntity);
		try {
			bookngRqstEntity.setBookingRef(BookingRefIdGenerator.getNextBookingRef());
			bookingDAO.insert(bookngRqstEntity);
		} catch (RuntimeException exp) {
			LoggerUtil.error(LOG, exp, "There is an issue in Cassandra DB operation for input:" + bookngRqstEntity);
			throw new DAOException(ExceptionConstants.DB_OPERATION_GENERAL_EXCEPTION_ERROR_MESSAGE);
		}
		return bookngRqstEntity;
	}

}
