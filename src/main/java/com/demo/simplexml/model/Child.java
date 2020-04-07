package com.demo.simplexml.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Child {
	 private Parent parent;
	 private String name;

	   public Child() {
	      super();           
	   }

	   public Child(Parent parent) {
	      this.parent = parent;           
	   }

	   @Attribute
	   public String getName() {
	      return name;           
	   }

	   @Attribute
	   public void setName(String name) {
	      this.name = name;           
	   }

	   @Element
	   public Parent getParent() {
	      return parent;
	   }

	   @Element
	   public void setParent(Parent parent) {
	      this.parent = parent;
	   }
	 
}
