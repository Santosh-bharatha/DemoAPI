package com.design.patterns.flyweight;

import com.design.patterns.observer.EventManager;

public class Editor {
	
	public EventManager events = new EventManager("open", "save");
	
	String file = "";
	
	public void openFile(String fileName) {
		this.file = fileName;
		events.notify("open", file);
	}

	public void saveFile() {
		if(file !=null) {
			events.notify("save", file);
		}
	}
}
