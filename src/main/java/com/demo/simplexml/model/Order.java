package com.demo.simplexml.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Order {

	    @Attribute(name="name")
	    protected final String name;

	    @Element(name="product")
	    protected final String product;

	    public Order(@Attribute(name="name") String name, 
	                 @Element(name="product") String product) 
	    {
	        this.product = product;
	        this.name = name;
	    }

	    public String getProduct() {
	        return product;
	    }
}
