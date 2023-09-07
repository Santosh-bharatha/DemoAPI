package com.streams.demo;

import java.util.ArrayList;
import java.util.List;

public class EmployeeStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<>();
		
		empList.add(new Employee("John", "Admin", 9000));
		empList.add(new Employee("Dev", "Account", 8000));
		empList.add(new Employee("Phil", "Dev", 7000));
		empList.add(new Employee("Josh", "testing", 6600));
		empList.add(new Employee("Ryan", "QA", 6500));
		empList.add(new Employee("Jeff", "DB", 6000));
		
		empList.stream().filter(emp ->emp.getSalary() >6500).forEach(System.out::println);
		empList.stream().filter(emp ->emp.getName().equalsIgnoreCase("Josh")).forEach(System.out::println);
		

	}

}
