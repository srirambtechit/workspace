package com.msrm.ocp8.chapter01.overrideload;

import java.io.IOException;

/**
 * For overriding, the overridden method has a few rules:
 * 
 * - The access modifier must be the same or more accessible.
 * 
 * - The return type must be the same or a more restrictive type, also known as
 * covariant return types.
 * 
 * - If any checked exceptions are thrown, only the same exceptions or
 * subclasses of those exceptions are allowed to be thrown.
 * 
 * - The methods must not be static. (If they are, the method is hidden and not
 * overridden.)
 * 
 * @author srirammuthaiah
 *
 */
public class AdvanceAdder extends Adder {

	// same or more accessible, from protected to public
	// access which is allowed
	@Override
	public void process(String data) {
		System.out.println("AdvanceAdder - process");
	}

	// Return type is Integer whereas in parent class it is Number
	// Integer is child of Number type, so it is covariant return type
	// which is completely legal
	public Integer findNumber(int a) {
		System.out.println("AdvanceAdder - findNumber");
		return null;
	}

	// Adder.readAllData throws Exception, however, AdvanceAdder.readAllData
	// throws IOException which is acceptable as IOException is child of
	// Exception class
	public void readAllData(String file) throws IOException {
	}

	// it is not overridden, as Adder.staticMethod is hidden, which is bound to
	// Adder class as it is static nature. this method bound to AdvanceAdder
	public static void staticMethod() {
		System.out.println("AdvanceAdder - staticMethod");
	}

	public static void main(String[] args) {
		AdvanceAdder aa = new AdvanceAdder();
		aa.add(3, 4);
		// it is not encouraged, should be called
		// as AdvanceAdder.staticMethod();
		aa.staticMethod();

		Adder a = new Adder();
		// same as above
		a.staticMethod();

	}

}
