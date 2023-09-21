package com.design.patterns.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class ShapeFactoryTest {
	
    ShapeFactory shapeFactory = new ShapeFactory();
	
	Shape roundFood = shapeFactory.getFood("Round");
	Shape cylindricalFood = shapeFactory.getFood("Cylinder");

	@Test
	void factoryMethodTest() {
		assertEquals("Round",roundFood.getShape());
		assertEquals("Cylinder",cylindricalFood.getShape());
	}

}
