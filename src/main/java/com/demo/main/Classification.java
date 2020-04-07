package com.demo.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Classification {

	private static String xmlFilePath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml";
	private static String xmlOutputPath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/outputCPC.txt";
	private static String xmlSchema = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xsd/cpcSchema.xsd";

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		List<CPCData> cpcData = parseClassificationXML();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new FileReader(xmlSchema)));
			
		 doc = builder.newDocument();

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transf = transformerFactory.newTransformer();


		Element rootElement = doc.createElement("supp.data-block");
		doc.appendChild(rootElement);

		Element classificationElement = doc.createElement("classifications-cpc");
		rootElement.appendChild(classificationElement);
		
		Element mainCPCElement = doc.createElement("main-cpc");
		classificationElement.appendChild(mainCPCElement);
		
		Element furtherCPCElement = doc.createElement("further-cpc");
		classificationElement.appendChild(furtherCPCElement);

		for (CPCData cpcDataList : cpcData) {

			Element section = doc.createElement("section");
			section.appendChild(doc.createTextNode(String.valueOf(cpcDataList.getCpcSection())));
			mainCPCElement.appendChild(section);
			
			Element cpcClass = doc.createElement("class");
			cpcClass.appendChild(doc.createTextNode(String.valueOf(cpcDataList.getCpcClass())));
			mainCPCElement.appendChild(cpcClass);
			
			Element subclass = doc.createElement("subclass");
			subclass.appendChild(doc.createTextNode(String.valueOf(cpcDataList.getCpcSubclass())));
			mainCPCElement.appendChild(subclass);
			
			Element mainGroup = doc.createElement("main-group");
			mainGroup.appendChild(doc.createTextNode(String.valueOf(cpcDataList.getCpcMainGroup())));
			mainCPCElement.appendChild(mainGroup);
			
			Element subGroup = doc.createElement("subGroup");
			subGroup.appendChild(doc.createTextNode(String.valueOf(cpcDataList.getCpcSubGroup())));
			mainCPCElement.appendChild(subGroup);

		}

			
		transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transf.setOutputProperty(OutputKeys.INDENT, "yes");
		transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

		DOMSource source = new DOMSource(doc);

		File myFile = new File("src/main/resources/outputCPC.xml");

		StreamResult console = new StreamResult(System.out);
		StreamResult file = new StreamResult(myFile);

		transf.transform(source, console);
		transf.transform(source, file);
	}


	private static List<CPCData> parseClassificationXML()
			throws ParserConfigurationException, SAXException, IOException {
		// Initialize a list of employees
		List<CPCData> cpcData = new ArrayList<CPCData>();
		CPCData cpcMainData = null;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File(xmlFilePath));
		document.getDocumentElement().normalize();
		// NodeList nList = document.getElementsByTagName("classification-cpc");
		NodeList nList = document.getElementsByTagName("classifications-cpc");
		visitChildNodes(nList);
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				// Create new Employee Object
				cpcMainData = new CPCData();
				// cpcMainData.setApplicationNumber(eElement.getElementsByTagName("application-number").item(0).getTextContent());
				cpcMainData.setCpcSection(eElement.getElementsByTagName("section").item(0).getTextContent());
				cpcMainData.setCpcClass(eElement.getElementsByTagName("class").item(0).getTextContent());
				cpcMainData.setCpcSubclass(eElement.getElementsByTagName("subclass").item(0).getTextContent());
				cpcMainData.setCpcMainGroup(eElement.getElementsByTagName("main-group").item(0).getTextContent());
				cpcMainData.setCpcSubGroup(eElement.getElementsByTagName("subgroup").item(0).getTextContent());

				// Add Employee to list
				cpcData.add(cpcMainData);

			}
		}
		return cpcData;
	}

	private static void visitChildNodes(NodeList nList) {
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				// System.out.println("Node Name = " + node.getNodeName() + "; Value = " +
				// node.getTextContent());
				// Check all attributes
				if (node.hasAttributes()) {
					// get attributes names and values
					NamedNodeMap nodeMap = node.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node tempNode = nodeMap.item(i);
						// System.out.println("Attr name : " + tempNode.getNodeName()+ "; Value = " +
						// tempNode.getNodeValue());
					}
					if (node.hasChildNodes()) {
						// We got more childs; Let's visit them as well
						visitChildNodes(node.getChildNodes());
					}
				}
			}

		}
	}

}
