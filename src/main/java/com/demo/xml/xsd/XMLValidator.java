package com.demo.xml.xsd;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.EventReaderDelegate;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public class XMLValidator {
	public static final String XML_FILE = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml";

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {


		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent dtd = eventFactory.createDTD("<!DOCTYPE supplemental-pub-data SYSTEM \"u-suppub8-2012-12-04.dtd\"[]>");

		XMLInputFactory inFactory = XMLInputFactory.newInstance();
		XMLOutputFactory outFactory = XMLOutputFactory.newInstance();
		XMLEventReader reader = inFactory.createXMLEventReader(new StreamSource(XML_FILE));
		reader = new DTDReplacer(reader, dtd);
		XMLEventWriter writer = outFactory.createXMLEventWriter(System.out);
		writer.add(reader);
		writer.flush();

	}
}

class DTDReplacer extends EventReaderDelegate {

	private final XMLEvent dtd;
	private boolean sendDtd = false;

	public DTDReplacer(XMLEventReader reader, XMLEvent dtd) {
		super(reader);
		if (dtd.getEventType() != XMLEvent.DTD) {
			throw new IllegalArgumentException("" + dtd);
		}
		this.dtd = dtd;
	}

	@Override
	public XMLEvent nextEvent() throws XMLStreamException {
		if (sendDtd) {
			sendDtd = false;
			return dtd;
		}
		XMLEvent evt = super.nextEvent();
		if (evt.getEventType() == XMLEvent.START_DOCUMENT) {
			sendDtd = true;
		} else if (evt.getEventType() == XMLEvent.DTD) {
			// discard old DTD
			return super.nextEvent();
		}
		return evt;
	}

}