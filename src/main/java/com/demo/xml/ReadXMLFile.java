package com.demo.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

	
	public static void main(String[] args) throws IOException {
		File fXmlFile = new File("C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/classification.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc;
			doc = dBuilder.parse(fXmlFile);
			
			
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("supp.data-block");
			System.out.println("----------------------------");
			
			for(int temp=0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				System.out.println("\nCurrent NodeValue :" + nNode.getNodeValue());
				
				if(nNode.getNodeType()==Node.ELEMENT_NODE) {
					
					Element eElement = (Element) nNode;
					
					System.out.println(" application-number : " + eElement.getAttribute("application-number"));
					System.out.println("representative-figure : " + eElement.getElementsByTagName("representative-figure").item(0).getTextContent());
					System.out.println("section : " + eElement.getElementsByTagName("section"));
					System.out.println("class : " + eElement.getElementsByTagName("class"));
					System.out.println(" subclass: " + eElement.getElementsByTagName("subclass"));
					System.out.println("main-group: " + eElement.getElementsByTagName("main-group"));
					System.out.println("subgroup : " + eElement.getElementsByTagName("subgroup"));
				}
				
				
				
			}
		} catch ( ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public static String convertXMLToString(String filePath) throws IOException {

        //filename is filepath string
        BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
        String line;
        StringBuilder sb = new StringBuilder();

        while((line=br.readLine())!= null){
            sb.append(line.trim());
            System.out.println(sb.toString());
        }

        return  line;
    }

}
