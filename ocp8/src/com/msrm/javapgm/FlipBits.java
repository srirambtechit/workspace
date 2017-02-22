package com.msrm.javapgm;

import java.util.Scanner;

public class FlipBits {

	public static void main(String[] args) {
		FlipBits fp = new FlipBits();		
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] nums = new long[n];
		while (n != 0) {
			nums[--n] = in.nextLong();
		}

		for (long num : nums) {
			long result = fp.flip(num);
			System.out.printf("%-10d - %d%n", num, result);
		}

		in.close();
	}

	public long flip(long n) {
		return n ^ 0xFFFFFFFFL;
	}

}




