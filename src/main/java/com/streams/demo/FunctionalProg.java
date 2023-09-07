package com.streams.demo;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProg {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,1,9,8,7,13,5,6,11);
		
		List<Integer> doubledNumbers = doubleList(numbers);
		
		//System.out.println("Sum :"+addListFunctional(numbers));
		System.out.println("doubled Numbers : "+doubledNumbers);
		
		List<Integer> evenNumbersOnly = numbers.stream().filter(number ->number%2==0).collect(Collectors.toList());
		System.out.println("Even Numbers only "+evenNumbersOnly);
		
			}

	private static List<Integer> doubleList(List<Integer> numbers) {
		
		return numbers.stream().map(number ->number * number).collect(Collectors.toList());
	}

	private static int addListFunctional(List<Integer> numbers) {
		return numbers.stream().reduce(0, Integer::sum);
	}
	//numbers.stream().reduce(0, (x,y)->x+y);
	
}
