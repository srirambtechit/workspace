package com.msrm.ocp8.chapter01.virtualmethod.tricky;

public abstract class Animal {

	public void careFor() {
		play();
	}

	public void play() {
		System.out.println("Pet animal");
	}
}
