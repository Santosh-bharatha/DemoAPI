package com.streams.demo;

public class AutoBoxing {

	public static void main(String[] args) {

		int a =50;
		Integer a2 = new Integer(a);//Boxing
		
		Integer a3 = 5;//Boxing
		Integer a4 = 5;//Boxing
		
		System.out.println("sum :"+a4 + a3);
		
		Integer i = new Integer(50);
		
		int a1 = i;
		int a5 = 10;
		
		System.out.println(" unboxing"+a1+a5);
	}

}
