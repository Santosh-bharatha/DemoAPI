package com.demo.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTestDemo {

	@Test
	public void test() {
		int actualLength = "abcd".length();
		
		int expectedLength = 4;
		
		assertEquals(expectedLength, actualLength);
	}
	
	@Test
	public void mathTest() {
		
		int a = 10;
		int b = a;
		
		assertEquals(a, b);
	}
	

	
}
