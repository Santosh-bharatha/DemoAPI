package com.streams.demo;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces {

	public static void main(String[] args) {

		
		List<Integer> numbers = List.of(12,11,10,8,9,7,6,5,43,32,21);
		
		Predicate<Integer> predicate = x ->x%2==0;
		Function< Integer, Integer> Function = x ->x*x;
		Consumer<Integer> printStmt = System.out::println;
		numbers.stream().filter(predicate).map(Function).forEach(printStmt);
		
		String strItem = "Welcome";
		Predicate<String> stringPredicate = s -> strItem.isEmpty();
		
		System.out.println("stringPredicate :"+stringPredicate);
	}

}
