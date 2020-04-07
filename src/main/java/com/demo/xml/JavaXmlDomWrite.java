package com.demo.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;


public class JavaXmlDomWrite {
	
	public static  String machineCPCCode = null;
	public static String MAINCPC = "main-cpc";
	public static void main(String[] args) throws ParserConfigurationException, TransformerException, SAXException, IOException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
       
        
        Element root = doc.createElementNS("zetcode.com", "users");
        doc.appendChild(root);

        root.appendChild(createUser(doc, "1", "Robert", "Brown", "programmer"));
        root.appendChild(createUser(doc, "2", "Pamela", "Kyle", "writer"));
        root.appendChild(createUser(doc, "3", "Peter", "Smith", "teacher"));
        
        root.appendChild(addNode(doc, "dept", "10"));
        root.appendChild(addNode(doc, "branch", "11"));
        
        Element node1 = (Element) doc.getElementsByTagName("user").item(0);
        String childValue = extractTextChildren(node1);
        for(int i=0; i< childValue.length(); i++) {
        	System.out.println("###############"+childValue.toString());
        }
     
        
        //
        DOMParser parser = new DOMParser();
        parser.parse("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml");
        Document document = parser.getDocument();
        document.getDocumentElement().normalize();
        String machinecpc = getMachineCPCCode(document );
      //  System.out.println(machinecpc);
        //

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        
        DOMSource source = new DOMSource(doc);

        File myFile = new File("src/main/resources/users.xml");
        
        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);

        transf.transform(source, console);
        transf.transform(source, file);
	}
	
	public static String getMachineCPCCode(Document document) {
	        Element rootElement = document.getDocumentElement();
	        NodeList nList = document.getElementsByTagName("main-cpc");
	        for (int temp = 0; temp < nList.getLength(); temp++) {
	        	Node node = nList.item(temp);
	        	 if (node.getNodeType() == Node.ELEMENT_NODE)
	        	 {
	        		 Element eElement = (Element) node;
	        		 String section = eElement.getElementsByTagName("section").item(0).getTextContent();
	        		 String cpcClass = eElement.getElementsByTagName("class").item(0).getTextContent();
	        		 String subclass = eElement.getElementsByTagName("subclass").item(0).getTextContent();
	        		 String mainGroup = eElement.getElementsByTagName("main-group").item(0).getTextContent();
	        		 String subgroup = eElement.getElementsByTagName("subgroup").item(0).getTextContent();
	        		 machineCPCCode = section+cpcClass+subclass+mainGroup+"/"+subgroup;
	        	 }
	        }
		return machineCPCCode;
	}
	
	 public static String extractTextChildren(Element parentNode) {
		    NodeList childNodes = parentNode.getChildNodes();
		    String result = new String();
		    for (int i = 0; i < childNodes.getLength(); i++) {
		      Node node = childNodes.item(i);
		      if (node.getNodeType() == Node.TEXT_NODE) {
		        result += node.getNodeValue();
		      }
		    }
		    return result;
		  }

	
	public static void addNode(String tagName, String value, Node parent) {
	    Document dom = parent.getOwnerDocument();
	     
	    // Create a new Node with the given tag name
	    Node node = dom.createElement(tagName);
	     
	    // Add the node value as a child text node
	    Text nodeVal = dom.createTextNode(value);
	    Node c = node.appendChild(nodeVal);
	     
	    // Add the new node structure to the parent node
	    parent.appendChild(node);
	}

	private static Node createUser(Document doc, String id, String firstName, String lastName, String occupation) {

		Element user = doc.createElement("user");

		user.setAttribute("id", id);
		user.appendChild(addNode(doc, "firstname", firstName));
		user.appendChild(addNode(doc, "lastname", lastName));
		user.appendChild(addNode(doc, "occupation", occupation));

		return user;
	}

	private static Node addNode(Document doc, String name, String value) {

		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));

		return node;
	}
	
	
	private static void removeNode(Document doc, String name) {
		
		Element node = (Element) doc.getElementsByTagName(name).item(0);
		node.getParentNode().removeChild(node);
	
		
	}
}