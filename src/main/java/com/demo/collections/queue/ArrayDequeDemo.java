package com.demo.collections.queue;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ArrayDequeDemo {
	
	public static void main(String args[]) {
		
		ArrayDeque<String> arrDeque = new ArrayDeque<>();
		
		arrDeque.add("paris");
		arrDeque.add("Denmark");
		arrDeque.add("Delhi");
		arrDeque.add("Bombay");
		
		System.out.println(arrDeque.size());
		System.out.println("Peek has returned : "+arrDeque.peek());
		System.out.println("Pop has returned : "+ arrDeque.pop());
		
		for(String element : arrDeque) {
			System.out.println(element);
		}
		
		ArrayDeque<Integer> intDeque = new ArrayDeque<>();
		
		intDeque.push(10);
		intDeque.push(100);
		intDeque.push(50);
		intDeque.push(30);
		
		System.out.println(intDeque);
		Iterator<Integer> itr = intDeque.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
		System.out.println("int peek :"+intDeque.peek());
		System.out.println("int pop :"+ intDeque.pop());
		System.out.println("intDeque :"+intDeque);
		
		
		
		String value1 = "India";
		String value2 = "India";
		String value3 = value2;
		
		if( value1 == value3) {
			System.out.println("Val1 & Val2 are same");
			System.out.println(value1.hashCode());
			System.out.println(value2.hashCode());
			System.out.println(value3.hashCode());
		}else {
			System.out.println("Val1 & Val2 not same");
			System.out.println(value1.hashCode());
			System.out.println(value2.hashCode());
			System.out.println(value3.hashCode());
		}
		
		if(value1.equals(value3)) {
			System.out.println("equals() - Val1 & Val2 are same");
			System.out.println(value1.hashCode());
			System.out.println(value2.hashCode());
			System.out.println(value3.hashCode());
		}else {
			System.out.println("equals() - Val1 & Val2 not same");
			System.out.println(value1.hashCode());
			System.out.println(value2.hashCode());
			System.out.println(value3.hashCode());
		}
		}
		
		
		
		
	
}
