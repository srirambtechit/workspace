package com.msrm.cobertura.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.msrm.cobertura.TaxCalculator;

public class TaxCalculatorTest {

	@Test
	public void testBelow_2_5L_Positive() {
		assertTrue(TaxCalculator.computeTaxAmoute(150_000) == 0);
	}

	@Test
	public void testEqual_2_5L_Positive() {
		assertTrue(TaxCalculator.computeTaxAmoute(250_000) == 0);
	}

	@Test
	public void testAbove_2_5L_Positive() {
		assertTrue(TaxCalculator.computeTaxAmoute(250_500) == 25.5875f);
	}

	@Test
	public void testAbove_5L_Negative() {
		assertFalse(TaxCalculator.computeTaxAmoute(750_000) == 25587.5f);
	}

	@Test
	public void testAbove_5L_Positive() {
		assertTrue(TaxCalculator.computeTaxAmoute(750_000) == 51175.0f);
	}

}
