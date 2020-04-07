package com.demo.simplexml.model;

import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class PropertyList {

	@ElementList(inline=true)
	private List<Entry> list;
	@Attribute
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public List getProperties() {
		return list;
	}
	
}
