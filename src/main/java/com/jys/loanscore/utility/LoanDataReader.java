package com.jys.loanscore.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jys.loanscore.builder.LoanBuilder;
import com.jys.loanscore.model.Loan;

public class LoanDataReader {
	private Logger logger = Logger.getLogger("com.jys.loanscore.utility.LoanDataReader");

	public Set<Loan> getLoanData(String filePath) {

		Set<Loan> loans = new HashSet<>();
		LoanBuilder loanBuilder = new LoanBuilder();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
			String loanData = br.readLine(); // header
			while ((loanData = br.readLine()) != null) {
				String[] temp = loanData.split(",");
				if (temp.length == 43) {
					loans.add(loanBuilder.buildLoan(temp));
				} else {
					logger.log(Level.FINE,
							"Content of: \n" + Arrays.toString(temp) + "\ndoes not have full loan information.");
				}
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error occured while loading loan data" + e);
		}

		logger.log(Level.FINE, "Loaded " + loans.size() + " loan data");
		return loans;
	}
}
