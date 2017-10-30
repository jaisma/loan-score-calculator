package main.java.com.jys.loanscore.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class GradedLoan implements Comparator<GradedLoan> {

	private double id;
	private int grade;
	private List<Integer> exceptions;

	public GradedLoan() {
		id = 0;
		grade = 0;
		exceptions = new LinkedList<Integer>(); // default linkedList because more add/remove than lookup
	}

	public GradedLoan(double id, int grade) {
		this.id = id;
		this.grade = grade;
		this.exceptions = new LinkedList<Integer>();
	}

	public GradedLoan(double id, int grade, List<Integer> exceptions) {
		this.id = id;
		this.grade = grade;
		this.exceptions = exceptions;
	}

	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Integer> getExceptions() {
		return exceptions;
	}

	public void setExceptions(List<Integer> exceptions) {
		this.exceptions = exceptions;
	}

	public void addException(int exceptionId) {
		exceptions.add(exceptionId);
	}

	public void removeException(int exceptionId) {
		exceptions.remove(exceptions.indexOf(exceptionId));
	}

	public String getExceptionsString() {
		Collections.sort(exceptions);
		StringJoiner sj = new StringJoiner("|");
		for (int i : exceptions) {
			sj.add(Integer.toString(i));
		}
		return sj.toString();
	}

	@Override
	public int compare(GradedLoan arg0, GradedLoan arg1) {
		// ordering by id low to high; boolean check cause don't want to do casting
		return arg0.getId() < arg1.getId() ? 0 : 1;
	}
}