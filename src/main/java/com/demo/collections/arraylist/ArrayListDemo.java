package com.demo.collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("java");
		al.add("C++");
		al.add("python");
		al.add("NodeJs");
		al.add("Shell");
		
		System.out.println(al.get(1));
		al.add(2, "Angular");
		System.out.println(al);
		System.out.println(al.contains("NodeJs"));
		System.out.println(al.isEmpty());
		System.out.println(al.size());
		System.out.println(al.indexOf("python"));
		
		
		
		//ArrayList<String> copy = (ArrayList<String>) al.clone();
      //  System.out.println(copy);
        
       List<Employee> list = new ArrayList<Employee>();
        
       list.add(new Employee("john", 3000));
       list.add(new Employee("smith", 4000));
       list.add(new Employee("Bob", 5000));
       list.add(new Employee("Evans", 2000));
       list.add(new Employee("Daryl", 1000));
       list.add(new Employee("tom", 9000));
       list.add(new Employee("Jeff", 6000));
       
       Collections.sort(list, new MySalaryComp());
       System.out.println("Sorted list entries :");
       for(Employee e : list) {
    	   System.out.println(e);
       }
       
	}

}

class MySalaryComp implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.getSal() > e2.getSal()) {
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