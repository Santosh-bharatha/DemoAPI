package com.demo.xml.format;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;

import org.springframework.beans.factory.annotation.Autowired;

public class StaxProcessor {

	
	private static final XMLEventFactory xmlef = XMLEventFactory.newInstance();


	@Autowired(required = false)
	public static void main(String[] args) {
		
		try {
			
			XMLOutputFactory factory = XMLOutputFactory.newInstance();
			
			PrintWriter out
			   = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
            
			XMLEventWriter xmlWriter = factory.createXMLEventWriter(out);
			
			xmlWriter.add(xmlef.createStartDocument());
			
			xmlWriter.add(xmlef.createStartElement("Horoscope-tag", null,null));
			
			xmlWriter.add(xmlef.createNamespace("http://www.w3.org/2001/XMLSchema-instance"));
			
			xmlWriter.add(xmlef.createStartElement("Horoscope-tag", null,null));
			
			xmlWriter.add(xmlef.createStartElement("chart-tag", null,null));
			
			xmlWriter.add(xmlef.createAttribute("name", "Rasi"));
			
			xmlWriter.add(xmlef.createStartElement("house-tag", null,null));
			
			xmlWriter.add(xmlef.createAttribute("no", "1"));
			
			xmlWriter.add(xmlef.createStartElement("planet-tag", null,null));
			xmlWriter.add(xmlef.createCharacters("Su"));
			//xmlWriter.add(xmlef.createEndElement("", null));
			xmlWriter.add(xmlef.createStartElement("planet-tag", null,null));
			xmlWriter.add(xmlef.createCharacters("Mo"));
			//xmlWriter.add(xmlef.createEndElement("planet-tag", null));
			xmlWriter.add(xmlef.createStartElement("planet-tag", null,null));
			xmlWriter.add(xmlef.createCharacters("Ma"));
			//xmlWriter.add(xmlef.createEndElement(XmlConsts.PLANET_TAG, null));
			
			
			
			xmlWriter.add(xmlef.createEndDocument());
			
			out.flush();
			out.close();

			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
			

	}
	
	public static XMLEventFactory getXmlEventFactory() {
		return xmlef;
	}
}
