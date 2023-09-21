package com.design.patterns.abstractFactory;

public class DatabaseService implements Service{

	@Override
	public String runService() {
		return "Database Service Running";
	}

}
