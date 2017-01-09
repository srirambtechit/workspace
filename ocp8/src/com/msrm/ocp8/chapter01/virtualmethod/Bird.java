package com.msrm.ocp8.chapter01.virtualmethod;

public class Bird extends Animal {

	@Override
	void feed() {
		addSeed();
	}

	private void addSeed() {
	}

}
