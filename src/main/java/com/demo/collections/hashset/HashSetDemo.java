package com.demo.collections.hashset;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {

	public static void main(String[] args) {

		HashSet<String> h = new HashSet<String>();
		
		 // Adding elements into HashSet usind add() 
        h.add("India"); 
        h.add("Australia"); 
        h.add("South Africa"); 
        h.add("India");// adding duplicate elements 
        
        System.out.println(h);
        System.out.println(h.contains("India"));
        
        h.remove("Australia");
        System.out.println(h);
        
        System.out.println("Iterating list");
        Iterator<String> i = h.iterator();
        while(i.hasNext()) {
        	System.out.println(i.next());
        }
	}

}
