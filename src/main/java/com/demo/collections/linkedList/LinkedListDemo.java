package com.demo.collections.linkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("Orange");
		ll.add("Grapes");
		ll.add("apple");
		ll.add("Banana");
		ll.add("Cherry");
		ll.add("strawberry");
		
		//System.out.println(ll);
		System.out.println("size of linked list: "+ ll.size());
		System.out.println(ll.isEmpty());
		System.out.println(ll.contains("Grapes"));
		
		/*Iterator itr = ll.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		*/
		LinkedList<String> clone = (LinkedList<String>) ll.clone();
		//System.out.println(clone);
		
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		Iterator itr = ll.iterator();
		
		List<String> list2 = new ArrayList<String>();
		list2.add("books");
		list2.add("records");
		
		System.out.println(ll.contains("books"));
		
		ll.addAll(list2);
		System.out.println("contains :"+ll.contains("books"));
		System.out.println(ll);
		ll.push("last element");
		System.out.println("After push :" + ll);
		System.out.println("After pop :" + ll.pop());
		System.out.println(ll);
		/*while(itr.hasNext()) {
			System.out.println(itr.next());
		}*/
		
		/*Collections.shuffle(ll);
		for(String str : ll) {
			System.out.println(str);
		}
		*/
		
		LinkedList<Employee> empList = new LinkedList<Employee>();
		empList.add(new Employee("john", 3000));
		empList.add(new Employee("smith", 4000));
		empList.add(new Employee("Bob", 5000));
		empList.add(new Employee("Evans", 2000));
		empList.add(new Employee("Daryl", 1000));
		empList.add(new Employee("tom", 9000));
		empList.add(new Employee("Jeff", 6000));
		
		Collections.sort(empList, new MySalaryComp());
		for(Employee emp : empList) {
			System.out.println(emp); 
		
		}
	
	}

}

class MySalaryComp implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getSal() < e2.getSal()) {
			return 1;
		}
		return -1;
	}
	
}

class Employee{
	
	private String name;
	private int sal;
	
	public Employee(String name, int sal) {
		this.name = name;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
	
	
}
