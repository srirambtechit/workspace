package com.msrm.ws.calc.endpoint;

import javax.xml.ws.Endpoint;

import com.msrm.ws.calc.server.CalculatorImpl;

public class CalcPublisher {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9900/ws/calc", new CalculatorImpl());
		System.out.println("Calculator service is up and running...");
	}

}
