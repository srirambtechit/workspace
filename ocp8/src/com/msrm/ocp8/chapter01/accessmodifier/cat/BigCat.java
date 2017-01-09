package com.msrm.ocp8.chapter01.accessmodifier.cat;

public class BigCat {
	public String name = "cat";
	protected boolean hasFur = true;
	boolean hasPaws = true;
	private int id;

	// completely legal to access all variables inside the same class
	public static void main(String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);
		System.out.println(cat.hasFur);
		System.out.println(cat.hasPaws);
		System.out.println(cat.id);
	}

}