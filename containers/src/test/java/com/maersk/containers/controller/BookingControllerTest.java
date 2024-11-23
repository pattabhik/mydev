package com.maersk.containers.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.maersk.containers.beans.request.BookingRequestBean;
import com.maersk.containers.beans.request.CheckAvailabilityBean;
import com.maersk.containers.beans.response.BookingRequestResponseBean;
import com.maersk.containers.beans.response.CheckAvailabilityResponse;
import com.maersk.containers.beans.response.CheckAvailabilityResponseBean;
import com.maersk.containers.entity.BookingRequestEntity;
import com.maersk.containers.services.BookingService;

import reactor.core.publisher.Mono;

/**
 * Mock tests for controller class methods
 * @author Pattabhi
 */
@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {
	@Mock
	private BookingService bkngSrvc;

	@InjectMocks
	private BookingController bkngCntlr;

	@Test
	public void checkAvailability() throws Exception {
		CheckAvailabilityBean chkAvailbltyBean = new CheckAvailabilityBean();
		chkAvailbltyBean.setContainerType("REEFER");
		chkAvailbltyBean.setContainerSize(20);
		chkAvailbltyBean.setOrigin("Southampton");
		chkAvailbltyBean.setDestination("England");
		chkAvailbltyBean.setQuantity(10);

		final CheckAvailabilityResponse chkAvailbltyRespns = new CheckAvailabilityResponse();
		chkAvailbltyRespns.setAvailableSpace(10);
		boolean retrnVal = true;
		// when(bkngSrvc.checkAvailability(chkAvailbltyBean)).thenReturn(chkAvailbltyRespns);
		Mono<ResponseEntity<CheckAvailabilityResponseBean>> checkAvailability = bkngCntlr.checkAvailability(chkAvailbltyBean);
		checkAvailability.subscribe(result -> assertEquals(retrnVal, result.getBody().isAvailable()));

	}

	@Test
	public void bookingController() throws Exception {
		BookingRequestBean bookngRqstBean = new BookingRequestBean();
		bookngRqstBean.setContainerType("REEFER");
		bookngRqstBean.setContainerSize(20);
		bookngRqstBean.setOrigin("Southampton");
		bookngRqstBean.setDestination("England");
		bookngRqstBean.setQuantity(10);
		bookngRqstBean.setTimestamp(new Timestamp(System.currentTimeMillis()));

		String retrnVal = "957000001";
		final BookingRequestEntity bookngRqstEntity = new BookingRequestEntity();
		BeanUtils.copyProperties(bookngRqstBean, bookngRqstEntity);
		bookngRqstEntity.setBookingRef(Integer.valueOf(retrnVal));
		when(bkngSrvc.createContainerRequest(bookngRqstBean)).thenReturn(bookngRqstEntity);

		Mono<ResponseEntity<BookingRequestResponseBean>> bookContainer = bkngCntlr.bookContainer(bookngRqstBean);
		bookContainer.subscribe(result -> assertEquals(retrnVal, result.getBody().getBookingRef()));
	}
}
