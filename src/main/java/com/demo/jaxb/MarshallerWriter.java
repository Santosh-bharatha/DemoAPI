package com.demo.jaxb;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class MarshallerWriter {

	public static String xmloutput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xmloutput.xml";
	public static String xmlFilePath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/employeeData.xml";
	
	public static void main(String[] args) {

		File file = new File(xmloutput);
		
		Employees employees = new Employees();
		employees.setEmployees(new ArrayList<Employee>());
		Employee emp1 = new Employee(new BigDecimal(1), "Nagen Kumar Sahu", new BigDecimal(30000), "Angul" );
		emp1.setId("DD");
		emp1.setDept("IT");
		Employee emp2 = new Employee(new BigDecimal(2), "Santosh", new BigDecimal(30000), "kumar" );
		emp2.setId("DCD");
		emp2.setDept("ITE");
		//Adding Employees in list
		employees.getEmployees().add(emp1);
		employees.getEmployees().add(emp2);
		
		try {
			JAXBContext context = JAXBContext.newInstance(Employees.class);
			Marshaller jaxbMarshaller = context.createMarshaller();
			
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(employees, file);
			jaxbMarshaller.marshal(employees, System.out);
			marshaller(file, employees);
			
			JAXBContext jc = JAXBContext.newInstance(SuppTitle.class);
			 
			//SuppTitle phoneNumber = new SuppTitle();
	      //  phoneNumber.setText("SUPPLEMENTAL PUBLICATION DATA");
	        
	        
	 
	       /* Marshaller marshaller = jc.createMarshaller();
	        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	        marshaller.marshal(phoneNumber, System.out);*/
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void marshaller(File file, Employees emp) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Employees.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,  true);
		marshaller.marshal(emp, System.out);
	}
}
