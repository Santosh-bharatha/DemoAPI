package com.demo.simplexml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class DivideTask implements Task {
	@Element(name="left")
	   private float left;

	   @Element(name="right")
	   private float right;
	@Override
	public double execute() {
		return left / right;
	}
}
