package com.demo.simplexml.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Layout {

	  @Element
	   private String path;

	   @Element
	   private String user;

	   @Attribute
	   private int id;

	   public String getPath() {
	      return path;
	   }

	   public String getUser() {
	      return user;
	   }

	   public int getId() {
	      return id;
	   }
}
