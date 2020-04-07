package com.demo.jaxb;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

	@XmlElement(name="emp-id")
	private BigDecimal empId;
	@XmlElement(name="employee-name")
    private String empName;
	@XmlElement(name="salary")
    private BigDecimal salary;
	@XmlElement(name="address")
    private String address;
	
	private String id;
	private String dept;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Employee(BigDecimal empId, String empName, BigDecimal salary, String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.address = address;
	}
	public Employee() {
		super();
	}
	
	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public BigDecimal getEmpId() {
		return empId;
	}
	public String getEmpName() {
		return empName;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public String getAddress() {
		return address;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", address=" + address
				+ "]";
	}
    
    
    
}
