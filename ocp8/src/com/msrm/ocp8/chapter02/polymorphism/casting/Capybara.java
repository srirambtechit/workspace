package com.msrm.ocp8.chapter02.polymorphism.casting;

public class Capybara extends Rodent {
	public static void main(String[] args) {
		Rodent rodent = new Rodent();

		// Throws ClassCastException at runtime
		Capybara capybara = (Capybara) rodent;

		// to avoid above runtime exception
		if (rodent instanceof Capybara) {
			Capybara cb = (Capybara) rodent;
		}

		// 1. below code runs finely
		Capybara cc = new Capybara();
		Rodent rr = (Rodent) cc;

		// 2. below code runs finely
		Rodent r = new Capybara();
		Capybara c = (Capybara) r;

		Fish fish = (Fish) rodent; // compile time error

	}
}