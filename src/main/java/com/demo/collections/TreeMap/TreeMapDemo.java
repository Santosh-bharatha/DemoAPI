package com.demo.collections.TreeMap;

import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {

		TreeMap<String, Integer> person  = new TreeMap<String, Integer>();
		
		
		person.put("John", 30);
		person.put("Mike", 18);
		person.put("Angelina", 21);
		person.put("Brad", 32);
		person.put("Tom", 53);
		person.put("Clive", 72);
		person.put("Eiffel", 10);
		person.put("Alon", 60);
		person.put(" ", 60);
		
		
		for(String key : person.keySet()) {
			System.out.println(key + " :: " +person.get(key));
		}
		
		TreeMap<String, String> treeMap = new TreeMap<String, String>(new MyComparator());
		
		treeMap.put("Java", "language");
		treeMap.put("Computer", "Machine");
		treeMap.put("India", "Country");
		treeMap.put("Coffee", "Beverage");
		treeMap.put("Mango", "Fruit");
		
		//treeMap.clear();
		System.out.println( " is empty :"+ treeMap.isEmpty());
		
		if(treeMap.containsKey("language")) {
			System.out.println("The TreeMap contains value language");
		}else {
			System.out.println("The treeMap does not contains value language");
		}
		if(treeMap.containsKey("machine")) {
			System.out.println("The treemap contains value machine");
		}else {
			System.out.println("The TreeMap does not contains value machine");
		}
		
		
		
	}

}
