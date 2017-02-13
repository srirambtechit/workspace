package com.msrm.javapgm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * <pre>
 * 
 * You are given a list of size , initialized with zeroes. You have to perform  operations on 
 * the list and output the maximum of final values of all the  elements in the list. For every 
 * operation, you are given three integers ,  and  and you have to add value  to all the elements 
 * ranging from index  to (both inclusive).
 *
 *Input Format
 *
 * First line will contain two integers  and  separated by a single space.
 * Next  lines will contain three integers ,  and  separated by a single space.
 * Numbers in list are numbered from  to . 
 * 
 * Constraints
 * 
 * 3 <= N <= 10^7
 * 1 <= M <= 2*10^5
 * 1 <= a <= b <= N
 * 0 <= k <= 10^9
 * 
 * Output Format
 * 
 * A single line containing maximum value in the updated list.
 * 
 * Sample Input
 * 
 * 5 3
 * 1 2 100
 * 2 5 100
 * 3 4 100
 * 
 * 
 * Sample Output
 * 
 * 200
 * 
 * 
 * Explanation
 * 
 * After first update list will be 100 100 0 0 0. 
 * After second update list will be 100 200 100 100 100.
 * After third update list will be 100 200 200 200 100.
 * So the required answer will be 200.
 * 
 * </pre>
 * 
 * @author srirammuthaiah
 *
 */
public class MaxFinderList {

	private int N;
	private int M;

	private int[] startAt;
	private int[] endAt;
	private int[] values;

	private int[] numbers;

	public MaxFinderList(String file) {
		initDataFromFile(file);
		if (!validate()) {
			throw new IllegalArgumentException("Input is not matched with constraint");
		}
	}

	/**
	 * <pre>
	 * Constraints
	 * 
	 * 3 <= N <= 10^7
	 * 1 <= M <= 2*10^5
	 * 1 <= a <= b <= N
	 * 0 <= k <= 10^9
	 * </pre>
	 * 
	 * @return
	 */
	private boolean validate() {
		if (!((N >= 3 && N <= Math.pow(10, 7)) || (1 <= M && M <= 2 * Math.pow(10, 5)))) {
			return false;
		}

		for (int i = 0; i < M; i++) {
			if (!(1 <= startAt[i] && startAt[i] <= endAt[i] && endAt[i] <= N)) {
				return false;
			}
			if (!(0 <= values[i] && values[i] <= Math.pow(10, 9))) {
				return false;
			}
		}
		return true;
	}

	private void initDataFromFile(String file) {
		try (Scanner in = new Scanner(new FileInputStream(file))) {
			String[] first = in.nextLine().split(" ");
			this.N = Integer.parseInt(first[0]);
			this.M = Integer.parseInt(first[1]);

			this.numbers = new int[N];

			this.startAt = new int[M];
			this.endAt = new int[M];
			this.values = new int[M];

			int i = 0;
			while (in.hasNext()) {
				String[] string = in.nextLine().split(" ");
				startAt[i] = Integer.parseInt(string[0]);
				endAt[i] = Integer.parseInt(string[1]);
				this.values[i++] = Integer.parseInt(string[2]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int findMax() {
		int max = 0;
		for (int i = 0; i < M; i++) {
			for (int j = startAt[i], k = endAt[i]; j <= k; j++) {
				numbers[j] += values[i];
				System.out.printf("%d %d %d %n", j, k, numbers[j]);
				max = Math.max(numbers[j], max);
			}
		}
		return max;
	}

	public static void main(String[] args) {
		MaxFinderList app = new MaxFinderList("max-finder-list.txt");
		int max = app.findMax();
		System.out.println(max);

	}

}
