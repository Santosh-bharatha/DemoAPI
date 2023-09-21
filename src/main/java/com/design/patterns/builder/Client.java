package com.design.patterns.builder;

public class Client {
	
	public static void main(String args[]) {
		ApartmentBuilder builder = new ApartmentBuilder();
		
		
		Apartment apt1 = builder.setSqm(250)
				                 .setRooms(5)
				                 .setArea("MasteryPl")
				                 .setCity("Aldie")
	                           .setkitchen(true).build();
		apt1.display();
	
		Apartment apt2 = builder.setSqm(50).build();
		apt2.display();
		
	}

}
