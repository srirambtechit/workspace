package com.msrm.ocp8.chapter02.polymorphism;

public class Lemur extends Primate implements HasTail {
	public int age = 10;

	public boolean isTailStriped() {
		return false;
	}

	public static void main(String[] args) {
		Lemur lemur = new Lemur();
		System.out.println(lemur.age);
		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());
		Primate primate = lemur;
		System.out.println(primate.hasHair());

		HasTail ht = lemur;
		int a = ((Lemur) ht).age;

		Primate p = lemur;
		p.isTailStriped(); // doesn't compile
	}
}