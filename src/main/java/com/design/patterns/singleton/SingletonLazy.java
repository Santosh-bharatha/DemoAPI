package com.design.patterns.singleton;

public class SingletonLazy {
	

	private static SingletonLazy lazyInstance;
	
	SingletonLazy() {
	}

	public static SingletonLazy getInstance() {
		if(lazyInstance==null) {
			lazyInstance = new SingletonLazy();
		}
		 return lazyInstance;
	}
}

