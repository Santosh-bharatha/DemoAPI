package com.demo.simplexml.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Entry {

	@Attribute
	protected String key;
	
	@Element
	protected String value;
	
	public String getKey() {
		return key;
	}
	
	public String getValue() {
		return value;
	}
}
