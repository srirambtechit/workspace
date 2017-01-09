package com.msrm.ocp8.chapter01.accessmodifier.cat.species;

import com.msrm.ocp8.chapter01.accessmodifier.cat.BigCat;

public class Lynx extends BigCat {

	// it is allowed
	boolean protectedMemebr = hasFur;

	// not allowed as it is different package
	boolean defaultMember = hasPaws;

	public static void main(String[] args) {
		BigCat cat = new BigCat();
		System.out.println(cat.name);

		// protected access - not accessible as it is in different package
		System.out.println(cat.hasFur);

		// below is legal as inheritance override protected access
		Lynx lynx = new Lynx();
		System.out.println(lynx.hasFur);

		// default access - not accessible as it is in different package
		// even though BigCat inherited to Lynx class
		System.out.println(cat.hasPaws);

		// private access - not accessible from outside class
		System.out.println(cat.id);
	}

}
