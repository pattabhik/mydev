package com.maersk.containers.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.containers.beans.request.BookingRequestBean;
import com.maersk.containers.beans.response.CheckAvailabilityBean;
import com.maersk.containers.constants.ControllerConstants;
import com.maersk.containers.entity.BookingRequestEntity;
import com.maersk.containers.log.LoggerUtil;
import com.maersk.containers.services.BookingService;

/**
 * Restcontroller for booking container request mappings
 * 
 * @author Pattabhi
 *
 */
@RestController
@RequestMapping(ControllerConstants.ROOT_CONTEXT_REQUEST_MAPPING)
public class BookingController {

	private static final Logger LOG = LoggerFactory.getLogger(BookingController.class);

	/**
	 * Booking service autowire
	 */
	@Autowired
	private transient BookingService bkngSrvc;

	/**
	 * post request mapping for checking the availability of container
	 * 
	 * @param bean
	 * @param result
	 * @return
	 */
	@PostMapping(value = ControllerConstants.CHECK_CONTAINER_AVAILABILITY_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> checkAvailability(@RequestBody @Valid CheckAvailabilityBean bean)
	{
		LoggerUtil.info(LOG, "checkAvailability request");
		return new ResponseEntity<>(bkngSrvc.checkAvailability(), HttpStatus.OK);
	}

	/**
	 * post request mapping for saving the booking request
	 * 
	 * @param bean
	 * @param result
	 * @return
	 */
	@PostMapping(value = ControllerConstants.BOOK_CONTAINER_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> bookContainer(@RequestBody @Valid BookingRequestBean bean)
	{
		LoggerUtil.info(LOG, "bookContainer request");

		final BookingRequestEntity entity = new BookingRequestEntity();
		BeanUtils.copyProperties(bean, entity);
		entity.setContainerType(bean.getContainerType().toString());
		return new ResponseEntity<>(bkngSrvc.createContainerRequest(entity), HttpStatus.OK);
	}

}
