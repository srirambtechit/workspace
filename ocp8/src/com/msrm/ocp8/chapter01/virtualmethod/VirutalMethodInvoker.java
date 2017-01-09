package com.msrm.ocp8.chapter01.virtualmethod;

/**
 * virtual method invocation - it applies to methods only not for fields
 * 
 * @author srirammuthaiah
 *
 */
public class VirutalMethodInvoker {

	public static void main(String[] args) {
		Animal animal = new Bird();
		animal.feed();
	}

}
