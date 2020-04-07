package com.demo.simplexml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Address {

	   @Element(required=false)
	   private String house;        

	   @Element
	   private String street;  

	   @Element
	   private String city;

	   public String getHouse() {
	      return house;           
	   }

	   public String getStreet() {
	      return street;           
	   }

	   public String getCity() {
	      return city;           
	   } 
}
