package com.design.patterns.facade;

public class NetworkAccessFacade {
	
	
	private Communication comm = new Communication();
	private Cache cache = new Cache();
	private Interceptor intercept = new Interceptor();
	private Convertor convert = new Convertor();
	
	
	public void communicate() {
		cache.cache();
		comm.send("Sample Data");
		intercept.intercept();
		convert.convert();
	}

}
