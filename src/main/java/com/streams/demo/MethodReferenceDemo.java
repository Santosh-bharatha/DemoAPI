package com.streams.demo;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.LongStream;

public class MethodReferenceDemo {
	
	private static void print(String str) {
		System.out.println(str);
	}

	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring","Springboot","API","MicroServices","Kubernetis");
		
		List<String> courses2 = List.of("Spring","Springboot","API","MicroServices","Kubernetis");
		
		
		long time = System.currentTimeMillis();
		//courses.stream().map(str ->str.toUpperCase()).forEach(MethodReferenceDemo::print);
		
		Supplier<String> supplier = String::new;
		
		System.out.println("Supplier "+supplier.toString());
		
		System.out.println(LongStream.range(0, 10000000).parallel().sum());
		System.out.println(System.currentTimeMillis() -time);

	}

}
