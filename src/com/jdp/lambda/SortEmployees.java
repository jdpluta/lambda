package com.jdp.lambda;

import java.util.Arrays;
import java.util.List;
/*
class Employee {
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	private Integer empId;
	private String empName;
	private String country;
	public String toString() {
		return "Country: " + country;
	}
	// Other attributes, constructor, getters and setters
	public static int compareByCountry(Employee e1, Employee e2) {
		System.out.println("Country 1: " + e1.getCountry() + " Country 2: " + e2.getCountry());
		return e1.getCountry().compareTo(e2.getCountry());
	}
}
*/
public class SortEmployees {
	public static void main(String[] args) {
		List<Employee> empList = Employee.getEmpList();
		empList.sort(Employee::compareByCountry);
		
		for (Employee e : empList)
			System.out.println(e.getCountry());
		
		empList.forEach(e -> System.out.println(e.getCountry()));
		
		empList.forEach(System.out::println);
	}
}
