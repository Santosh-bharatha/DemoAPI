package com.streams.demo;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.github.javafaker.Number;

public class BehaviourParamDemo {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(19,20,12,32,15,16,18,17);
		
	//	numbers.stream().filter(evenPredicate()).forEach(System.out::println);
		
		filterAndPrint(numbers,  x -> x%2!=0);
		System.out.println("\n Even");
		filterAndPrint(numbers,  x -> x%2 ==0);
		System.out.println("\n Divisable by 3");
		filterAndPrint(numbers,  x -> x%3 ==0);
		
		
		List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x-> x*x);
		extracted(squaredNumbers);
		
		List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x-> x*x*x);
		extracted(cubedNumbers);
		
		Supplier<Integer> randomIntegerSupplier = () ->{
			
			Random random = new Random();
			return random.nextInt();
		};
		
		System.out.println("\n Supplier Random Number : "+randomIntegerSupplier.get());
		
		BiPredicate<Integer, String> biPredicate = (number, str) ->{
			return number<10 && str.length()>5;
		};
		
		Predicate<Integer> typePredicate = (Integer x)-> x%2 ==0;
		System.out.println("TypePredicate"+typePredicate.test(20));

		
		System.out.println(biPredicate.test(9, "in28Minutes"));
		
		BiFunction<Integer, String, String> biFunction = (number, str) ->{
			return number + " "+str;
		};
		
		System.out.println("Bifunction "+biFunction.apply(10, "in28Minutes"));
		
		BiConsumer<Integer, String> biConsumer = (s1,s2) ->{
			System.out.println(s1);
			System.out.println(s2);
		};
		biConsumer.accept(25, "Chandrayaan3");
		
		
		BinaryOperator<Integer> sumofBinaryOperator = (x,y)-> x+y;
		System.out.println("Binary "+ sumofBinaryOperator.apply(25, 35));
		
		IntBinaryOperator intBinaryOperator =(x,y)->x+y;
		System.out.println("IntBinary "+ intBinaryOperator.applyAsInt(45, 35));
		
	}
	
	
	
	


	private static void extracted(List<Integer> numbers) {
		System.out.println("\n "+numbers);
	}

	private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
			Function<Integer, Integer> MappingFunction) {
		return numbers.stream().map( MappingFunction).collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream().filter(predicate).forEach(System.out::println);
	}

	private static Predicate<? super Integer> evenPredicate() {
		return x -> x%2==0;
	}

}
