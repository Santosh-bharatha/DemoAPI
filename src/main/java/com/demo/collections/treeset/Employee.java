package com.demo.collections.treeset;

public class Employee implements Comparable {
	
	String name;
	int  eid;
	
  public Employee(String name, int eid){
    	this.name = name;
    	this.eid = eid;
    }

@Override
public String toString() {
	return "Employee [name=" + name + ", eid=" + eid + "]";
}

@Override
public int compareTo(Object obj) {
	
	int eid1 = this.eid;
	
	Employee emp = (Employee) obj;
	int eid2 = emp.eid;
	
	if(eid1 < eid2) {
		return +1;
	}else if(eid1 > eid2) {
		return -1;
	}else
	return 0;
}
}
