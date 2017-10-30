package com.jys.loanscore.utility;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jys.loanscore.model.GradedLoan;

class GradedLoanDataWriterTest {

	GradedLoanDataWriter testGradedLoanDataWriter;
	Set<GradedLoan> testGradedLoans;
	String testOutputDestination;

	@BeforeEach
	void init() {
		testGradedLoanDataWriter = new GradedLoanDataWriter();
		// testGradedLoans = new HashSet<>();
		// testGradedLoans.add(new GradedLoan(12345.67, 82, List.of(1, 3))); // arg
		// can't sort
		// testGradedLoans.add(new GradedLoan(98765.43, 39, List.of(2, 3, 4)));
		List<Integer> first = new ArrayList<>();
		List<Integer> second = new ArrayList<>();
		first.add(1);
		first.add(3);
		second.add(3);
		second.add(2);
		second.add(4);
		testGradedLoans = Set.of(new GradedLoan(12345.67, 82, first), new GradedLoan(98765.43, 39, second));

		Path path = Paths.get("src/test/recources/testOutput.csv");
		testOutputDestination = path.toAbsolutePath().toString();

	}

	@Test
	void testWriteGradedLoanDataToCSV() {
		testGradedLoanDataWriter.writeGradedLoanDataToCSV(testGradedLoans, testOutputDestination);

		List<String> outputLines = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(testOutputDestination))) {
			String outputLine;
			while ((outputLine = br.readLine()) != null) {
				outputLines.add(outputLine);
			}
		} catch (IOException e) {
			fail("can't seem to read generated test output file");
		}

		assertAll("graded loan output", () -> assertEquals("Loan ID,Loan Grade,Exception IDs", outputLines.get(0)),
				() -> assertTrue(outputLines.contains("12345.67,82,1|3")),
				() -> assertTrue(outputLines.contains("98765.43,39,2|3|4"))
		);
	}

}
