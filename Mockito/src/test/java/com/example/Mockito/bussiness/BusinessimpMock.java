package com.example.Mockito.bussiness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class BusinessimpMock {

	@Test
	void test() {
		Dataservice service = mock(Dataservice.class);
		when(service.retrievedata()).thenReturn(new int[] { 25, 5, 1 });
		Businessimp business = new Businessimp(service);
		int result = business.findgreater();
		assertEquals(25, result);
	}

	@Test
	void test1() {
		Dataservice service = mock(Dataservice.class);
		when(service.retrievedata()).thenReturn(new int[] { 2, 5, 1 });
		Businessimp business = new Businessimp(service);
		int result = business.findgreater();
		assertEquals(5, result);
	}

}
