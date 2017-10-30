package com.jys.loanscore.builder;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jys.loanscore.model.GradedLoan;
import com.jys.loanscore.model.Loan;
import com.jys.loanscore.utility.RuleApplier;
import com.jys.loanscore.utility.ScoreCalculator;

public class GradedLoanBuilder {
	private Logger logger = Logger.getLogger("com.jys.loanscore.builder.GradedLoanBuilder");

	public GradedLoan buildGradedLoan(double loanId, int score, List<Integer> exceptions) {
		return new GradedLoan(loanId, score, exceptions);
	}

	public GradedLoan buildGradedLoan(Loan loan) {
		RuleApplier ra = new RuleApplier();
		ScoreCalculator sc = new ScoreCalculator();
		double loanId = loan.getLoanId();
		List<Integer> exceptions = ra.applyAllRules(loan);
		int loanScore = sc.calculateScore(loan, exceptions);

		logger.log(Level.FINE, "calling other constructor");
		return buildGradedLoan(loanId, loanScore, exceptions);
	}
}
