package com.demo.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class AddNodeToDOMDocument implements XMLDomWriter {

	private Document source;
	public Document getSource() {
		return source;
	}
	public AddNodeToDOMDocument(Document doc){
		this.source =doc;
	}
	
	public static void main(String[] args) throws Exception {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		docFactory.setValidating(false);
		DocumentBuilder db = docFactory.newDocumentBuilder();
		
		Document doc = db.parse(new FileInputStream(new File("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/data.xml")));
		
		Element element = doc.getDocumentElement();
		Node node = doc.createElement("newNode");
		element.appendChild(node);
		
		//add("newnode");
		
		 
		 Element element1 = (Element) doc.getElementsByTagName("time").item(0);
		 element1.getParentNode().removeChild(element1);
		 
		 doc.normalize();
		 
		 prettyPrint(doc);

	}
	
	public static final void prettyPrint(Document xml) throws Exception {
        Transformer tf = TransformerFactory.newInstance().newTransformer();
        tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        Writer out = new StringWriter();
        tf.transform(new DOMSource(xml), new StreamResult(out));
        System.out.println(out.toString());
    }

	@Override
	public void appenChild(Node itemObj, String childName, String attribute) {
		// TODO Auto-generated method stub
		
	}

	public void add(String itemObj) {
		AddNodeToDOMDocument addNode = null;
		Document doc = addNode.getSource();
		Node node =  doc.createComment(itemObj);
		Element element = doc.getDocumentElement();
		element.appendChild(node);
		
	}

	@Override
	public void remove(Node itemObj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Node itemObj, String childName, String attribute, boolean isNodeAttribute) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void add(Node itemObj) {
		// TODO Auto-generated method stub
		
	}
	
	private static Node addElement(Document doc, String name, String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}

}
