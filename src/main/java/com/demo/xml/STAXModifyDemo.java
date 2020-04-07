package com.demo.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class STAXModifyDemo {

	public static final String xmlFilePath = "C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\outputMarks.xml";

	public static void main(String[] args) {

		XMLInputFactory factory = XMLInputFactory.newInstance();

		try {
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(
					"C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\marks.xml"));
			SAXBuilder saxBuilder = new SAXBuilder();

			Document document = saxBuilder.build(new File(
					"C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\marks.xml"));
			Element rootElement = document.getRootElement();
			List<Element> studentElements = rootElement.getChildren("student");

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();

					if (qName.equalsIgnoreCase("student")) {
						Iterator<Attribute> attributes = startElement.getAttributes();
						String rollNo = attributes.next().getValue();

						if (rollNo.equalsIgnoreCase("393")) {
							// get the student with roll no 393

							for (int i = 0; i < studentElements.size(); i++) {
								Element studentElement = studentElements.get(i);

								if (studentElement.getAttribute("rollno").getValue().equalsIgnoreCase("393")) {
									studentElement.removeChild("marks");
									studentElement.addContent(new Element("marks").setText("80"));
								}
							}
						}
					}
					break;
				}
			}
			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, System.out);
			//xmlOutput.output(document, new FileWriter(new File(xmlFilePath)));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}