package com.demo.simplexml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class PersonAddress {

	   @Element
	   private String houseNumber;

	   @Element
	   private String streetName;

	   @Element
	   private String city;

	   public String getHouseNumber() {
	      return houseNumber;
	   }

	   public String getStreetName() {
	      return streetName;
	   }

	   public String getCity() {
	      return city;
	   }
}
