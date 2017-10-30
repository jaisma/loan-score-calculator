package com.jys.loanscore.model;

public class Rules {

	public boolean maturityDateCompletionDateRule(Loan loan) {

		return loan.getMaturityDate().isBefore(loan.getCompletionDate());
	}

	public boolean curIndexcurMarginRule(Loan loan) {

		return loan.getCurrentIndex().toLowerCase().equals("fix")
				&& loan.getCurrentMargin() != loan.getCurrentInterestRate();
	}

	public boolean curLTVoriLTVRule(Loan loan) {

		return loan.getCurrentLTV() > loan.getOriginalLTV();
	}

	public boolean cmsIncomeBorrowerRule(Loan loan) {

		return loan.getCms() > ((loan.getIncomeBorrower1() + loan.getIncomeBorrower2()) / 12);
	}
}
