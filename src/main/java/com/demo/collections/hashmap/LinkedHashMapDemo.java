package com.demo.collections.hashmap;

import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

	public static void main(String[] args) {
		// Hashmap doesnot maintain the insertion order, where as LinkedHashMap gives additional feature that we can access the elements in their insertion order.

		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
		linkedHashMap.put("one", "apple.com");
		linkedHashMap.put("two", "microsoft");
		linkedHashMap.put("three", "google");
		linkedHashMap.put("four", "facebook");
		
		System.out.println(linkedHashMap);
		System.out.println(linkedHashMap.get("four"));
		System.out.println(linkedHashMap.containsValue("google"));
	}

}
