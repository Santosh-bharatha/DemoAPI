package com.demo.collections.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String, Integer> vehicles = new HashMap<>();
        
		vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("Ford", 10);
        
        System.out.println("Total vehicles :" + vehicles.size());
		
        for(String key : vehicles.keySet()) {
        	System.out.println(key + " - "+vehicles.get(key));
        	System.out.println();
        }
        
        String searchKey = "Ford" ;
        if(vehicles.containsKey(searchKey)) {
        	System.out.println("Found total " + vehicles.get(searchKey) + " " + searchKey + " cars!\n");
        }else {
        	System.out.println("No vehicles found");
        }
        
        
        System.out.println("Latest "+vehicles.size());
	}

}
