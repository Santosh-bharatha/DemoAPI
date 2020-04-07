package com.demo.xml.xsd;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLUtils {
	
	private XMLUtils() {}

	public static void main(String[] args) throws ParserConfigurationException, IOException {
		
		 System.out.println(XMLUtils.validateWithDTDUsingDOM("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml"));

	}

	// validate using DOM (DTD as defined in the XML)
	  public static boolean validateWithDTDUsingDOM(String xml) 
	    throws ParserConfigurationException, IOException
	  {
	    try {
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      factory.setValidating(true);
	      factory.setNamespaceAware(true);

	      DocumentBuilder builder = factory.newDocumentBuilder();

	     
	      builder.parse(new InputSource(xml));
	      return true;
	    }
	    catch (ParserConfigurationException pce) {
	      throw pce;
	    } 
	    catch (IOException io) {
	      throw io;
	    }
	    catch (SAXException se){
	      return false;
	    }
	  }
}
