package test.java.com.jys.loanscore.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.jys.loanscore.model.Loan;
import main.java.com.jys.loanscore.model.Rules;

class RulesTest {

	Rules testRules;
	Loan testLoan;
	DateTimeFormatter formatter;
	LocalDate testDateBefore;
	LocalDate testDateAfter;

	@BeforeEach
	void init() {
		testRules = new Rules();
		testLoan = new Loan();

		formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		testDateBefore = LocalDate.parse("20171031", formatter);
		testDateAfter = LocalDate.parse("20171101", formatter);

	}

	@Test
	void testmaturityDateCompletionDateRule() {
		testLoan.setMaturityDate(testDateBefore);
		testLoan.setCompletionDate(testDateAfter);

		assertTrue(testRules.maturityDateCompletionDateRule(testLoan));

		testLoan.setMaturityDate(testDateAfter);

		assertTrue(!testRules.maturityDateCompletionDateRule(testLoan));
	}

	@Test
	void testCurIndexcurMarginRule() {
		testLoan.setCurrentIndex("FIX");
		testLoan.setCurrentMargin(10.10);
		testLoan.setCurrentInterestRate(5.55);

		assertTrue(testRules.curIndexcurMarginRule(testLoan));

		testLoan.setCurrentIndex("OTH");

		assertTrue(!testRules.curIndexcurMarginRule(testLoan));
	}

	@Test
	void testCurLTVoriLTVRule() {
		testLoan.setCurrentLTV(10.011);
		testLoan.setOriginalLTV(10.01);

		assertTrue(testRules.curLTVoriLTVRule(testLoan));

		testLoan.setOriginalLTV(11.01);

		assertTrue(!testRules.curLTVoriLTVRule(testLoan));

	}

	@Test
	void testCmsIncomeBorrowerRule() {
		testLoan.setCms(25.01);
		testLoan.setIncomeBorrower1(100.0);
		testLoan.setIncomeBorrower2(200.0);

		assertTrue(testRules.cmsIncomeBorrowerRule(testLoan));

		testLoan.setCms(15.0);

		assertTrue(!testRules.cmsIncomeBorrowerRule(testLoan));
	}

}
