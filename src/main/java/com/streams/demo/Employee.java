package com.streams.demo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Employee implements Serializable{

	public Employee(String name, String account, int salary) {
		super();
		this.name = name;
		this.account = account;
		this.salary = salary;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -3366974582386402700L;
	
	private String name;
	private String account;
	private Integer salary;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", account=" + account + ", salary=" + salary + "]";
	}
	
	
	

}
