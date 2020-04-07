package com.demo.simplexml.model;

import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.Root;

@Root
public class NameList {

	@ElementArray(entry="name")
	private String[] names;

	public String[] getNames() {
		return names;
	}
	
	
}
