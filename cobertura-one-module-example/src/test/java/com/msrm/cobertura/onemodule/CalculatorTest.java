package com.msrm.cobertura.onemodule;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void shouldCalculateFibonacci() {
		Calculator calculator = new Calculator();
		int expected = 13;
		int actual = calculator.nextFibonacci(5, 8);

		Assert.assertTrue(actual == expected);

	}
}