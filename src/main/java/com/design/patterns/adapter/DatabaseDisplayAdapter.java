package com.design.patterns.adapter;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDisplayAdapter implements DatabaseDataConverter{

	@Override
	public List<DisplayData3rdParty> convertData(List<DatabaseData> data) {
		List<DisplayData3rdParty> returnList = new ArrayList<>();
		
		for(DatabaseData datum : data) {
			float index = datum.position;
			String position = Integer.toString(datum.amount);
			DisplayData3rdParty dd = new DisplayData3rdParty(index, position);
			returnList.add(dd);
		}
		return returnList;
	}

}
