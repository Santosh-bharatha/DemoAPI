package com.design.patterns.bridge;

public class IOS implements PhoneOS{

	@Override
	public void upload(String data) {
		System.out.println("Iphone uploading data: "+data);
	}

	@Override
	public void download(String url) {
     System.out.println("Iphone Downloading from :"+url);		
	}

	@Override
	public void display(String data) {

		System.out.println("Iphone Displaying Data :"+data);
	}

}
