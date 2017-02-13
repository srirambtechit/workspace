package com.msrm.ocp8.chapter03.collection;

import java.util.Comparator;

public class ChainingComparator implements Comparator<Squirrel> {

	public static void main(String[] args) {
		Squirrel s1 = new Squirrel("abc");
		Squirrel s2 = new Squirrel("def");

		ChainingComparator cc = new ChainingComparator();
		cc.compare(s1, s2);
	}

	@Override
	public int compare(Squirrel s1, Squirrel s2) {
		return Comparator.comparing((Squirrel s) -> s.getSpecies()).thenComparingInt(s -> s.getWeight()).compare(s1,
				s2);
	}

}
