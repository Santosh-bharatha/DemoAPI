package com.design.patterns.singleton;

public class SingletonThreadSafe {
	
	

	private static SingletonThreadSafe threadSafeInstance;
	
	 SingletonThreadSafe() {
	}
 
	public static SingletonThreadSafe getInstance() {
		synchronized(SingletonThreadSafe.class) {
			if(threadSafeInstance==null) {
				threadSafeInstance = new SingletonThreadSafe();
			}
		}
		return threadSafeInstance;
	}

}
