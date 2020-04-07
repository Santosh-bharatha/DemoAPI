package com.demo.simplexml;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Default;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;

import com.demo.simplexml.model.AddressDetails;

import org.simpleframework.xml.ElementUnion;

public class SimpleXmlSerialize {

	public static String xmlInput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/example/example.xml";
	public static String xmlInput1 = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/example/example11.xml";
	public static String xmloutput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xmlExample.xml";
	public static String xmloutput2 = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xmlExample2.xml";
	
	public static void main(String[] args) throws Exception {

		 Style style = new HyphenStyle();
			Format format = new Format(style);
		Persister persister = new Persister(format);
		 
		 File input = new File(xmlInput);
		 File output = new File(xmloutput);
		 File output2 = new File(xmloutput2);
		 Example1 example = persister.read(Example1.class, input);
		 
		 File input1 = new File(xmlInput1);
		 Example2 example2 = persister.read(Example2.class, input1);
		 
		/* File source = new File(xmlInput);
		 File output = new File(xmloutput);
		 Example example = persister.read(Example.class, source);	 
		 
		 System.out.println(example.a);
		 System.out.println(example.b);
		 System.out.println(example.c);
		 System.out.println(example.d);*/
		 
		
			Serializer serialize = new Persister(format);
		 
		 AddressDetails addressDetails = new AddressDetails();
		 addressDetails.HouseNo = 25279;
		 addressDetails.StreetName = "Mastery Pl";
		 addressDetails.City = "Aldie";
		 addressDetails.PoAddress = "20105";
				 
        persister.write(addressDetails, output2);		 
		 persister.write(example, output);
		 persister.write(example2, input1);
		 
		
	}
	
	   
	 /* snippet */
	   @Default
	   public static class Example {
	      
	      private List<Double> a;
	      private String b;
	      private String c;
	      private Date d;
	      
	   }
	   
	   @Root
	   public static class Example1 {
	     
	      @ElementListUnion({
	         @ElementList(entry="int", type=Integer.class, inline=true),
	         @ElementList(entry="date", type=Date.class, inline=true),
	         @ElementList(entry="text", type=String.class, inline=true)
	      })
	      private List<Object> list;      
	   }
	   
	   @Root
	   public static class Example2 {
	     
	      @ElementUnion({
	         @Element(name="int", type=Integer.class),
	         @Element(name="date", type=Date.class),
	         @Element(name="text", type=String.class)
	      })
	      private Object value;  
	      
	      public Example2(@Element(name="int") int value) {
	         this.value = value;
	      }
	      
	      public Example2(@Element(name="int") Date value) {
	         this.value = value;
	      }
	      
	      public Example2(@Element(name="int") String value) {
	         this.value = value;
	      }
	   }
}
