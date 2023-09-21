package com.design.patterns.proxy;

public class RealImage implements Image{

	private String fileName;
	
	public RealImage(String fileName) {
		System.out.println("##### Real Image: loading file "+fileName);
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Real Image: displaying Image "+fileName);
	}
}
