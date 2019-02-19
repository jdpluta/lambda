package com.jdp.lambda;

import java.util.Arrays;
import java.util.List;

public class Employee {
	private Integer empId;
	private String empName;
	private String country;
	private String role;
	private Double salary;
	private Integer yearsInOrg;

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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setSal(Double sal) {
		this.salary = sal;
	}
	public Double getSal() {
		return salary;
	}
	public void setYearsInOrg(Integer yearsInOrg) {
		this.yearsInOrg = yearsInOrg;
	}
	public Integer getYearsInOrg() {
		return yearsInOrg;
	}
	
	public String toString() {
		StringBuffer st = new StringBuffer();
		st.append("Id: ").append(this.empId);
		st.append(" Name: ").append(this.empName);
		st.append(" Country: ").append(this.country);
		st.append(" Role: ").append(this.role);
		st.append(" Salary: ").append(this.salary);
		st.append(" Years In Org: ").append(this.yearsInOrg);
		return st.toString();
	}
	public static List<Employee> getEmpList() {
		Employee india = new Employee();
		india.setEmpId(1);
		india.setEmpName("Mitul Patel");
		india.setCountry("India");
		india.setRole("Employee");
		india.setSal(100.00);
		india.setYearsInOrg(1);
		Employee usa = new Employee();
		usa.setEmpId(2);
		usa.setEmpName("John Doe");
		usa.setCountry("USA");
		usa.setRole("Manager");
		usa.setSal(200.00);
		usa.setYearsInOrg(1);
		Employee poland = new Employee();
		poland.setEmpId(3);
		poland.setEmpName("Jan Kozak");
		poland.setCountry("Poland");
		poland.setRole("Manager");
		poland.setSal(300.00);
		poland.setYearsInOrg(2);
		Employee england = new Employee();
		england.setEmpId(4);
		england.setEmpName("George Smith");
		england.setCountry("England");
		england.setRole("Employee");
		england.setSal(400.00);
		england.setYearsInOrg(3);
		Employee s[] = { india, usa, poland, england };
		List<Employee> empList = Arrays.asList(s);
		return empList;
	}
	// Other attributes, constructor, getters and setters
	public static int compareByCountry(Employee e1, Employee e2) {
		System.out.println("Country 1: " + e1.getCountry() + " Country 2: " + e2.getCountry());
		return e1.getCountry().compareTo(e2.getCountry());
	}
}

