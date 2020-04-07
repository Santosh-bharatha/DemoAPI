package com.demo.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="supp.title")
public class SuppTitle {
	
    private String text;

    @XmlAttribute
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
 
    
   
 
}
