package com.msrm.javapgm;

import java.util.Arrays;
import java.util.regex.Pattern;

public class DateHolder implements Comparable<DateHolder> {

	private enum MonthEnum {
		JAN(1), FEB(2), MAR(3), APR(4), MAY(5), JUN(6), JUL(7), AUG(8), SEP(9), OCT(10), NOV(11), DEC(12);

		int month;

		private MonthEnum(int month) {
			this.month = month;
		}

	}

	private String dateString;

	private int monthEndIndex = 3;
	private int dateEndIndex = 6;
	private int yearEndIndex = 12;

	public DateHolder(String dateString) {
		this.dateString = dateString;
		if (!validate(dateString)) {
			throw new IllegalArgumentException("Invalid input format or Date");
		}
	}

	private boolean validate(String dateString) {
		return dateString != null && Pattern.matches("^[a-zA-Z]{3} (\\d|[0-2]\\d|[3][0-1]), \\d{4}$", dateString)
				&& month() != -1;
	}

	public int date() {
		int len = dateString.length();

		return Integer.parseInt(dateString.substring(dateEndIndex - 2, dateEndIndex));
	}

	public int month() {
		try {
			return MonthEnum.valueOf(dateString.substring(monthEndIndex - 3, monthEndIndex).toUpperCase()).month;
		} catch (Exception e) {
			// Invalid Enum name given
			return -1;
		}
	}

	public int year() {
		return Integer.parseInt(dateString.substring(yearEndIndex - 4, yearEndIndex));
	}

	@Override
	public int compareTo(DateHolder o) {
		if (year() == o.year())
			if (month() == o.month())
				return date() == o.date() ? 0 : date() > o.date() ? 1 : -1;
			else
				return month() > o.month() ? 1 : -1;
		return year() > o.year() ? 1 : -1;
	}

	public static void main(String[] args) {

		// date variance
		// y1 == y2, m1 = m2, d1 = d2
		// y1 == y2, m1 = m2, d1 > d2
		// y1 == y2, m1 = m2, d1 < d2

		// month variance
		// y1 == y2, m1 > m2, d1 == d2
		// y1 == y2, m1 < m2, d1 == d2

		// year variance
		// y1 > y2, m1 == m2, d1 == d2
		// y1 < y2, m1 == m2, d1 == d2

		DateHolder d1 = new DateHolder("Aug 04, 2000");
		DateHolder d2 = new DateHolder("Jan 04, 1898");

		System.out.println(d1.compareTo(d2));

		DateHolder[] dhs = new DateHolder[6];
		dhs[0] = new DateHolder("Aug 24, 2000");
		dhs[1] = new DateHolder("Jan 13, 1898");
		dhs[2] = new DateHolder("Sep 01, 2001");
		dhs[3] = new DateHolder("Mar 28, 2013");
		dhs[4] = new DateHolder("SEP 01, 2001");
		dhs[5] = new DateHolder("Dec 31, 1991");
		System.out.println(Arrays.toString(dhs));

		// simple bubble sort
		for (int i = 0; i < dhs.length; i++) {
			for (int j = i + 1; j < dhs.length; j++)
				if (dhs[i].compareTo(dhs[j]) > 0)
					swap(dhs, i, j);
		}

		System.out.println(Arrays.toString(dhs));
		
		
		int e = 14;
		int o = 13;
		System.out.println(e & 1);

	}

	private static void swap(DateHolder[] dhs, int i, int j) {
		DateHolder tmp = dhs[i];
		dhs[i] = dhs[j];
		dhs[j] = tmp;
	}

	@Override
	public String toString() {
		return dateString + "; ";
	}

}
