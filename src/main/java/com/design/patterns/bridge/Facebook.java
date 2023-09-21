package com.design.patterns.bridge;

public class Facebook implements App{
	
	private PhoneOS os;
	
	public Facebook(PhoneOS os) {
		this.os = os;
	}

	@Override
	public void runApp() {
		os.upload("facebook data upload");
		os.download("facebook.com");
		os.display("facebook data");
	}

}
