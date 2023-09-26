package com.design.patterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventManager {
	
	Map<String, ArrayList<EventListner>> listners = new HashMap<>();
	
	public EventManager(String ...operations) {
		for(String op : operations) {
			listners.put(op, new ArrayList<>());
		}
	}
	
	public void subscribe(String event, EventListner listner) {
		ArrayList<EventListner> users = listners.get(event);
		if(!users.contains(listner)) {
			users.add(listner);
		}
	}

	public void unSubscribe(String event, EventListner listner) {
		ArrayList<EventListner> users = listners.get(event);
		if(users.contains(listner)) {
			users.remove(listner);
		}
	}
	
	public void notify(String event, String file) {
		ArrayList<EventListner> users = listners.get(event);
		for(EventListner user: users) {
			user.notify(event, file);
		}
	}
}
