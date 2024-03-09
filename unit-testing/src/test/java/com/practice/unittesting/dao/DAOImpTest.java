package com.practice.unittesting.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.practice.unittesting.service.DataService;

/**
 * @author Pattabhi
 *
 */
class DataServiceImpl implements DataService {

	@Override
	public List<Integer> retriveData() {
		return Arrays.asList(1, 2, 3, 4);
	}

}

@TestInstance(Lifecycle.PER_CLASS)
public class DAOImpTest {

	@Test
	public void calculateSum() {
		DAOImpl impl = new DAOImpl();
		assertEquals(10, impl.calculateSum(Arrays.asList(1, 2, 3, 4)));
	}

	@Test
	public void calclateSumWithService() {
		DAOImpl impl = new DAOImpl();
		impl.setDataSrvc(new DataServiceImpl());

		assertEquals(10, impl.calculateSum());
	}

	DAOImpl impl = new DAOImpl();
	DataService dtSrvc = mock(DataService.class);

	@BeforeAll
	public void before() {
		impl.setDataSrvc(dtSrvc);
	}

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
