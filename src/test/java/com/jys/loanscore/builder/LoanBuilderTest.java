package test.java.com.jys.loanscore.builder;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.jys.loanscore.builder.LoanBuilder;
import main.java.com.jys.loanscore.model.Loan;

class LoanBuilderTest {
	
	LoanBuilder testLoanBuilder;

	@BeforeEach
	void init() {
		testLoanBuilder = new LoanBuilder();

	}

	@Test
	void testBuildLoan() {
		String[] testDataI = new String[1];
		String[] testDataII = "200007,9969657.73,8684223.28,6351283.14,179622804.13,159158897.65,196932826.26,78818.84,30414.47,8.17,17.96,142487435.4,20040717,U,Biggest Yacht,Y,21990130,28.12,23730211,fixed,SVR,SVR,91.77,1.84,-1.45,23520116,OT,PP,N,Y,Y,OT,OWN,UK,Freehold,N,0.93,37579.2,46494.03,4137842.94,11.05,Verso,Super chill"
				.split(",");
		Loan resultI = testLoanBuilder.buildLoan(testDataI);
		Loan resultII = testLoanBuilder.buildLoan(testDataII);
		
		assertAll("loans", 
				() -> assertEquals(null, resultI.getBankruptcyMarker()),
				() -> assertTrue(null == resultI.getCms()), 
				() -> assertTrue(null == resultI.getLoanId()),
				() -> assertEquals("N", resultII.getBankruptcyMarker()), 
				() -> assertEquals("SVR", resultII.getCurrentIndex()),
				() -> assertTrue(8684223.28 == resultII.getLoanId())
		);
		
	}
	
	@Test
	void testLoanDataMemberTypes() {
		String[] testData = "200007,9969657.73,8684223.28,6351283.14,179622804.13,159158897.65,196932826.26,78818.84,30414.47,8.17,17.96,142487435.4,20040717,U,Biggest Yacht,Y,21990130,28.12,23730211,fixed,SVR,SVR,91.77,1.84,-1.45,23520116,OT,PP,N,Y,Y,OT,OWN,UK,Freehold,N,0.93,37579.2,46494.03,4137842.94,11.05,Verso,Super chill"
				.split(",");
		Loan result = testLoanBuilder.buildLoan(testData);
		
		assertAll("loans", 
				() -> assertTrue(result.getDataExtractDate() instanceof LocalDate),
				() -> assertTrue(result.getPortfolio() instanceof Double),
				() -> assertTrue(result.getLoanId() instanceof Double), 
				() -> assertTrue(result.getOriginatorProductCategory() instanceof String),
				() -> assertTrue(result.getReversionDate() instanceof LocalDate)
		);
		
	}

}
