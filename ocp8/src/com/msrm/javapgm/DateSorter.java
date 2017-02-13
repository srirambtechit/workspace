package com.msrm.javapgm;

import java.util.Arrays;
import java.util.Scanner;

public class DateSorter {

	private DateHolder[] dates;

	// Input date is pre-formatted one
	// Ex: DEC 09, 2016
	public DateSorter(String[] dates) {
		this.dates = new DateHolder[dates.length];
		for (int i = 0; i < dates.length; i++) {
			this.dates[i] = new DateHolder(dates[i]);
		}
	}

	public static void main(String[] args) {
		DateSorter app = new DateSorter(captureInput());

		System.out.println(Arrays.toString(app.dates));

		for (int i = 0; i < app.dates.length; i++) {
			for (int j = i + 1; j < app.dates.length; j++)
				if (app.dates[i].compareTo(app.dates[j]) > 0)
					swap(app.dates, i, j);
		}

		System.out.println(Arrays.toString(app.dates));
	}

	private static void swap(DateHolder[] dates, int i, int j) {
		DateHolder t = dates[i];
		dates[i] = dates[j];
		dates[j] = t;
	}

	public static void sort() {

	}

	public static String[] captureInput() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.printf("%nEnter number of dates: ");
			int n = in.nextInt();
			System.out.println("Enter date one by one in formate of Month date, year; \nEx: Sep 17, 1938\n");
			String[] dates = new String[n];

			// capturing first input
			in.nextLine();

			for (int i = 0; i < n; i++) {
				System.out.printf("Enter (%d): ", i);
				dates[i] = in.nextLine();
			}
			System.out.println(Arrays.toString(dates));
			return dates;
		}
	}

}
