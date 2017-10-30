package com.jys.loanscore.utility;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jys.loanscore.model.Loan;

class LoanDataReaderTest {

	LoanDataReader testLoanDataReader;
	String testInputFileLocation;

	@BeforeEach
	void init() {
		testLoanDataReader = new LoanDataReader();
		Path path = Paths.get("src/test/recources/testInput.csv");
		testInputFileLocation = path.toAbsolutePath().toString();
	}

	@Test
	void testGetLoanData() {
		Set<Loan> result = testLoanDataReader.getLoanData(testInputFileLocation);

		assertTrue(result.size() == 30);
	}

}
