package test.java.com.jys.loanscore.utility;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.jys.loanscore.builder.LoanBuilder;
import main.java.com.jys.loanscore.model.Loan;
import main.java.com.jys.loanscore.utility.RuleApplier;

class RuleApplierTest {

	RuleApplier testRuleApplier;

	@BeforeEach
	void init() {
		testRuleApplier = new RuleApplier();

	}

	@Test
	void testApplyAllRules() {
		LoanBuilder lb = new LoanBuilder();

		String[] zeroString = "200007,9969657.73,8684223.28,6351283.14,179622804.13,159158897.65,196932826.26,78818.84,30414.47,8.17,17.96,142487435.4,20040717,U,Biggest Yacht,Y,21990130,28.12,23730211,fixed,SVR,SVR,91.77,1.84,-1.45,23520116,OT,PP,N,Y,Y,OT,OWN,UK,Freehold,N,0.93,37579.2,46494.03,4137842.94,11.05,Verso,Super chill"
				.split(",");
		Loan zero = lb.buildLoan(zeroString);
		String[] oneString = "200312,5482069.72,8313437.86,3647514.95,53047679.07,182400120.23,128184619.87,20670.49,5426.1,6.67,10.19,22526779.41,20041003,P,Awesome Yacht,N,23460216,30.91,20110511,floating,OTH,3ML,56.72,1.64,-1.56,20770217,RE,IO,N,N,N,OT,BTL,US,Freehold,N,2.6,12706.79,30065.67,7228068.8,2.39,GMAC,Instagram stalker"
				.split(",");
		Loan one = lb.buildLoan(oneString);
		String[] twoString = "199505,4371504.51,4682779.29,1647374.3,106157203.6,56897728.75,110501011.51,95655.01,91952.74,11.62,11.77,196254595.02,19970418,L,Bungaloo,N,23330926,22.28,19950521,floating,FIX,SVR,63.4,0.37,-0.6,22260621,RE,OT,N,N,Y,BU,OWN,UK,Freehold,Y,0.45,34543.12,97013.41,9649734.66,7.46,Kensington,Clingy"
				.split(",");
		Loan two = lb.buildLoan(twoString);
		String[] threeString = "200109,5859314.25,4020748.85,3789362.8,36403985.41,145734255.95,175462816.28,6275.54,91185.91,19.72,11.84,68286247.69,20090105,M,Yacht,N,21870619,55.29,23650902,fixed,3ML,1ML,78.39,0.22,0.57,21640920,ND,RE,Y,Y,N,FD,BTL,US,Leasehold,N,3.92,56284.35,57280.84,7185871.65,9.79,Kensington,Clingy"
				.split(",");
		Loan three = lb.buildLoan(threeString);
		String[] fourString = "198912,5907286.08,5242236.97,4828741.02,28795082.93,171420324.89,99554218.57,58065.13,74247.78,10.2,19.29,171778647.4,20140519,U,Yacht,N,21270128,37.26,20280723,floating,1ML,BBR,99.15,-1.69,1.14,23390809,CO,OT,N,Y,Y,TH,SHO,UK,Freehold,Y,3.17,78186.17,36932.19,579691.08,9.67,Verso,Instagram stalker"
				.split(",");
		Loan four = lb.buildLoan(fourString);

		List<Integer> zerosExp = testRuleApplier.applyAllRules(zero);
		List<Integer> onesExp = testRuleApplier.applyAllRules(one);
		List<Integer> twosExp = testRuleApplier.applyAllRules(two);
		List<Integer> threesExp = testRuleApplier.applyAllRules(three);
		List<Integer> foursExp = testRuleApplier.applyAllRules(four);

		assertAll("rules", 
				() -> assertEquals(0, zerosExp.size()),
				() -> assertEquals(1, onesExp.get(0).intValue()), 
				() -> assertEquals(1, twosExp.get(0).intValue()),
				() -> assertEquals(2, twosExp.get(1).intValue()), 
				() -> assertEquals(3, threesExp.get(0).intValue()),
				() -> assertEquals(1, foursExp.get(0).intValue()), 
				() -> assertEquals(4, foursExp.get(1).intValue()));
	}

}
