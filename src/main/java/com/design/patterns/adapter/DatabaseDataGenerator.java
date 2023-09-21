package com.design.patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDataGenerator {

	
	public List<DatabaseData> generateData(){
		List<DatabaseData> list = new ArrayList<>();
		list.add(new DatabaseData(2,20));
		list.add(new DatabaseData(4,80));
		list.add(new DatabaseData(3,60));
		list.add(new DatabaseData(5,90));
		return list;
	}

}
