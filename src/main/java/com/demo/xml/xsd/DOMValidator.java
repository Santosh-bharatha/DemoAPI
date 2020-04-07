package com.demo.xml.xsd;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DOMValidator {

	public static void main(String[] args) {

		try {
			File file = new File("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			// ErrorHandler h = new DefaultHandler();
			ErrorHandler handler = new MyErrorHandler();
			builder.setErrorHandler(handler);
			Document doc = builder.parse(file);
			System.out.println("File parsed successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

class MyErrorHandler implements ErrorHandler{

	@Override
	public void error(SAXParseException e) throws SAXException {
		printInfo(e);
	}

	private void printInfo(SAXParseException e) {
		System.out.println("   Public ID: "+e.getPublicId());
        System.out.println("   System ID: "+e.getSystemId());
        System.out.println("   Line number: "+e.getLineNumber());
        System.out.println("   Column number: "+e.getColumnNumber());
        System.out.println("   Message: "+e.getMessage());		
	}

	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		printInfo(e);
	}

	@Override
	public void warning(SAXParseException e) throws SAXException {
		printInfo(e);
	}
	
}
