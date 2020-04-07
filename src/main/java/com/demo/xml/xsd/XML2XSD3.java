package com.demo.xml.xsd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.xerces.xs.XSModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import jlibs.xml.sax.XMLDocument;
import jlibs.xml.xsd.XSInstance;
import jlibs.xml.xsd.XSParser;

public class XML2XSD3 {

	private static String xmlFilePath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml";
	private static String xmlSchema = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/cpcSchema.xsd";
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		try {
			boolean status;

			String filepath = "C:/Users/sbharatha/Documents/xsdfiles/xsd/";

			Path path = Paths.get(filepath);
			File file = new File(filepath);

			// checking if the directory exists
			if (!Files.exists(path)) {
				status = file.mkdirs();

				if (status)
					System.out.println("Directory created");
				else
					System.out.println("Some error occured");

			} else {
				System.out.println("Directory already exists");
			}

			XSModel xsModel = new XSParser().parse(xmlSchema);
			// creating all other folders
			file = new File(filepath + "xmlfile.xml");
			file.mkdirs();

			String filename = "C:/Users/sbharatha/Documents/xsdfiles/cpcSchema.xsd";
			// instance.

			final Document doc = loadXsdDocument(filename);

			// Find the docs root element and use it to find the targetNamespace
			final Element rootElem = doc.getDocumentElement();
			String targetNamespace = null;
			if (rootElem != null && rootElem.getNodeName().equals("xs:schema")) {
				targetNamespace = rootElem.getAttribute("");
			}

			// Parse the file into an XSModel object
			//org.apache.xerces.xs.XSModel xsModel = new jlibs.xml.xsd.XSParser().parse(filename);

			// Define defaults for the XML generation
			XSInstance instance = new XSInstance();
			instance.minimumElementsGenerated = 1;
			instance.maximumElementsGenerated = 1;
			instance.generateDefaultAttributes = true;
			instance.generateOptionalAttributes = true;
			instance.maximumRecursionDepth = 0;
			instance.generateAllChoices = true;
			instance.showContentModel = true;
			instance.generateOptionalElements = true;

			// Build the sample xml doc
			// Replace first param to XMLDoc with a file input stream to write to file
			//QName rootElement = new QName(targetNamespace, "classification-us");
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(xmlFilePath));
			document.getDocumentElement().normalize();
			
			//Element rootElement = doc.createElement("supp.data-block");
			 QName rootElement = new QName("", "");
			
			XMLDocument sampleXml = new XMLDocument(new StreamResult(System.out), true, 4, null);
			instance.generate(xsModel, rootElement, sampleXml);
			

			XMLDocument sampleXml2 = new XMLDocument(new StreamResult(new File("C:/Users/sbharatha/Documents/xsdfiles/XML3.xml")), true, 4, null);
			instance.generate(xsModel, rootElement, sampleXml2);
			
			System.out.println("*********");
			System.out.println(sampleXml);
			System.out.println("**************");

			/*
			 * TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 * Transformer transformer = transformerFactory.newTransformer(); DOMSource
			 * source = new DOMSource(doc); StreamResult result = new StreamResult(new
			 * File("D:\\newXML.xml")); transformer.setOutputProperty(OutputKeys.INDENT,
			 * "yes"); transformer.transform(source, result);
			 */

			/*
			 * TransformerFactory tf = TransformerFactory.newInstance(); Transformer
			 * transformer; transformer = tf.newTransformer(); FileOutputStream outStream =
			 * new FileOutputStream(new File(filepath)); transformer.transform(new
			 * DOMSource(doc), new StreamResult(outStream));
			 * 
			 * // Print XML or Logs or Console StringWriter writer = new StringWriter();
			 * transformer.transform(new DOMSource(doc), new StreamResult(writer)); String
			 * xmlString = writer.getBuffer().toString(); System.out.println(xmlString);
			 */

		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static QName getElementQName(Element el) {
	    return new QName(el.getNamespaceURI(), el.getLocalName());
	}
	
	

	public static Document loadXsdDocument(String inputName) {
		final String filename = inputName;

		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
		Document doc = null;

		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final File inputFile = new File(filename);
			doc = builder.parse(inputFile);
		} catch (final Exception e) {
			e.printStackTrace();
			// throw new ContentLoadException(msg);
		}

		return doc;
	}

}
