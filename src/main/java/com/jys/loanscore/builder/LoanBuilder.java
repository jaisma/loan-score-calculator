package com.jys.loanscore.builder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jys.loanscore.model.Loan;

public class LoanBuilder {
	private Logger logger = Logger.getLogger("com.jys.loanscore.builder.LoanBuilder");

	public Loan buildLoan(String[] loanData) {

		if (loanData.length != 43) {
			logger.log(Level.FINE, Arrays.toString(loanData));
			logger.log(Level.FINE, "Incomplete loan data, returning empty loan");
			return new Loan();
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

		LocalDate dataExtractDate = LocalDate.parse(loanData[0] + "01", formatter);
		double portfolio = Double.parseDouble(loanData[1]);
		double loanId = Double.parseDouble(loanData[2]);
		double propertyId = Double.parseDouble(loanData[3]);
		double originalBalance = Double.parseDouble(loanData[4]);
		double currentBalance = Double.parseDouble(loanData[5]);
		double arrearsBalance = Double.parseDouble(loanData[6]);
		double monthsInAreears = Double.parseDouble(loanData[7]);
		double cms = Double.parseDouble(loanData[8]);
		double currentLTV = Double.parseDouble(loanData[9]);
		double originalLTV = Double.parseDouble(loanData[10]);
		double latestValuationAmount = Double.parseDouble(loanData[11]);
		LocalDate latestValuationDate = LocalDate.parse(loanData[12], formatter);
		String fitchProductCategory = loanData[13];
		String originatorProductCategory = loanData[14];
		String futherAdvance = loanData[15];
		LocalDate completionDate = LocalDate.parse(loanData[16], formatter);
		double originalTerm = Double.parseDouble(loanData[17]);
		LocalDate maturityDate = LocalDate.parse(loanData[18], formatter);
		String interestRateType = loanData[19];
		String currentIndex = loanData[20];
		String reversionaryIndex = loanData[21];
		double currentInterestRate = Double.parseDouble(loanData[22]);
		double currentMargin = Double.parseDouble(loanData[23]);
		double reversionaryMargin = Double.parseDouble(loanData[24]);
		LocalDate reversionDate = LocalDate.parse(loanData[25], formatter);
		String loanPurpose = loanData[26];
		String repaymentType = loanData[27];
		String ftbFlag = loanData[28];
		String rtbFlag = loanData[29];
		String selfCertFlag = loanData[30];
		String propertyType = loanData[31];
		String occupancy = loanData[32];
		String region = loanData[33];
		String tenure = loanData[34];
		String bankruptcyMarker = loanData[35];
		double numOfCCJs = Double.parseDouble(loanData[36]);
		double valueOfCCJs = Double.parseDouble(loanData[37]);
		double incomeBorrower1 = Double.parseDouble(loanData[38]);
		double indomeBorrower2 = Double.parseDouble(loanData[39]);
		double indexReferenceRate = Double.parseDouble(loanData[40]);
		String originator = loanData[41];
		String possessionFlag = loanData[42];

		return new Loan(dataExtractDate, portfolio, loanId, propertyId, originalBalance, currentBalance, arrearsBalance,
				monthsInAreears, cms, currentLTV, originalLTV, latestValuationAmount, latestValuationDate,
				fitchProductCategory, originatorProductCategory, futherAdvance, completionDate, originalTerm,
				maturityDate, interestRateType, currentIndex, reversionaryIndex, currentInterestRate, currentMargin,
				reversionaryMargin, reversionDate, loanPurpose, repaymentType, ftbFlag, rtbFlag, selfCertFlag,
				propertyType, occupancy, region, tenure, bankruptcyMarker, numOfCCJs, valueOfCCJs, incomeBorrower1,
				indomeBorrower2, indexReferenceRate, originator, possessionFlag);
	}
}
