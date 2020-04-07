package com.demo.jaxb;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class JAXBXmlBindExample {

	public static String xmloutput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/jaxboutput.xml";
	public static String xsdSchema = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xsd/CPCSchema.xsd";
	
	public static void main(String[] args) {

		Booking booking = new Booking();
		
		booking.setName("santosh");
		booking.setContact(123456);
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date startDate = null;
        Date endDate = null;

        File file = new File(xmloutput);
        try {
        	 startDate = formatter.parse("11/09/2012");
             endDate = formatter.parse("14/09/2012");
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setAddress("Aldie");
        
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
       
       // Schema xsdSchemaFile = new Schema();
        JAXBContext context = null;
        StringWriter xmlWriter = null;
        try {
        	context = JAXBContext.newInstance(Booking.class);
        	Marshaller jaxbMarshaller = context.createMarshaller();
        	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  true);
        	
        	jaxbMarshaller.marshal(booking, file);
        	
        //	jaxbMarshaller.marshal(booking, System.out);
        	marshaller(file, booking);
        }catch(JAXBException je) {
        	je.printStackTrace();
        }
        
	}

	public static void marshaller(File file, Booking booking) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Booking.class);
		Marshaller jaxbMarshaller = context.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  true);
    	jaxbMarshaller.marshal(booking, System.out);
	}
}
