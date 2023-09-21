package com.design.patterns.factory;

public class ShapeFactoryDemo {

	public static void main(String[] args) {
		
		ShapeFactory shapeFactory = new ShapeFactory();
		Shape roundFood = shapeFactory.getFood("Round");
		Shape cylinderFood = shapeFactory.getFood("Cylinder");
		
		System.out.println("rounded ::"+roundFood.getShape());
		System.out.println("cylindrical ::"+cylinderFood.getShape());

	}

}
