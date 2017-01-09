package com.msrm.ocp8.chapter01.virtualmethod;

public class Lion extends Animal {

	@Override
	void feed() {
		addMeat();
	}

	private void addMeat() {
	}

}
