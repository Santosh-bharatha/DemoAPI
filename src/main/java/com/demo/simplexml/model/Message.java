package com.demo.simplexml.model;

import java.util.Collection;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import com.demo.simplexml.model.Entry;

@Root
public class Message {

	 private Collection<Entry> list;
	 
	 @Attribute
	 private float version;
	 
	   @ElementList
	   public void setList(Collection<Entry> entry) {
	      if(entry.isEmpty()) {
	         throw new IllegalArgumentException("Empty collection");              
	      }
	      this.list = entry;           
	   }        

	   @ElementList
	   public Collection<Entry> getList() {
	      return list;           
	   }
}
