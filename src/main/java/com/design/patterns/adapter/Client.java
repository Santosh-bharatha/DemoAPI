package com.design.patterns.adapter;

import java.util.List;

public class Client {

	public static void main(String[] args) {

		DatabaseDataGenerator dataGen = new DatabaseDataGenerator();
		DatabaseDisplayAdapter adapter = new DatabaseDisplayAdapter();
		
		List<DisplayData3rdParty> legacyData = adapter.convertData(dataGen.generateData());
		
		for(DisplayData3rdParty datum : legacyData) {
			datum.displayData();
		}
		
	}

}
