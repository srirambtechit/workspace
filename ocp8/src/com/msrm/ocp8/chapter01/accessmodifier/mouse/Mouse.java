package com.msrm.ocp8.chapter01.accessmodifier.mouse;

import com.msrm.ocp8.chapter01.accessmodifier.cat.BigCat;

public class Mouse {

	public static void main(String[] args) {
		BigCat cat = new BigCat();

		// public access - legal in access
		System.out.println(cat.name);

		// protected access - not accessible as it is different package
		System.out.println(cat.hasFur);

		// default access - not visible in access from different package
		System.out.println(cat.hasPaws);

		// private access - not accessible outside of BigCat
		System.out.println(cat.id);
	}

}