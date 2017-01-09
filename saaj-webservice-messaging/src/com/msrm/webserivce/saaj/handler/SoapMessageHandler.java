package com.msrm.webserivce.saaj.handler;

import java.io.IOException;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;

public class SoapMessageHandler {

	public static SOAPMessage createSoapRequest(String number1, String number2) {
		try {
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();

			// create and form NameSpace for the envelope
			SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
			envelope.addNamespaceDeclaration("saaj", "http://server.calc.ws.msrm.com/");

			SOAPBody body = message.getSOAPBody();
			QName addName = new QName("http://server.calc.ws.msrm.com/", "add", "saaj");
			SOAPBodyElement bodyElement = body.addBodyElement(addName);

			QName arg0Name = new QName("arg0");
			SOAPElement arg0Element = bodyElement.addChildElement(arg0Name);
			arg0Element.addTextNode(number1);

			QName arg1Name = new QName("arg1");
			SOAPElement arg1Element = bodyElement.addChildElement(arg1Name);
			arg1Element.addTextNode(number2);

			message.saveChanges();
			message.writeTo(System.out);
			System.out.println();
			return message;
		} catch (SOAPException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void createSoapResponse(SOAPMessage response) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			Source xmlSource = response.getSOAPPart().getContent();
			Result outputTarget = new StreamResult(System.out);
			transformer.transform(xmlSource, outputTarget);
		} catch (TransformerException | DOMException | SOAPException e) {
			e.printStackTrace();
		}
	}

}
