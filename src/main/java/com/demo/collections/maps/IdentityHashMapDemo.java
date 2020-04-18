package com.demo.collections.maps;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class IdentityHashMapDemo  {

	public static void main(String[] args) {
		
		Map hm = new HashMap();
		Map idHm = new IdentityHashMap();
		
		hm.put("John", "1000");
		hm.put(new String("John") , 2000);
		
		idHm.put("John", "1011");
		idHm.put(new String("John") , 3000);
		
		//hashmap would call .equals() for comparing values where as IdentityHashMap uses "==".
		System.out.println("Size of the HashMap is : "+ hm.size());
		System.out.println(hm.get("John"));
		System.out.println(" Size of identityHashMap :"+ idHm.size());
		System.out.println("idHM : "+idHm.get("John"));

	}

}
