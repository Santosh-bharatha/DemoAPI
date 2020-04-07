package com.demo.simplexml.model;

import java.util.Date;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class PersonProfile {

	   @Attribute
	   private String firstName;

	   @Attribute
	   private String lastName;

	   @Element
	   private PersonAddress personAddress;

	   @Element
	   private Date personDOB;

	   public Date getDateOfBirth() {
	      return personDOB;
	   }

	   public String getFirstName() {
	      return firstName;
	   }

	   public String getLastName() {
	      return lastName;
	   }

	   public PersonAddress getAddress() {
	      return personAddress;
	   }
}
