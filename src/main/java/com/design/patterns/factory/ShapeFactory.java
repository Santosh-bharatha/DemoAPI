package com.design.patterns.factory;

public class ShapeFactory {
	
	public Shape getFood(String type) {
		if(type == null) {
			return null;
		}
		switch (type) {
		case "Round": return new PizzaClass();
		case "Cylinder": return new BurritoClass();
		default: throw new IllegalArgumentException("Unknown Shape");
		
		}
	
	}

}
