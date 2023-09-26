package com.design.patterns.observer;

public class EmailNotificationListner implements EventListner {

	@Override
	public void notify(String eventType, String file) {
           System.out.println("EmailNotificationListner : "+eventType+" performed on file"+file); 
         
	}

}
