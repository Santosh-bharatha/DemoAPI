package com.demo.simplexml.model;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;
import com.demo.simplexml.model.Address;

@Root
public class AddressBook {

	   @ElementArray
	   private Address[] addresses;   

	   @ElementArray
	   private String[] names;        

	   @ElementArray
	   private int[] ages;   

	   public Address[] getAddresses() {
	      return addresses;           
	   }

	   public String[] getNames() {
	      return names;           
	   }

	   public int[] getAges() {
	      return ages;           
	   }
}
