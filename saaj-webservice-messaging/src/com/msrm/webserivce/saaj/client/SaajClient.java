package com.msrm.webserivce.saaj.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import com.msrm.webserivce.saaj.handler.SoapMessageHandler;

/**
 * SOAP with Attachment API for Java is the Java based API to form SOAP messages
 * without writing XML code manually. Programmatically SOAP XML will be formed
 * and easy to transport for complex business flows
 * 
 * @author srirammuthaiah
 *
 */
public class SaajClient {

	private static Logger logger = Logger.getLogger(SaajClient.class.getName());

	public static void main(String[] args) {
		SOAPConnection connection = null;
		try {
			SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
			connection = factory.createConnection();
			URL url = new URL("http://localhost:9900/ws/calc?wsdl");
			SOAPMessage request = SoapMessageHandler.createSoapRequest(Double.toString(32.12), Double.toString(12.01));
			SOAPMessage response = connection.call(request, url);
			
			SoapMessageHandler.createSoapResponse(response);
			
			System.out.println();
			System.out.println(response);
			
		} catch (UnsupportedOperationException | SOAPException | MalformedURLException e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, "Problem occurred while processing SOAP request");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SOAPException e) {
					e.printStackTrace();
					logger.log(Level.SEVERE, "Problem while closing SOAP connection");
				}
			}
		}
	}

}
