package com.demo.collections.hashset;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// Hashset does not maintain any insertion order, linkedHashSet maintains the insertion order.
		//It does not allow duplicates
		
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		
		lhs.add("one");
		lhs.add("two");
	
		lhs.add("three");
		
		
		

	//	System.out.println(lhs);
		
		/*Iterator<String> itr = lhs.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		
		//copy the content of LinkedHashSet into an array[]
		
		
		LinkedHashSet<String> lhs1 = new LinkedHashSet<String>();
		
		lhs1.add("seven");
		lhs1.add("eight");
		lhs1.add("nine");
		
		LinkedHashSet<String> lhs2 = new LinkedHashSet<String>();
		lhs2.add("four");
		lhs2.add("five");
		lhs2.add("six");
		
		lhs2.addAll(lhs1);
		
		lhs.addAll(lhs2);
		
		//System.out.println(lhs1.contains("three"));
		
		String[] lhsArray = new String[lhs.size()];
		lhs.toArray(lhsArray);
		
		for(String str : lhsArray) {
			System.out.println(str);
		}
		
		
		
	}

}
