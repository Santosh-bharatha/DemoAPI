package com.design.patterns.singleton;

public class SingletonEager {
	
	private static SingletonEager  eagerInstance = SingletonEager();


	private SingletonEager() {
		
	}

	private static SingletonEager SingletonEager() {
		return eagerInstance;
	}

	public static SingletonEager getEagerInstance() {
		return eagerInstance;
	}
}
