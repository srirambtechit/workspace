package com.msrm.ocp8.chapter01.reviewquest;

public enum Question17 {
	MAMMAL(true), FISH(Boolean.FALSE), BIRD(false), REPTILE(false), AMPHIBIAN(false), INVERTEBRATE(false);
	boolean hasHair;

	public Question17(boolean hasHair) {
		this.hasHair = hasHair;
	}

	public boolean hasHair() {
		return hasHair;
	}

	public void giveWig() {
		hasHair = true;
	}
}