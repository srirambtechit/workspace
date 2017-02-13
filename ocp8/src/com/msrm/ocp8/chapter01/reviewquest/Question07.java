package com.msrm.ocp8.chapter01.reviewquest;

import com.msrm.ocp8.chapter01.reviewquest.Question06.Flavors;

public class Question07 {

	public static void main(String[] args) {
		Flavors f = Flavors.STRAWBERRY;
		switch (f) {
		case 0:
			System.out.println("vanilla");
		case 1:
			System.out.println("chocolate");
		case 2:
			System.out.println("strawberry");
			break;
		default:
			System.out.println("missing flavor");
		}
	}
}