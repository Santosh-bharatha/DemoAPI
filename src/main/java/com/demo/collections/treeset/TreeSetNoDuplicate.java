package com.demo.collections.treeset;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetNoDuplicate {

	public static void main(String[] args) {
		
		TreeSet<Emp> ts = new TreeSet<Emp>(new EmpComp());
		ts.add(new Emp(101, "Julia", 40000));
		ts.add(new Emp(201, "John", 50000));
		ts.add(new Emp(301, "jack", 30000));
		ts.add(new Emp(401, "bob", 40000));
		ts.add(new Emp(501, "Alex", 70000));
		
		//adding a duplicate entry
		ts.add(new Emp(401, "bob", 40000));
		
		/*for(Emp emp : ts) {
			System.out.println(emp);
		}*/
	//	System.out.println(ts.descendingSet());
		
		
		TreeSet<Emp> treeSet = new TreeSet(new SalaryComparator());
		treeSet.add(new Emp("Julia", 20000));
		treeSet.add(new Emp("John", 50000));
		treeSet.add(new Emp("Jack", 30000));
		treeSet.add(new Emp("Jim", 30000));
		
		System.out.println(" Least salary of employee :" + treeSet.first());
	//	System.out.println(" "+ treeSet.descendingSet());
		

	}

}

class SalaryComparator implements Comparator<Emp>{

	@Override
	public int compare(Emp e1, Emp e2) {
		
		if(e1.getEmpSal() < e2.getEmpSal()) {
			return 1;
		}else {
			return -1;
		}
	}
	
}

class EmpComp implements Comparator<Emp>{

	@Override
	public int compare(Emp e1, Emp e2) {
		
		if(e1.getEmpId() == e2.getEmpId()) {
			return 0;
		}if(e1.getEmpId() < e2.getEmpId()) {
			return 1;
		} else {
			return -1;
		}
		
	}
	
}