package com.msrm.ocp8.chapter01.accessmodifier.cat;

public class CatAdmirer {

	public static void main(String[] args) {
		BigCat cat = new BigCat();

		// public access - allowed
		System.out.println(cat.name);

		// protected access - same package so accessible
		System.out.println(cat.hasFur);

		// default access - same package so accessible
		System.out.println(cat.hasPaws);

		// private access - not allowed as it is outside
		System.out.println(cat.id);
	}

}