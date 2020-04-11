package com.demo.collections.hashset;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetDemo {

	public static void main(String[] args) {

		HashSet<String> h = new HashSet<String>();
		
		 // Adding elements into HashSet usind add() 
        h.add("India"); 
        h.add("Australia"); 
        h.add("South Africa"); 
        h.add("HongKong");// adding duplicate elements 
        
        System.out.println(h);
        System.out.println(h.contains("India"));
        
       
        
        System.out.println("Iterating list");
        Iterator<String> i = h.iterator();
        while(i.hasNext()) {
        	System.out.println(i.next());
        }
        
        LinkedHashSet<String> linkH = new LinkedHashSet<String>();
        linkH.add("america");
        linkH.add("africa");
        linkH.add("bombay");
        linkH.add("delhi");
        
        Iterator<String> li = linkH.iterator();
        while(li.hasNext()) {
        	System.out.println(" LinkedHashSet : "+li.next());
        }
        //Storing all the values from HashSet into an Array
        String[] strArr =new String[linkH.size()];
        linkH.toArray(strArr);
        System.out.println("Copied array Content : ");
        for(String str : strArr) {
        	System.out.println(str);
        }
        
        HashSet<String> hs = new HashSet<String>();
        
        hs.add("one");
        hs.add("two");
        hs.add("three");
        hs.add("four");
        hs.add("five");
        hs.add("six");
        
        HashSet<String> subset = new HashSet<String>();
        subset.add("six");
        subset.add("three");
        subset.add("one");
        
        hs.retainAll(subset);
        System.out.println(hs);
        
	}

}
