package com.demo.collections.treeset;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class TreeSetDemo {
	
	public static void main(String args[]) {
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("One");
		treeSet.add("Two");
		treeSet.add("Three");
		treeSet.add("Four");
		
		//System.out.println(" elements :"+ treeSet);
		
		//treeSet.clear();
		//System.out.println(treeSet.isEmpty());
		
		treeSet.add("five");
		treeSet.add("six");
		//System.out.println(" elements :"+ treeSet);
		//treeSet.remove("six");
		//System.out.println(" elements :"+ treeSet);
		
		//Iterator
		
		/*Iterator<String> str = treeSet.iterator();
		while(str.hasNext()) {
			System.out.println(str.next());
		}*/
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		
		System.out.println("List :"+list);
		
		TreeSet<String> myset = new TreeSet<String>(list); 
		System.out.println(" Myset :"+myset);
		
	}

}
