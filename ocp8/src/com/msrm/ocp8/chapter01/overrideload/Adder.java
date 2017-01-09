package com.msrm.ocp8.chapter01.overrideload;

/**
 * overloaded methods are present, Java looks for the closest match first.
 * 
 * - Exact match by type
 * 
 * - Matching a superclass type
 * 
 * - Converting to a larger primitive type
 * 
 * - Converting to an autoboxed type
 * 
 * - Varargs
 * 
 * @author srirammuthaiah
 *
 */
public class Adder {

	public void add(int a, int b) {
		System.out.println("int Primitive");
	}

	public void add(Integer a, Integer b) {
		System.out.println("Integer Wrapper");
	}

	public void add(Number a, Number b) {
		System.out.println("Superclass Type");
	}

	public void add(Integer... a) {
		System.out.println(a.length);
		System.out.println("Varargs");
	}

	protected void process(String data) {
	}

	public static void staticMethod() {
		System.out.println("Adder - staticMethod");
	}

	public Number findNumber(int a) {
		System.out.println("Adder - findNumber");
		return null;
	}

	public void readAllData(String file) throws Exception {
	}

	public static void main(String[] args) {
		Adder p = new Adder();
		// 3, 2 are int types, so primitive exact match
		p.add(3, 2);

		// Wrapper method invoked
		Integer a = 4;
		Integer b = 3;
		p.add(a, b);

		// Superclass type
		Float f = 3.3f;
		Integer i = 2;
		p.add(f, i);

		// Varargs
		Integer[] ints = {};
		p.add(ints);
	}

}
