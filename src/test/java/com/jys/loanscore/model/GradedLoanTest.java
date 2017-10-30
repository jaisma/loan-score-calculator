package com.jys.loanscore.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradedLoanTest {

	GradedLoan testGradedLoan;

	@BeforeEach
	void init() {
		testGradedLoan = new GradedLoan(12345.67, 82);
		List<Integer> testExceptionList = new LinkedList<>();
		// can't use factory method because they are immutable
		testExceptionList.add(1);
		testExceptionList.add(3);
		testGradedLoan.setExceptions(testExceptionList);
	}

	@Test
	void testRemoveException() {
		testGradedLoan.removeException(3);

		assertAll("exception list", 
				() -> assertTrue(testGradedLoan.getExceptions().size() == 1),
				() -> assertTrue(testGradedLoan.getExceptions().contains(1)),
				() -> assertTrue(!testGradedLoan.getExceptions().contains(3)));
	}

	@Test
	void testGetExceptionsString() {
		String actualString = testGradedLoan.getExceptionsString();
		assertEquals("1|3", actualString);
	}
}
