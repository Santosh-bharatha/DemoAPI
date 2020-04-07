package com.demo.simplexml.model;

import java.util.Date;
import java.util.List;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class DateList {

	@Attribute
	private Date created;
	
	 @ElementList
	private List<Date> list;
	
	public Date getCreationDate() {
		return created;
	}
	
	public List<Date> getDates(){
		return list;
	}
}
