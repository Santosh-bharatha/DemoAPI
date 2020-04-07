package com.demo.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

public class CPCSTAXModifyDemo {

	public static final String xmlOutputFilePath = "C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\outputMarks.xml";
	public static final String xmlInputFilePath = "C:\\Users\\sbharatha\\Documents\\WorkStation_Spring\\DemoAPI\\src\\main\\resources\\cstar.xml";
	
	public static void main(String[] args) {
		XMLInputFactory factory = XMLInputFactory.newInstance();

		try {
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(xmlInputFilePath));
					
			SAXBuilder saxBuilder = new SAXBuilder();

			Document document = saxBuilder.build(new File(xmlInputFilePath));
			System.out.println(document.toString());
			Element rootElement = document.getRootElement();
			
			System.out.println(rootElement.toString());
			/*List<Element> applicationElement = rootElement.getChildren("application-number");

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();

				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					
					
						Iterator<Attribute> attributes = startElement.getAttributes();
						String applicationNumber = attributes.next().getValue();

						if (applicationNumber.equalsIgnoreCase("16295847")) {
							// get the applicatioNode with no 16295847

							for (int i = 0; i < applicationElement.size(); i++) {
								Element element = applicationElement.get(i);

								if (element.getAttribute("application-number").getValue().equalsIgnoreCase("16295847")) {
									element.removeChild("subgroup");
									element.addContent(new Element("subgroup").setText("180"));
								}
							}
						}
					
					break;
				}
			}
			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput.output(document, System.out);*/
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