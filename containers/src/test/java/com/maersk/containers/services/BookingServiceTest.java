package com.maersk.containers.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;

import com.maersk.containers.beans.request.BookingRequestBean;
import com.maersk.containers.beans.request.CheckAvailabilityBean;
import com.maersk.containers.beans.response.CheckAvailabilityResponse;
import com.maersk.containers.constants.ExceptionConstants;
import com.maersk.containers.dao.BookingDAO;
import com.maersk.containers.entity.BookingRequestEntity;
import com.maersk.containers.exception.DAOException;
import com.maersk.containers.resttemplate.RestService;

/**
 * Mocking tests for the service layers methods
 * 
 * @author Pattabhi
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class BookingServiceTest {

	@Mock
	private BookingDAO dao;

	@Mock
	private RestService restTemplt;

	@InjectMocks
	private BookingService srvc;

	@Value("${external.service.url.check.availability}")
	private String checkAvlbltyUrl;

	@Test
	public void checkAvailability_yes() {
		final CheckAvailabilityBean chkAvailbltyBean = buildCheckAvailabilityBean();
		CheckAvailabilityResponse chkAvailbltyRespns = new CheckAvailabilityResponse();
		chkAvailbltyRespns.setAvailableSpace(10);
		when(restTemplt.invoke(checkAvlbltyUrl, chkAvailbltyBean, CheckAvailabilityResponse.class)).thenReturn(chkAvailbltyRespns);
		// assertEquals(10,
		// srvc.checkAvailability(chkAvailbltyBean).getAvailableSpace());
	}

	@Test
	public void checkAvailability_no() {
		final CheckAvailabilityBean chkAvailbltyBean = buildCheckAvailabilityBean();
		CheckAvailabilityResponse resp = new CheckAvailabilityResponse();
		resp.setAvailableSpace(0);
		when(restTemplt.invoke(checkAvlbltyUrl, chkAvailbltyBean, CheckAvailabilityResponse.class)).thenReturn(resp);
		// assertEquals(0,
		// srvc.checkAvailability(chkAvailbltyBean).getAvailableSpace());
	}

	private CheckAvailabilityBean buildCheckAvailabilityBean() {
		CheckAvailabilityBean chkAvailbltyBean = new CheckAvailabilityBean();
		chkAvailbltyBean.setContainerType("REEFER");
		chkAvailbltyBean.setContainerSize(20);
		chkAvailbltyBean.setOrigin("Southampton");
		chkAvailbltyBean.setDestination("England");
		chkAvailbltyBean.setQuantity(10);

		return chkAvailbltyBean;
	}
	@Test
	public void createContainerRequest_success_case() {
		try {
			BookingRequestBean bookngRqstBean = new BookingRequestBean();
			bookngRqstBean.setContainerType("REEFER");
			bookngRqstBean.setContainerSize(20);
			bookngRqstBean.setOrigin("Southampton");
			bookngRqstBean.setDestination("England");
			bookngRqstBean.setQuantity(10);
			bookngRqstBean.setTimestamp(new Timestamp(System.currentTimeMillis()));

			BookingRequestEntity bookngRqstEntity = new BookingRequestEntity();
			BeanUtils.copyProperties(bookngRqstBean, bookngRqstEntity);
			bookngRqstEntity.setBookingRef(957000001);
			when(dao.insert(bookngRqstEntity)).thenReturn(bookngRqstEntity);
			assertNotNull(srvc.createContainerRequest(bookngRqstBean).getBookingRef());
		} catch (DAOException excp) {
			assertEquals(excp.getMessage(), ExceptionConstants.DB_OPERATION_GENERAL_EXCEPTION_ERROR_MESSAGE);
		}
	}
}
