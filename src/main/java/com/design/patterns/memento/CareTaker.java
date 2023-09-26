package com.design.patterns.memento;

import java.util.ArrayList;

public class CareTaker {
	
	ArrayList<Memento> mementoList = new ArrayList<>();
	
	public void saveState(Memento mem)
	{
		mementoList.add(mem);
	}

	public Memento restoreState(int index) {
		return mementoList.get(index);
	}
}
