package com.demo.collections.treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetPractice {

	public static void main(String[] args) {
		
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("one");
		treeSet.add("two");
		treeSet.add("three");
		treeSet.add("four");
		treeSet.add("four"); //duplicate values is not allowed in treeset
		
		System.out.println(treeSet);
		
		TreeSet t = new TreeSet();
		t.add(1);
		t.add(100);
		t.add(123);
		t.add(-23);

		System.out.println(t);
		
		TreeSet<Float> ft = new TreeSet<Float>();
		ft.add((float) 100.23);
		ft.add((float) 123.23);
		ft.add((float) 500.23);
		ft.add((float) 100.23);
		System.out.println(ft);
		
		
		TreeSet tsb = new TreeSet(new MyComparator());
		
		tsb.add(new StringBuffer("A"));
		tsb.add(new StringBuffer("B"));
		tsb.add(new StringBuffer("C"));
		tsb.add(new StringBuffer("D"));
		tsb.add("X");
		tsb.add("X");
		tsb.add("Y");
		
		System.out.println(tsb);
		
		TreeSet ts = new TreeSet(new MyComparator());
		ts.add("A");
		ts.add("B");
		ts.add("C");
		ts.add("D");
		ts.add("E");
		
		System.out.println(ts);
		
		TreeSet tsinteger = new TreeSet();
		tsinteger.add(1);
		tsinteger.add(10);
		tsinteger.add(15);
		tsinteger.add(2);
		tsinteger.add(3);
		tsinteger.add(5);
		tsinteger.add(18);
		tsinteger.add(20);
		
		System.out.println(tsinteger);
		
	}

}

class MyComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		String s1= o1.toString();
		String s2 = o2.toString();
		
		return s1.compareTo(s2);
	}
}

class MyIntComparator implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		
		Integer i1 = (Integer) o1;
		Integer i2 = (Integer) o2;
		
		if(i1 < i2) {
			return +1;
		}else if(i1 > i2) {
			return -1;
		}else return 0;
	}
}