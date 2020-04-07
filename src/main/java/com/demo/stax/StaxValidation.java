package com.demo.stax;


import javax.xml.validation.*;

import org.xml.sax.SAXException;

import javax.xml.transform.stax.*;
import javax.xml.stream.*;
import javax.xml.*;
import java.io.*;


public class StaxValidation {
	
	public static void main (String args[]) throws XMLStreamException, FactoryConfigurationError, SAXException, IOException {

        XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream("C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\classification.xml"));

        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File("C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\xsd\\CPCSchema.xsd"));

        Validator validator = schema.newValidator();
        validator.validate(new StAXSource(reader));

        //no exception thrown, so valid
        System.out.println("Document is valid");

    }
}
