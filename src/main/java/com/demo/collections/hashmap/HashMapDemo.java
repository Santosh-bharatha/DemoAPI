package com.demo.collections.hashmap;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("one", "First val");
		hashMap.put("two", "second val");
		hashMap.put("three", "third val");
		hashMap.put("four", "fourth val");

		// System.out.println(hashMap);
		// System.out.println(hashMap.get("two"));
		// hashMap.clear();
		// System.out.println(hashMap.isEmpty());
		// System.out.println(hashMap.size());

		// hashMap.remove("four");

		Set<Map.Entry<String, String>> entries = hashMap.entrySet();
		for (Map.Entry<String, String> ent : entries) {
			System.out.println(ent.getKey() + " ==> " + ent.getKey());
		}

		if (hashMap.containsKey("one")) {
			System.out.println("Contains Key");
		} else {
			System.out.println("Key is not present");
		}

		Set<String> keys = hashMap.keySet();
		for (String keySet : keys) {
			System.out.println(" key set : " + keySet);
		}

		HashMap<String, Integer> map = new HashMap<>();
		print(map);
		map.put("a", 100);
		map.put("b", 300);
		map.put("c", 300);
		map.put("d", 400);

		System.out.println("StringInt HashMap :" + map.toString());
		int k = map.replace("b", 200);

		System.out.println("Previous value of 'b': " + k);

		System.out.println("StringInt HashMap :" + map.toString());

		map.compute("Key1", (key, val) -> (val == null) ? 1 : val + 1);
		map.compute("Key2", (key, val) -> (val == null) ? 1 : val + 5);

		System.out.println("New Map : " + map);

		HashMap<String, String> mapString = new HashMap<>();

		mapString.put("Name", "Santosh");
		mapString.put("Address", "Aldie");

		mapString.compute("Name", (key, val) -> val.concat(" Bharatha"));
		mapString.compute("Address", (key, val) -> val.concat(" Virginia"));

		System.out.println(" mapString : " + mapString);

		HashMap<String, Integer> map1 = new HashMap<>();
		map1.put("Tushar", 2000);
		map1.put("Anushka", 2001);
		map1.put("Sanskriti", 2003);
		map1.put("Anuj", 2002);

		System.out.println(map1);
		map1.replaceAll((key, yearOfBirth) -> 2020 - yearOfBirth);
		// map1.replaceAll((key, oldValue) -> oldValue * oldValue);

		System.out.println(map1);

		HashMap<Integer, String> map3 = new HashMap<>();
		map3.put(1, "L");
		map3.put(2, "M");
		map3.put(3, "N");

		HashMap<Integer, String> map2 = new HashMap<>();
		map2.put(1, "B");
		map2.put(2, "G");
		map2.put(3, "R");

		map3.forEach((key, value) -> map2.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + ", " + v2));

		System.out.println("after merge :" + map2);
		
		BiConsumer<String, Integer> action = new MyBiConsumer();
		map.forEach(action);
		
		
		HashMap<String, String> Geeks = new HashMap<>();
		
		    Geeks.put("Language", "Java"); 
	        Geeks.put("Platform", "Geeks For geeks"); 
	        Geeks.put("Code", "HashMap"); 
	        Geeks.put("Learn", "More"); 
	        
	        if(Geeks.containsKey("Code"))
	        	System.out.println("Testing .containsKey : " + 
                        Geeks.get("Code"));
	        
	        //Set
	        Set<String> geeksKeys = Geeks.keySet();
	        System.out.println("initial keys :"+ geeksKeys);
	        
	        Collection<String> geeksValues = Geeks.values();
	        Geeks.put("Search", "javaArticle");
	        
	        System.out.println("New Keys : "+ geeksKeys);
	        System.out.println("New Values: " + geeksValues);
	        
	        //Set<Map.Entry<k,v>>
	        Set<Map.Entry<String, String>> mappingGeeks = Geeks.entrySet();
	        System.out.println("Set of Keys and Values using entrySet() : "+mappingGeeks); 
	        
	        //ConcurrentHashMap
	        ConcurrentHashMap<Integer, String> hash_map = new ConcurrentHashMap<Integer, String>();
	        

	        // Mapping string values to int keys 
	        hash_map.put(10, "Geeks"); 
	        hash_map.put(15, "4"); 
	        hash_map.put(20, "Geeks"); 
	        hash_map.put(25, "Welcomes"); 
	        hash_map.put(30, "You"); 
	  
	        // Displaying the HashMap 
	        System.out.println("Initial Mappings are: "
	                           + hash_map); 
	        
	        System.out.println("The set is: "
                    + hash_map.keySet()); 
	        
	        Enumeration enu = hash_map.keys();
	        System.out.println("The enumeration of keys are : ");
	        
	        while(enu.hasMoreElements()) {
	        	System.out.println("enumeration : "+enu.nextElement());
	        }
	  
	}

	private static void print(HashMap<String, Integer> map) {

		if (map.isEmpty()) {
			System.out.println("Map is empty");
		} else {
			System.out.println(map);
		}
	}

}

class MyBiConsumer implements BiConsumer<String, Integer> {

	@Override
	public void accept(String k, Integer v) {
		System.out.println("========================");
		System.out.println("Key = " + k);
		System.out.println("\t value = " + v);
		System.out.println("\n");
	}

}