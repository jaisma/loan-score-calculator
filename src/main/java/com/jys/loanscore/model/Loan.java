package com.jys.loanscore.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Loan implements Comparator<Loan> {
	LocalDate dataExtractDate;
	Double portfolio;
	Double loanId;
	Double propertyId;
	Double originalBalance;
	Double currentBalance;
	Double arrearsBalance;
	Double monthsInAreears;
	Double cms;
	Double currentLTV;
	Double originalLTV;
	Double latestValuationAmount;
	LocalDate latestValuationDate;
	String fitchProductCategory;
	String originatorProductCategory;
	String futherAdvance;
	LocalDate completionDate;
	Double originalTerm;
	LocalDate maturityDate;
	String interestRateType;
	String currentIndex;
	String reversionaryIndex;
	Double currentInterestRate;
	Double currentMargin;
	Double reversionaryMargin;
	LocalDate reversionDate;
	String loanPurpose;
	String repaymentType;
	String ftbFlag;
	String rtbFlag;
	String selfCertFlag;
	String propertyType;
	String occupancy;
	String region;
	String tenure;
	String bankruptcyMarker;
	Double numOfCCJs;
	Double valueOfCCJs;
	Double incomeBorrower1;
	Double incomeBorrower2;
	Double indexReferenceRate;
	String originator;
	String possessionFlag;

	public Loan() {
	}

	public Loan(LocalDate dataExtractDate, Double portfolio, Double loanId, Double propertyId, Double originalBalance,
			Double currentBalance, Double arrearsBalance, Double monthsInAreears, Double cms, Double currentLTV,
			Double originalLTV, Double latestValuationAmount, LocalDate latestValuationDate,
			String fitchProductCategory, String originatorProductCategory, String futherAdvance,
			LocalDate completionDate, Double originalTerm, LocalDate maturityDate, String interestRateType,
			String currentIndex, String reversionaryIndex, Double currentInterestRate, Double currentMargin,
			Double reversionaryMargin, LocalDate reversionDate, String loanPurpose, String repaymentType,
			String ftbFlag, String rtbFlag, String selfCertFlag, String propertyType, String occupancy, String region,
			String tenure, String bankruptcyMarker, Double numOfCCJs, Double valueOfCCJs, Double incomeBorrower1,
			Double indomeBorrower2, Double indexReferenceRate, String originator, String possessionFlag) {
		this.dataExtractDate = dataExtractDate;
		this.portfolio = portfolio;
		this.loanId = loanId;
		this.propertyId = propertyId;
		this.originalBalance = originalBalance;
		this.currentBalance = currentBalance;
		this.arrearsBalance = arrearsBalance;
		this.monthsInAreears = monthsInAreears;
		this.cms = cms;
		this.currentLTV = currentLTV;
		this.originalLTV = originalLTV;
		this.latestValuationAmount = latestValuationAmount;
		this.latestValuationDate = latestValuationDate;
		this.fitchProductCategory = fitchProductCategory;
		this.originatorProductCategory = originatorProductCategory;
		this.futherAdvance = futherAdvance;
		this.completionDate = completionDate;
		this.originalTerm = originalTerm;
		this.maturityDate = maturityDate;
		this.interestRateType = interestRateType;
		this.currentIndex = currentIndex;
		this.reversionaryIndex = reversionaryIndex;
		this.currentInterestRate = currentInterestRate;
		this.currentMargin = currentMargin;
		this.reversionaryMargin = reversionaryMargin;
		this.reversionDate = reversionDate;
		this.loanPurpose = loanPurpose;
		this.repaymentType = repaymentType;
		this.ftbFlag = ftbFlag;
		this.rtbFlag = rtbFlag;
		this.selfCertFlag = selfCertFlag;
		this.propertyType = propertyType;
		this.occupancy = occupancy;
		this.region = region;
		this.tenure = tenure;
		this.bankruptcyMarker = bankruptcyMarker;
		this.numOfCCJs = numOfCCJs;
		this.valueOfCCJs = valueOfCCJs;
		this.incomeBorrower1 = incomeBorrower1;
		this.incomeBorrower2 = indomeBorrower2;
		this.indexReferenceRate = indexReferenceRate;
		this.originator = originator;
		this.possessionFlag = possessionFlag;
	}

	public LocalDate getDataExtractDate() {
		return dataExtractDate;
	}

	public void setDataExtractDate(LocalDate dataExtractDate) {
		this.dataExtractDate = dataExtractDate;
	}

	public Double getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Double portfolio) {
		this.portfolio = portfolio;
	}

	public Double getLoanId() {
		return loanId;
	}

	public void setLoanId(Double loanId) {
		this.loanId = loanId;
	}

	public Double getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Double propertyId) {
		this.propertyId = propertyId;
	}

	public Double getOriginalBalance() {
		return originalBalance;
	}

	public void setOriginalBalance(Double originalBalance) {
		this.originalBalance = originalBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Double getArrearsBalance() {
		return arrearsBalance;
	}

	public void setArrearsBalance(Double arrearsBalance) {
		this.arrearsBalance = arrearsBalance;
	}

	public Double getMonthsInAreears() {
		return monthsInAreears;
	}

	public void setMonthsInAreears(Double monthsInAreears) {
		this.monthsInAreears = monthsInAreears;
	}

	public Double getCms() {
		return cms;
	}

	public void setCms(Double cms) {
		this.cms = cms;
	}

	public Double getCurrentLTV() {
		return currentLTV;
	}

	public void setCurrentLTV(Double currentLTV) {
		this.currentLTV = currentLTV;
	}

	public Double getOriginalLTV() {
		return originalLTV;
	}

	public void setOriginalLTV(Double originalLTV) {
		this.originalLTV = originalLTV;
	}

	public Double getLatestValuationAmount() {
		return latestValuationAmount;
	}

	public void setLatestValuationAmount(Double latestValuationAmount) {
		this.latestValuationAmount = latestValuationAmount;
	}

	public LocalDate getLatestValuationDate() {
		return latestValuationDate;
	}

	public void setLatestValuationDate(LocalDate latestValuationDate) {
		this.latestValuationDate = latestValuationDate;
	}

	public String getFitchProductCategory() {
		return fitchProductCategory;
	}

	public void setFitchProductCategory(String fitchProductCategory) {
		this.fitchProductCategory = fitchProductCategory;
	}

	public String getOriginatorProductCategory() {
		return originatorProductCategory;
	}

	public void setOriginatorProductCategory(String originatorProductCategory) {
		this.originatorProductCategory = originatorProductCategory;
	}

	public String getFutherAdvance() {
		return futherAdvance;
	}

	public void setFutherAdvance(String futherAdvance) {
		this.futherAdvance = futherAdvance;
	}

	public LocalDate getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDate completionDate) {
		this.completionDate = completionDate;
	}

	public Double getOriginalTerm() {
		return originalTerm;
	}

	public void setOriginalTerm(Double originalTerm) {
		this.originalTerm = originalTerm;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getInterestRateType() {
		return interestRateType;
	}

	public void setInterestRateType(String interestRateType) {
		this.interestRateType = interestRateType;
	}

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	public String getReversionaryIndex() {
		return reversionaryIndex;
	}

	public void setReversionaryIndex(String reversionaryIndex) {
		this.reversionaryIndex = reversionaryIndex;
	}

	public Double getCurrentInterestRate() {
		return currentInterestRate;
	}

	public void setCurrentInterestRate(Double currentInterestRate) {
		this.currentInterestRate = currentInterestRate;
	}

	public Double getCurrentMargin() {
		return currentMargin;
	}

	public void setCurrentMargin(Double currentMargin) {
		this.currentMargin = currentMargin;
	}

	public Double getReversionaryMargin() {
		return reversionaryMargin;
	}

	public void setReversionaryMargin(Double reversionaryMargin) {
		this.reversionaryMargin = reversionaryMargin;
	}

	public LocalDate getReversionDate() {
		return reversionDate;
	}

	public void setReversionDate(LocalDate reversionDate) {
		this.reversionDate = reversionDate;
	}

	public String getLoanPurpose() {
		return loanPurpose;
	}

	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}

	public String getRepaymentType() {
		return repaymentType;
	}

	public void setRepaymentType(String repaymentType) {
		this.repaymentType = repaymentType;
	}

	public String getFtbFlag() {
		return ftbFlag;
	}

	public void setFtbFlag(String ftbFlag) {
		this.ftbFlag = ftbFlag;
	}

	public String getRtbFlag() {
		return rtbFlag;
	}

	public void setRtbFlag(String rtbFlag) {
		this.rtbFlag = rtbFlag;
	}

	public String getSelfCertFlag() {
		return selfCertFlag;
	}

	public void setSelfCertFlag(String selfCertFlag) {
		this.selfCertFlag = selfCertFlag;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTenure() {
		return tenure;
	}

	public void setTenure(String tenure) {
		this.tenure = tenure;
	}

	public String getBankruptcyMarker() {
		return bankruptcyMarker;
	}

	public void setBankruptcyMarker(String bankruptcyMarker) {
		this.bankruptcyMarker = bankruptcyMarker;
	}

	public Double getNumOfCCJs() {
		return numOfCCJs;
	}

	public void setNumOfCCJs(Double numOfCCJs) {
		this.numOfCCJs = numOfCCJs;
	}

	public Double getValueOfCCJs() {
		return valueOfCCJs;
	}

	public void setValueOfCCJs(Double valueOfCCJs) {
		this.valueOfCCJs = valueOfCCJs;
	}

	public Double getIncomeBorrower1() {
		return incomeBorrower1;
	}

	public void setIncomeBorrower1(Double incomeBorrower1) {
		this.incomeBorrower1 = incomeBorrower1;
	}

	public Double getIncomeBorrower2() {
		return incomeBorrower2;
	}

	public void setIncomeBorrower2(Double incomeBorrower2) {
		this.incomeBorrower2 = incomeBorrower2;
	}

	public Double getIndexReferenceRate() {
		return indexReferenceRate;
	}

	public void setIndexReferenceRate(Double indexReferenceRate) {
		this.indexReferenceRate = indexReferenceRate;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getPossessionFlag() {
		return possessionFlag;
	}

	public void setPossessionFlag(String possessionFlag) {
		this.possessionFlag = possessionFlag;
	}

	@Override
	public int compare(Loan arg0, Loan arg1) {
		// ordering by id low to high portfolioId
		return arg0.getPortfolio() < arg1.getPortfolio() ? 0 : 1;
	}

}