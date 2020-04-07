package com.demo.simplexml.model;

import org.simpleframework.xml.*;

@Root
public class MultiplyTask implements Task {

	 @Element(name="first")
	   private int first;

	   @Element(name="second")
	   private int second;

	   public double execute() {
	      return first * second;
	   }

}
