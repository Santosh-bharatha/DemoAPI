package com.design.patterns.builder;

public class Apartment {
	
	private int sqm;
	private int rooms;
	private String city;
	private String area;
	private boolean kitchen;
	
	public Apartment(int sqm, int rooms, String city, String area, boolean kitchen) {
		super();
		this.sqm = sqm;
		this.rooms = rooms;
		this.city = city;
		this.area = area;
		this.kitchen = kitchen;
	}
	
	public int getSqm() {
		return sqm;
	}
	
	public void display() {
		System.out.println("\n");
		System.out.println("Apartment has :");
		if(sqm != -1) {
			System.out.println(sqm + " sq.meters");
		}
		if(rooms != 1) {
			System.out.println(rooms + " sq.meters");
		}
		if(area !="") {
			System.out.println("Apartment is in : "+area );
		}
		if(city !="") {
			System.out.println("Apartment is in City : "+city);
		}
		if(kitchen !=Boolean.FALSE) {
			System.out.println("!apartment has kitchen");
		}
	}

}
