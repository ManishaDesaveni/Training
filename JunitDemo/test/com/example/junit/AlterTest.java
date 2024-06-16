package com.example.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AlterTest {

	@Test
	void test() {
		Mymath math = new Mymath();
		assertEquals(3, math.alter(-3));
	}

	@Test
	void test1() {
		Mymath math = new Mymath();
		assertEquals(-2, math.alter(2));
	}

	@Test
	void test2() {
		boolean test = true;
		assertTrue(test);
	}

	@Test
	void test3() {
		boolean test = false;
		assertFalse(test);
	}

}
