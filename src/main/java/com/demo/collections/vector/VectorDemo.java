package com.demo.collections.vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import jlibs.core.util.Enumerator;

public class VectorDemo {

	public static void main(String[] args) {
		
		Vector<String> vect = new Vector<String>();
		
		vect.add("Top");
		vect.add("Medium");
		vect.add("Lower");
		vect.add("John");
		vect.add("Champ");
		
		//vect.add(2,"Trivial");
		/*System.out.println(vect);
		System.out.println(vect.get(3));
		System.out.println(vect.firstElement());
		System.out.println(vect.lastElement());
		System.out.println(vect.isEmpty());*/
		
		/*Iterator<String> itr = vec.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		
		/*Enumeration<String> enm =  vec.elements();
		while(enm.hasMoreElements()) {
			System.out.println(enm.nextElement());
		}
		
		Vector<String> cloneVec = (Vector<String>) vec.clone();

		System.out.println(cloneVec);*/
		//deletes all elements from vector
		//vec.clear();
		System.out.println(vect.isEmpty());
		
		List<String> list = vect.subList(2, 4);
		System.out.println(list);
		
		Vector vc = new Vector();
		vc.add(0 , 1);
		vc.add(1 , "Hi");
		vc.add(2 , "Good Morning");
		vc.add(3 , 2);
		
		
		ArrayList arr = new ArrayList();
		arr.add(3);
		arr.add(3);
		arr.add("geeks");
		arr.add("for");
		arr.add("geeks");
		arr.add(4);
		
		Vector vector = new Vector();
		vector.add(5);
		vector.add(5);
		vector.addAll(1, arr);
		System.out.println(vector);
		
		//vc.addAll(arr);
		
		vc.addAll(vector);
		vc.ensureCapacity(22);
		System.out.println(vc.capacity());
		System.out.println(vc.indexOf("Good Morning"));
		System.out.println(vc.hashCode());
		
		Vector v2 = new Vector();
		v2.addAll(vc);
		if(vc.equals(v2)) {
			System.out.println("Both are equal");
		}
		
		
		String elements[] = {"M", "N", "O", "P", "Q"};
		Set set = new HashSet(Arrays.asList(elements));
		
		String[] strObj = new String[set.size()];
		
		strObj = (String[])set.toArray(strObj);
		for(int i=0; i< strObj.length; i++) {
			System.out.println(strObj[i]);
		}
		System.out.println(set);
		
		Vector vec = new Vector(7); 
		  
        // use add() method to add elements in the vector 
        vec.add(1); 
        vec.add(2); 
        vec.add(3); 
        vec.add(4); 
        vec.add(5); 
        vec.add(6); 
        vec.add(7); 
        
        Integer[] array = new Integer[7];
        vec.copyInto(array);
        
        for(Integer num : array) {
        	System.out.println(" values :"+num.toString());
        }
	}

}
