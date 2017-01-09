package com.msrm.ws.calc.server;

import javax.jws.WebService;

@WebService(endpointInterface="com.msrm.ws.calc.server.Calculator")
public class CalculatorImpl implements Calculator {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

	@Override
	public double sub(double a, double b) {
		return a - b;
	}

	@Override
	public double mul(double a, double b) {
		return a * b;
	}

	@Override
	public double div(double a, double b) {
		return a / b;
	}

}
