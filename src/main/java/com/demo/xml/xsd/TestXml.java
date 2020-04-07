package com.demo.xml.xsd;

import java.io.File;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.stream.StreamResult;

import org.apache.xerces.xs.XSModel;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import jlibs.xml.sax.XMLDocument;
import jlibs.xml.xsd.XSInstance;
import jlibs.xml.xsd.XSParser;

public class TestXml {

	private static String xmlSchema = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/cpcSchema.xsd";
	
	public static void main(String[] args) throws TransformerConfigurationException {

		File[] samplexsd = new File("C:/Users/sbharatha/Documents/xsdfiles/").listFiles();

		//Create resulting folder
		if(!new File("SampleXML").exists()) new File("SampleXML").mkdir();

		//Default options
		XSInstance instance = new XSInstance();
		instance.minimumElementsGenerated = 0;
		instance.maximumElementsGenerated = 0;
		instance.generateDefaultAttributes = false;
		instance.generateOptionalAttributes = false;
		instance.maximumRecursionDepth = 0;
		instance.generateOptionalElements = true;
		
		
		String filename = "C:/Users/sbharatha/Documents/xsdfiles/cpcSchema.xsd";

		final Document doc = loadXsdDocument(filename);
		final Element rootElem = doc.getDocumentElement();
		String targetNamespace = null;
		if (rootElem != null && rootElem.getNodeName().equals("xs:schema")) {
			targetNamespace = rootElem.getAttribute("");
		}
		QName rootElement = new QName(targetNamespace, "cpcSchema");
		XMLDocument sampleXml = new XMLDocument(new StreamResult(System.out), true, 4, null);

		for (int i = 0; i < samplexsd.length; i++) {
			if(samplexsd[i].isFile() && samplexsd[i].getName().contains("xsd")) { //Eliminate directories and make sure is a schema
				XSModel xsModel = new XSParser().parse(samplexsd[i].getAbsolutePath());	
				//Name the result
				XMLDocument sample = new XMLDocument(new StreamResult("SampleXML/" + samplexsd[i].getName().substring(0, samplexsd[i].getName().indexOf(".")) + ".xml"), false, 4, null);

				try {
					instance.generate(xsModel, rootElement, sample);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}		
		System.out.println("Done --- check your the SampleXML folder");
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
