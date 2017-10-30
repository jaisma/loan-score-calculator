package main.java.com.jys.loanscore.utility;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import main.java.com.jys.loanscore.model.Loan;
import main.java.com.jys.loanscore.model.Rules;

public class RuleApplier {
	private Logger logger = Logger.getLogger("com.jys.loanscore.utility.RuleApplier");

	public List<Integer> applyAllRules(Loan loan) {
		List<Integer> exceptions = new LinkedList<>();
		Rules rules = new Rules();

		// i could combine these but oh well
		int one = rules.maturityDateCompletionDateRule(loan) ? 1 : -1;
		int two = rules.curIndexcurMarginRule(loan) ? 2 : -1;
		int three = rules.curLTVoriLTVRule(loan) ? 3 : -1;
		int four = rules.cmsIncomeBorrowerRule(loan) ? 4 : -1;

		if (one != -1)
			exceptions.add(one);
		if (two != -1)
			exceptions.add(two);
		if (three != -1)
			exceptions.add(three);
		if (four != -1)
			exceptions.add(four);

		logger.log(Level.FINE, "total exceptions applied to: " + loan.getLoanId() + " = " + exceptions.size());
		return exceptions;
	}
}
