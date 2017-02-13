package com.msrm.ocp8.chapter01.reviewquest;

public class Question06 {
	
	enum Flavors {
		VANILLA, CHOCOLATE, STRAWBERRY
	}

	public static void main(String[] args) {
		System.out.println(Flavors.CHOCOLATE.ordinal());
	}

}
