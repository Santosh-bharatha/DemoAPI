package com.design.patterns.observer;

import com.design.patterns.flyweight.Editor;

public class Client {

	public static void main(String[] args) {

		Editor editor = new Editor();
		EmailNotificationListner emailListner = new EmailNotificationListner();
		LogOpenListner logListner = new LogOpenListner();
		
		editor.events.subscribe("open", emailListner);
		editor.events.subscribe("save", emailListner);
		editor.events.subscribe("open", logListner);
		
		
		editor.openFile("test.png");
		editor.saveFile();
		
		System.out.println("Unsubscribe");
		
		editor.events.unSubscribe("save", emailListner);
		editor.openFile("test1.jpg");
		editor.saveFile();
	}

}
