package com.demo.simplexml.model;

import java.util.Map;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

@Root(name="properties")
public class PropertyMap {
	
	@ElementMap(entry="property", key="key", attribute=true, inline=true)
	private Map<String, String> map;
	
	@Element
	private String name;

	public Map<String, String> getMap() {
		return map;
	}

	public String getName() {
		return name;
	}
}
