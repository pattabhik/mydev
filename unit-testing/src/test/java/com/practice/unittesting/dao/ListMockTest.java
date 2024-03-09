package com.practice.unittesting.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;

/**
 * @author Pattabhi
 *
 */
public class ListMockTest {

	List lstMck = mock(List.class);

	@Test
	public void testSize() {
		when(lstMck.size()).thenReturn(5);
		assertEquals(5, lstMck.size());
	}

	@Test
	public void testDifferentSizes() {
		when(lstMck.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, lstMck.size());
		assertEquals(10, lstMck.size());
	}

	@Test
	public void testGetIndex() {
		when(lstMck.get(0)).thenReturn("Pattabhi");
		assertEquals("Pattabhi", lstMck.get(0));
	}

	@Test
	public void testGetIndexAny() {
		when(lstMck.get(ArgumentMatchers.anyInt())).thenReturn("Pattabhi");
		assertEquals("Pattabhi", lstMck.get(0));
		assertEquals("Pattabhi", lstMck.get(1));
		assertEquals("Pattabhi", lstMck.get(2));
	}

	@Test
	public void testVerify() {
		lstMck.get(ArgumentMatchers.anyInt());
		lstMck.get(ArgumentMatchers.anyInt());
		// this is to verify that get method is called once
		// verify(lstMck).get(ArgumentMatchers.anyInt());

		// this is to verify that get method is called 2 times otherwise it will fail
		verify(lstMck, times(2)).get(ArgumentMatchers.anyInt());
	}

	@Test
	public void argumentCapturing() {
		lstMck.add("Pattabhi Ramaiah");

		// verify that the string passed to add method is expected or not
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(lstMck).add(captor.capture());

		assertEquals("Pattabhi Ramaiah", captor.getValue());
	}

	@Test
	public void spying() {
		ArrayList<String> spyList = spy(ArrayList.class);
		
		ArrayList<String> list = new ArrayList<>();

		when(spyList.get(0)).thenReturn(null);
		when(list.get(0)).thenReturn(null);
	}

}
