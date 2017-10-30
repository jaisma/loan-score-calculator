package com.jys.loanscore;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jys.loanscore.builder.GradedLoanBuilder;
import com.jys.loanscore.model.GradedLoan;
import com.jys.loanscore.model.Loan;
import com.jys.loanscore.utility.GradedLoanDataWriter;
import com.jys.loanscore.utility.LoanDataReader;

public class LoanScoreCalculator {

	static Logger pkgLogger = Logger.getLogger("com.jys.loanscore");
	static Logger logger = Logger.getLogger("com.jys.loanscore.Main");

	public static void main(String[] args) throws Exception {

		logger.log(Level.WARNING, "all data is stored in memory at once with current impl");

		// read in loan data and create loan objects
		logger.log(Level.INFO, "Loading loan data from: " + args[0]);
		Set<Loan> loans = new LoanDataReader().getLoanData(args[0]);

		// take every loan objects and create gradedLoan objects
		logger.log(Level.INFO, "Grading " + loans.size() + " data");
		Set<GradedLoan> gradedLoans = new HashSet<>();
		GradedLoanBuilder gld = new GradedLoanBuilder();
		loans.forEach(loan -> gradedLoans.add(gld.buildGradedLoan(loan)));

		// generate output csv file from set of graded loans
		logger.log(Level.INFO, "Generating CSV output at: " + args[1]);
		GradedLoanDataWriter gldw = new GradedLoanDataWriter();
		gldw.writeGradedLoanDataToCSV(gradedLoans, args[1]);
		
		logger.log(Level.INFO, "Complete");
	}

}
