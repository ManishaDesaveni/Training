package com.example.Mockito.bussiness;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BusinessimpTest {

	@Test
	void test() {
		DataserviceStub service = new DataserviceStub();
		Businessimp business = new Businessimp(service);
		int result = business.findgreater();
		assertEquals(5, result);
	}

}

class DataserviceStub implements Dataservice {

	@Override
	public int[] retrievedata() {
		// TODO Auto-generated method stub
		return new int[] { 2, 5, 1, 3 };
	}

}
