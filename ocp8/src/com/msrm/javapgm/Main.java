package com.msrm.javapgm;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// getting the number of inputs as string
		System.out.print("numberOfInputs: ");
		String numberOfInputsAsString = in.nextLine();

		// Converting String to number
		int numberOfInputs = Integer.parseInt(numberOfInputsAsString);
		int[] valueOfDates = new int[numberOfInputs];
		String[] formattedDates = new String[numberOfInputs];

		// getting dates as string
		for (int i = 0; i < numberOfInputs; i++) {
			System.out.print("Enter the " + (i + 1) + " date: ");
			formattedDates[i] = in.nextLine();
		}

		// creating a value map for the dates
		createValueArray(formattedDates, valueOfDates);

		// sorting both the value array and string array based on values
		sortTheDates(numberOfInputs, valueOfDates, formattedDates);

		System.out.println("Output:-\n" + Arrays.toString(formattedDates));

		in.close();

	}

	private static void sortTheDates(int numberOfInputs, int[] valueOfDates, String[] formattedDates) {
		for (int j = 0; j < numberOfInputs; j++) {
			for (int k = j + 1; k < numberOfInputs; k++) {
				if (valueOfDates[j] > valueOfDates[k]) {
					valueOfDates[j] ^= valueOfDates[k];
					valueOfDates[k] ^= valueOfDates[j];
					valueOfDates[j] ^= valueOfDates[k];
					String temp;
					temp = formattedDates[j];
					formattedDates[j] = formattedDates[k];
					formattedDates[k] = temp;
				}
			}
		}
	}

	private static void createValueArray(String[] formattedDates, int[] valueOfDates) {
		int i = 0;
		for (String formattedDate : formattedDates) {
			String month = formattedDate.substring(0, 3);
			valueOfDates[i] = numberOfDays(formattedDate);
			int isLeapyear = isLeapyear(formattedDate);
			System.out.println("isLeapYear" + isLeapyear);
			switch (month) {
			case "Jan":
				valueOfDates[i] += 0;
				break;
			case "Feb":
				valueOfDates[i] += 31;
				break;
			case "Mar":
				valueOfDates[i] = valueOfDates[i] + 59 + isLeapyear;
				break;
			case "Apr":
				valueOfDates[i] = valueOfDates[i] + 90 + isLeapyear;
				break;
			case "May":
				valueOfDates[i] = valueOfDates[i] + 120 + isLeapyear;
				break;
			case "Jun":
				valueOfDates[i] = valueOfDates[i] + 151 + isLeapyear;
				break;
			case "Jul":
				valueOfDates[i] = valueOfDates[i] + 181 + isLeapyear;
				break;
			case "Aug":
				valueOfDates[i] = valueOfDates[i] + 212 + isLeapyear;
				break;
			case "Sep":
				valueOfDates[i] = valueOfDates[i] + 243 + isLeapyear;
				break;
			case "oct":
				valueOfDates[i] = valueOfDates[i] + 273 + isLeapyear;
				break;
			case "Nov":
				valueOfDates[i] = valueOfDates[i] + 304 + isLeapyear;
				break;
			case "Dec":
				valueOfDates[i] = valueOfDates[i] + 334 + isLeapyear;
				break;
			}
			i++;
		}
	}

	private static int isLeapyear(String formattedDate) {
		if ((Integer.parseInt(formattedDate.substring(8, 12)) % 4) == 0)
			return 1;
		else
			return 0;
	}

	private static int numberOfDays(String formattedDate) {
		int numberOfLeapYears = ((Integer.parseInt(formattedDate.substring(8, 12)) - 1) / 4);
		int numberOfLeapYeardays = ((Integer.parseInt(formattedDate.substring(8, 12)) - 1) / 4) * 366;
		int numberOfNonLeapYearsDays = ((Integer.parseInt(formattedDate.substring(8, 12)) - 1) - numberOfLeapYears)
				* 365;
		return (numberOfLeapYeardays + numberOfNonLeapYearsDays + Integer.parseInt(formattedDate.substring(4, 6)));
	}
}
