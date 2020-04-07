package com.demo.simplexml.model;

import java.util.Collection;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root
public class Parent {
	
	private Collection<Child> children;
	
	private String name;
	
	   @Attribute
	   public String getName() {
	      return name;                   
	   }

	   @Attribute
	   public void setName(String name) {
	      this.name = name;           
	   }

	   @Element
	   public void setChildren(Collection<Child> children) {
	      this.children = children;           
	   }
	    
	   @Element   
	   public Collection<Child> getChildren() {
	      return children;           
	   }        

	   public void addChild(Child child) {
	      children.add(child);           
	   }

}
