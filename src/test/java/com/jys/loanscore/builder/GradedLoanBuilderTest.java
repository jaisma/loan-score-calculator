package test.java.com.jys.loanscore.builder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.jys.loanscore.builder.GradedLoanBuilder;
import main.java.com.jys.loanscore.builder.LoanBuilder;
import main.java.com.jys.loanscore.model.GradedLoan;
import main.java.com.jys.loanscore.model.Loan;

class GradedLoanBuilderTest {

	GradedLoanBuilder testGradedLoanBuilder;

	@BeforeEach
	void init() {
		testGradedLoanBuilder = new GradedLoanBuilder();

	}

	@Test
	void testBuildGradedLoan() {
		LoanBuilder lb = new LoanBuilder();

		String[] testStringI = "200007,9969657.73,8684223.28,6351283.14,179622804.13,159158897.65,196932826.26,78818.84,30414.47,8.17,17.96,142487435.4,20040717,U,Biggest Yacht,Y,21990130,28.12,23730211,fixed,SVR,SVR,91.77,1.84,-1.45,23520116,OT,PP,N,Y,Y,OT,OWN,UK,Freehold,N,0.93,37579.2,46494.03,4137842.94,11.05,Verso,Super chill"
				.split(",");
		Loan testI = lb.buildLoan(testStringI);
		String[] testStringII = "200312,5482069.72,8313437.86,3647514.95,53047679.07,182400120.23,128184619.87,20670.49,5426.1,6.67,10.19,22526779.41,20041003,P,Awesome Yacht,N,23460216,30.91,20110511,floating,OTH,3ML,56.72,1.64,-1.56,20770217,RE,IO,N,N,N,OT,BTL,US,Freehold,N,2.6,12706.79,30065.67,7228068.8,2.39,GMAC,Instagram stalker"
				.split(",");
		Loan testII = lb.buildLoan(testStringII);

		GradedLoan resultI = testGradedLoanBuilder.buildGradedLoan(testI);
		GradedLoan resultII = testGradedLoanBuilder.buildGradedLoan(testII);

		assertAll("graded loans", 
				() -> assertEquals("", resultI.getExceptionsString()),
				() -> assertEquals(100, resultI.getGrade()), 
				() -> assertEquals(8684223.28, resultI.getId()),
				() -> assertEquals("1", resultII.getExceptionsString()), 
				() -> assertEquals(96, resultII.getGrade()),
				() -> assertEquals(8313437.86, resultII.getId())
		);

	}

}
