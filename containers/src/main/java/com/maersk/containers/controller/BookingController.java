package com.maersk.containers.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maersk.containers.beans.request.BookingRequestBean;
import com.maersk.containers.beans.request.BookingRequestResponseBean;
import com.maersk.containers.beans.response.CheckAvailabilityBean;
import com.maersk.containers.beans.response.CheckAvailabilityResponse;
import com.maersk.containers.beans.response.CheckAvailabilityResponseBean;
import com.maersk.containers.constants.ControllerMappings;
import com.maersk.containers.entity.BookingRequestEntity;
import com.maersk.containers.log.LoggerUtil;
import com.maersk.containers.services.BookingService;

import reactor.core.publisher.Mono;

/**
 * Restcontroller for booking container request mappings
 * 
 * @author Pattabhi
 *
 */
@RestController
@RequestMapping(ControllerMappings.ROOT_CONTEXT_REQUEST_MAPPING)
public class BookingController {

	private static final Logger LOG = LoggerFactory.getLogger(BookingController.class);

	/**
	 * Booking service autowire
	 */
	@Autowired
	private BookingService bkngSrvc;

	/**
	 * post request mapping for checking the availability of container
	 * 
	 * @param bean
	 * @param result
	 * @return
	 */
	@PostMapping(value = ControllerMappings.CHECK_CONTAINER_AVAILABILITY_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<CheckAvailabilityResponseBean>> checkAvailability(
			@RequestBody @Valid CheckAvailabilityBean bean)
	{
		LoggerUtil.info(LOG, "checkAvailability request");
		final CheckAvailabilityResponseBean respBean = new CheckAvailabilityResponseBean();
		final CheckAvailabilityResponse srvcCalRspns = bkngSrvc.checkAvailability(bean);
		if (srvcCalRspns != null && srvcCalRspns.getAvailableSpace() > 0) {
			respBean.setAvailable(true);
		}
		return Mono.just(new ResponseEntity<>(respBean, HttpStatus.OK));
	}

	/**
	 * post request mapping for saving the booking request
	 * 
	 * @param bean
	 * @param result
	 * @return
	 */
	@PostMapping(value = ControllerMappings.BOOK_CONTAINER_REQUEST_MAPPING, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<ResponseEntity<BookingRequestResponseBean>> bookContainer(@RequestBody @Valid BookingRequestBean bean)
	{
		LoggerUtil.info(LOG, "bookContainer request");
		final BookingRequestEntity entity = bkngSrvc.createContainerRequest(bean);
		return Mono.just(new ResponseEntity<>(new BookingRequestResponseBean(String.valueOf(entity.getBookingRef())),
				HttpStatus.OK));
	}

}
