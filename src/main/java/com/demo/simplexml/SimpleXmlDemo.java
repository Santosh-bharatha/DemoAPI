package com.demo.simplexml;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.MapFilter;
import org.simpleframework.xml.strategy.CycleStrategy;
import org.simpleframework.xml.strategy.Strategy;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.HyphenStyle;
import org.simpleframework.xml.stream.Style;

import com.demo.simplexml.model.*;

public class SimpleXmlDemo {

	public static String xmloutput = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/xmloutput.xml";
	public static String xmlFilePath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/AddressBook.xml";
	public static String nameList = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/namelist.xml";
	public static String layoutPath = "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/layout.xml";
	public static String parentPath= "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/parent.xml";
	public static String dateFilePath= "C:/Users/sbharatha/Documents/WorkStation_Spring/DemoAPI/src/main/resources/datefile.xml";
	
	public static void main(String[] args) throws Exception {

		Serializer serializer = new Persister();
		File result = new File(xmloutput);
		File source = new File(xmlFilePath);
		File contactFile = new File(nameList);
		File parentFile = new File(parentPath);
		
		Contact contact = serializer.read(Contact.class, contactFile, false);
		System.out.println(contact.getName());
		System.out.println(contact.getSurname());
		System.out.println(contact.getMobilePhone());
		System.out.println(contact.getHomePhone());
		
		PropertyList propertyList = serializer.read(PropertyList.class, result);
		
		System.out.println(propertyList.getName());
		System.out.println(propertyList.getProperties());
		
		AddressBook addressBook = serializer.read(AddressBook.class, source);
		Address[] address = addressBook.getAddresses();
		for(Address add : address) {
			System.out.println(add.getHouse());
			System.out.println(add.getStreet());
			System.out.println(add.getCity());
		}
		
		/*
		 * 
		 * NameList nameList = serializer.read(NameList.class, namelist);
		String[] names = nameList.getNames();
		for(String name: names) {
			System.out.println(name.toString());
		}
		 * String[] names = addressBook.getNames();
		for(String name : names) {
			System.out.println(name.toString());
		}*/
		int[] ages = addressBook.getAges();
		for(int age : ages) {
			System.out.println(age);
		}
		
		Map map = new HashMap();
		
		map.put("home.path", "/home/john.doe");
		map.put("user.name", "john.doe");
		
		Filter filter = new MapFilter(map);
		Serializer serial = new Persister(filter);
		File layoutSource = new File(layoutPath);
		Layout layout = serial.read(Layout.class, layoutSource);
		
		System.out.println(layout.getPath());
		System.out.println(layout.getUser());
		System.out.println("########################################################");
		
		File personalFile = new File(dateFilePath);
		PersonProfile profile = new PersonProfile( );
		Style style = new HyphenStyle();
		Format format = new Format(style);
		Serializer serialize = new Persister(format);
		serialize.write(profile, personalFile);
		System.out.println("########################################################");
		
	}
	

}
