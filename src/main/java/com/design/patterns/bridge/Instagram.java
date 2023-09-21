package com.design.patterns.bridge;

public class Instagram implements App {

	private PhoneOS os;

	public Instagram(PhoneOS os) {
		this.os = os;
	}

	@Override
	public void runApp() {
		System.out.println("\n");
		os.display("Instagram data");
		os.upload("Instagram.com");
		os.download("Instagram information");

	}

}
