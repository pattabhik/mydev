package com.practice.unittesting.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.unittesting.service.DataService;

/**
 * @author Pattabhi
 * 
 *         It will
 *
 */
@SpringBootTest
public class DAOImpTest2 {

	@Mock
	DataService dtSrvc;

	@InjectMocks
	DAOImpl impl = new DAOImpl();

	@Test
	public void testWithMock() {
		// case 1
		when(dtSrvc.retriveData()).thenReturn(Arrays.asList(1, 2, 3, 4));

		assertEquals(10, impl.calculateSum());
	}

	@Test
	public void testWithMockWithEmptyList() {
		// case 2 - empty list
		when(dtSrvc.retriveData()).thenReturn(new ArrayList<Integer>());

		assertEquals(10, impl.calculateSum());
	}

	@Test
	public void testWithMockWithNullList() {
		// case 3 - null list
		when(dtSrvc.retriveData()).thenReturn(null);

		assertEquals(10, impl.calculateSum());
	}
}
