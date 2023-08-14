package com.streams.demo;

import java.util.ArrayList;
import java.util.List;

public class StructuredProg {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		List<Integer> itemList = new ArrayList<>();
		itemList.add(12);
		itemList.add(6);
		itemList.add(8);
		itemList.add(9);
		itemList.add(7);
		itemList.add(11);
		itemList.add(13);
		
		
		
		//printEvenNumbersInStructure(itemList);
		printAllNumbersInFunctional(itemList);
		System.out.println("\n even numbers");
		printEvenNumbersInFunctional(itemList);
		System.out.println("\n printing odd");
		printOddNumbersInFunctional(itemList);
		
		List<String> names= List.of("Santosh","Bharatha","Krishna","microservices","API","AWS");
		List<String> courses= List.of("Spring","Spring Boot","test1","microservices","API","AWS");
		
		System.out.println("\n Finding names");
		names.stream().filter(name -> name.contains("Bharatha")).forEach(System.out::println);
		
		
		courses.stream().filter(course -> course.length()>=4).
		  forEach(System.out::println);
		System.out.println("\n String length");
		courses.stream().map(course ->course +" "+course.length()).forEach(System.out::println);
		 
 
	}
	
	
	


	private static void printAllNumbersInStructure(List<Integer> numbers) {
		for(int num : numbers) {
			System.out.println(" number :"+num);
		}
	}
	
	private static void printEvenNumbersInStructure(List<Integer> numbers) {
		for(int num : numbers) {
			if(num%2==0) {
				System.out.println(" number :"+num);
			}
			
		}
	}
	private static void printAllNumbersInFunctional(List<Integer> numbers) {
		
		numbers.stream().map(number -> number * number * number).forEach(System.out::println);
	}
	
   private static void printEvenNumbersInFunctional(List<Integer> numbers) {
	
			numbers.stream().filter(number -> number%2==0).map(number ->number * number).
			forEach(System.out::println);	
		
	}
   
   private static void printOddNumbersInFunctional(List<Integer> numbers) {
		
		numbers.stream().filter(number -> number%2!=0).
		forEach(System.out::println);	
	
  }
   
   
   
   
   
	

}
