package com.msrm.ocp8.chapter01.virtualmethod.fields;

/**
 * Notice how this technique is called virtual method invocation. Instance
 * variables don’t work this way. In this example, the Animal class refers to
 * name. It uses the one in the super- class and not the subclass.
 * 
 * @author srirammuthaiah
 *
 */
public class PlayWithAnimal {

	public static void main(String[] args) {
		Animal animal = new Lion();
		animal.printName(); // it still prints ???

		Lion lion = new Lion();
		lion.printName(); // always prints ??? no matter how it gets invoked
	}

}
