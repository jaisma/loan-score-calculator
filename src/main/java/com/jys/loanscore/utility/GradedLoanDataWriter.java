package main.java.com.jys.loanscore.utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;
import java.util.StringJoiner;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.jys.loanscore.model.GradedLoan;

public class GradedLoanDataWriter {
	private Logger logger = Logger.getLogger("com.jys.loanscore.utility.GradedLoanDataWriter");

	public void writeGradedLoanDataToCSV(Set<GradedLoan> gradedLoans, String outputDestination) {

		try (Writer writer = new FileWriter(outputDestination)) {
			writer.write("Loan ID,Loan Grade,Exception IDs\n"); // header line
			for (GradedLoan gl : gradedLoans) {
				StringJoiner sj = new StringJoiner(",");
				sj.add(Double.toString(gl.getId()));
				sj.add(Integer.toString(gl.getGrade()));
				sj.add(gl.getExceptionsString());
				logger.log(Level.FINER, "Processed string: " + sj.toString());
				writer.write(sj.toString() + "\n");
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error occured while generating output csv file." + e);
		}

	}
}
