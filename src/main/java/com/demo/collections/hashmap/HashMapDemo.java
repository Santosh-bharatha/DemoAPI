package com.demo.collections.hashmap;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		
		HashMap<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("one", "First val");
		hashMap.put("two", "second val");
		hashMap.put("three", "third val");
		hashMap.put("four", "fourth val");
		
		System.out.println(hashMap);
		System.out.println(hashMap.get("two"));
		//hashMap.clear();
		System.out.println(hashMap.isEmpty());
		System.out.println(hashMap.size());
		
		hashMap.remove("four");
		System.out.println(hashMap.size());

	}

}
