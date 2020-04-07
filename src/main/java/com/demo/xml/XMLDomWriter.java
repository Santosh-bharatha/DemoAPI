package com.demo.xml;

import org.w3c.dom.Node;

public interface XMLDomWriter {
	
	/**
	 * 
	 * @param itemObj
	 */
	public void appenChild(Node itemObj,String childName,String attribute);
	
	
	/**
	 * Add the Node ELement to the XML Document
	 */
	public void add(Node itemObj);
	
	/**
	 * Remove the ELement from the XML Document
	 * 
	 */
	public void remove(Node itemObj);

    /**
     * 
     * @param itemObj
     * @param attribute
     * @param isNodeAttribute
     */
	public void update(Node itemObj,String childName, String attribute, boolean isNodeAttribute);




}
