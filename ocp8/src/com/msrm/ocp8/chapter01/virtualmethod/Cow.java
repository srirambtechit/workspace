package com.msrm.ocp8.chapter01.virtualmethod;

public class Cow extends Animal {

	@Override
	void feed() {
		addHay();
	}

	private void addHay() {
	}

}
