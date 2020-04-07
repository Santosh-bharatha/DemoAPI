package com.demo.simplexml.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class MathExample implements Task {

	   @Element
	   private Task task;

	   public double execute() {
	      return task.execute();
	   }  

}
