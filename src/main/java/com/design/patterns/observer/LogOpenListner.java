package com.design.patterns.observer;

public class LogOpenListner implements EventListner{

	@Override
	public void notify(String eventType, String file) {
		System.out.println("LogOpenListner :"+eventType+"   performed Type :"+file);
		
	}

}
