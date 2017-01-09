package com.msrm.ws.calc.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.msrm.ws.calc.server.Calculator;

public class CalcClient {

	public static void main(String[] args) {
		try {
			URL wsdl = new URL("http://localhost:9900/ws/calc?wsdl");
			QName serviceName = new QName("http://server.calc.ws.msrm.com/", "CalculatorImplService");
			Service calcService = Service.create(wsdl, serviceName);
			Calculator calculator = calcService.getPort(Calculator.class);
			double a = 23.22;
			double b = 13.13;
			System.out.println(calculator.add(a, b));
			System.out.println(calculator.sub(a, b));
			System.out.println(calculator.mul(a, b));
			System.out.println(calculator.div(a, b));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
