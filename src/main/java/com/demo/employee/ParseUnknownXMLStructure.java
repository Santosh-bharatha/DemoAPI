package com.demo.employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.NamedNodeMap;

public class ParseUnknownXMLStructure {
	
	public static String inputXML = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/employees.xml";

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		List<Employee> employees = parseEmployeesXML();
        System.out.println(employees);

		
	}
		// TODO Auto-generated method stub
	 private static List<Employee> parseEmployeesXML() throws ParserConfigurationException, SAXException, IOException
	   {
	      //Initialize a list of employees
	      List<Employee> employees = new ArrayList<Employee>();
	      Employee employee = null;
	       
	      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	      DocumentBuilder builder = factory.newDocumentBuilder();
	      Document document = builder.parse(new File(inputXML));
	      document.getDocumentElement().normalize();
	      NodeList nList = document.getElementsByTagName("employee");
	      
	      visitChildNodes(nList);
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	            Element eElement = (Element) node;
	            //Create new Employee Object
	            employee = new Employee();
	            employee.setId(Integer.parseInt(eElement.getAttribute("id")));
	            employee.setFirstName(eElement.getElementsByTagName("firstName").item(0).getTextContent());
	            employee.setLastName(eElement.getElementsByTagName("lastName").item(0).getTextContent());
	            employee.setLocation(eElement.getElementsByTagName("location").item(0).getTextContent());
	             
	            //Add Employee to list
	            employees.add(employee);
	            
	         }
	      }
	      return employees;
	   }

	 private static void visitChildNodes(NodeList nList)
	   {
	      for (int temp = 0; temp < nList.getLength(); temp++)
	      {
	         Node node = nList.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE)
	         {
	          //  System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
	            //Check all attributes
	            if (node.hasAttributes()) {
	               // get attributes names and values
	               NamedNodeMap nodeMap = node.getAttributes();
	               for (int i = 0; i < nodeMap.getLength(); i++)
	               {
	                   Node tempNode = nodeMap.item(i);
	                 //  System.out.println("Attr name : " + tempNode.getNodeName()+ "; Value = " + tempNode.getNodeValue());
	               }
	               if (node.hasChildNodes()) {
	                  //We got more childs; Let's visit them as well
	                  visitChildNodes(node.getChildNodes());
	               }
	           }
	         }
	     
	      }
	   }
}