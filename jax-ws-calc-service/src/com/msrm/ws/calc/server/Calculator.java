package com.msrm.ws.calc.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Calculator {

	@WebMethod
	double add(double a, double b);

	@WebMethod
	double sub(double a, double b);

	@WebMethod
	double mul(double a, double b);

	@WebMethod
	double div(double a, double b);

}
