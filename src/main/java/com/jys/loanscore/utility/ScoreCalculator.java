package main.java.com.jys.loanscore.utility;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.jys.loanscore.model.Loan;

public class ScoreCalculator {
	private Logger logger = Logger.getLogger("com.jys.loanscore.utility.ScoreCalculator");

	public int calculateScore(Loan loan, List<Integer> exceptions) {

		int toSubtract = 0;
		String fitchProductCategory = loan.getFitchProductCategory();
		for (int i : exceptions) {
			if (i == 1) {
				toSubtract += exceptionOneCalculator(fitchProductCategory);
			} else if (i == 2) {
				toSubtract += exceptionTwoCalculator(fitchProductCategory);
			} else if (i == 3) {
				toSubtract += exceptionThreeCalculator(fitchProductCategory);
			} else if (i == 4) {
				toSubtract += exceptionFourCalculator(loan, fitchProductCategory);
			}
		}

		if (toSubtract > 100) {
			logger.log(Level.WARNING, "loan score of: " + (100 - toSubtract) + " is below 0, update scoring sheet");
		}

		return 100 - toSubtract;
	}

	public int exceptionOneCalculator(String fitchProductCategory) {
		if (fitchProductCategory.toLowerCase().equals("u")) {
			return 4;
		}
		if (fitchProductCategory.toLowerCase().equals("p")) {
			return 4;
		}
		if (fitchProductCategory.toLowerCase().equals("n")) {
			return 4;
		}
		if (fitchProductCategory.toLowerCase().equals("l")) {
			return 4;
		}
		if (fitchProductCategory.toLowerCase().equals("m")) {
			return 4;
		}
		if (fitchProductCategory.toLowerCase().equals("b")) {
			return 4;
		} else {
			return 0;
		}
	}

	public int exceptionTwoCalculator(String fitchProductCategory) {
		if (fitchProductCategory.toLowerCase().equals("u")) {
			return 1;
		}
		if (fitchProductCategory.toLowerCase().equals("p")) {
			return 1;
		}
		if (fitchProductCategory.toLowerCase().equals("n")) {
			return 1;
		}
		if (fitchProductCategory.toLowerCase().equals("l")) {
			return 2;
		}
		if (fitchProductCategory.toLowerCase().equals("m")) {
			return 2;
		}
		if (fitchProductCategory.toLowerCase().equals("b")) {
			return 3;
		} else {
			return 0;
		}
	}

	public int exceptionThreeCalculator(String fitchProductCategory) {
		if (fitchProductCategory.toLowerCase().equals("u")) {
			return 0;
		}
		if (fitchProductCategory.toLowerCase().equals("p")) {
			return 2;
		}
		if (fitchProductCategory.toLowerCase().equals("n")) {
			return 4;
		}
		if (fitchProductCategory.toLowerCase().equals("l")) {
			return 6;
		}
		if (fitchProductCategory.toLowerCase().equals("m")) {
			return 8;
		}
		if (fitchProductCategory.toLowerCase().equals("b")) {
			return 10;
		} else {
			return 0;
		}
	}

	public int exceptionFourCalculator(Loan loan, String fitchProductCategory) {
		double difference = loan.getCms() - ((loan.getIncomeBorrower1() + loan.getIncomeBorrower2()) / 12);
		double percentage = difference / (loan.getCms() * 100);

		if (fitchProductCategory.toLowerCase().equals("u")) {
			if (percentage >= 0.0 && percentage <= 10.0) {
				return 0;
			}
			if (percentage >= 10.01 && percentage <= 20.0) {
				return 0;
			}
			if (percentage >= 20.01 && percentage <= 30.0) {
				return 1;
			}
			if (percentage >= 30.01 && percentage <= 50.0) {
				return 3;
			}
			if (percentage >= 50.01 && percentage <= 100.0) {
				return 10;
			} else {
				return 0;
			}
		}
		if (fitchProductCategory.toLowerCase().equals("p")) {
			if (percentage >= 0.0 && percentage <= 10.0) {
				return 2;
			}
			if (percentage >= 10.01 && percentage <= 20.0) {
				return 3;
			}
			if (percentage >= 20.01 && percentage <= 30.0) {
				return 5;
			}
			if (percentage >= 30.01 && percentage <= 50.0) {
				return 12;
			}
			if (percentage >= 50.01 && percentage <= 100.0) {
				return 20;
			} else {
				return 0;
			}
		}
		if (fitchProductCategory.toLowerCase().equals("n")) {
			if (percentage >= 0.0 && percentage <= 10.0) {
				return 4;
			}
			if (percentage >= 10.01 && percentage <= 20.0) {
				return 6;
			}
			if (percentage >= 20.01 && percentage <= 30.0) {
				return 9;
			}
			if (percentage >= 30.01 && percentage <= 50.0) {
				return 20;
			}
			if (percentage >= 50.01 && percentage <= 100.0) {
				return 40;
			} else {
				return 0;
			}
		}
		if (fitchProductCategory.toLowerCase().equals("l")) {
			if (percentage >= 0.0 && percentage <= 10.0) {
				return 6;
			}
			if (percentage >= 10.01 && percentage <= 20.0) {
				return 10;
			}
			if (percentage >= 20.01 && percentage <= 30.0) {
				return 14;
			}
			if (percentage >= 30.01 && percentage <= 50.0) {
				return 30;
			}
			if (percentage >= 50.01 && percentage <= 100.0) {
				return 50;
			} else {
				return 0;
			}
		}
		if (fitchProductCategory.toLowerCase().equals("m")) {
			if (percentage >= 0.0 && percentage <= 10.0) {
				return 8;
			}
			if (percentage >= 10.01 && percentage <= 20.0) {
				return 13;
			}
			if (percentage >= 20.01 && percentage <= 30.0) {
				return 21;
			}
			if (percentage >= 30.01 && percentage <= 50.0) {
				return 40;
			}
			if (percentage >= 50.01 && percentage <= 100.0) {
				return 60;
			} else {
				return 0;
			}
		}
		if (fitchProductCategory.toLowerCase().equals("b")) {
			if (percentage >= 0.0 && percentage <= 10.0) {
				return 10;
			}
			if (percentage >= 10.01 && percentage <= 20.0) {
				return 20;
			}
			if (percentage >= 20.01 && percentage <= 30.0) {
				return 30;
			}
			if (percentage >= 30.01 && percentage <= 50.0) {
				return 50;
			}
			if (percentage >= 50.01 && percentage <= 100.0) {
				return 80;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
}
