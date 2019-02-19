package com.jdp.lambda;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		List<Employee> lstEmp = Employee.getEmpList();
		System.out.println("Generating HR Report");
		generateReport(lstEmp, e -> System.out.println(e.getEmpId() + " : " + e.getEmpName() + " : " + e.getRole() + " : " + e.getSal()));
		
		System.out.println("Generating Manager Report");
	  generateReport(lstEmp, 
	  		e -> System.out.println(e.getEmpId() + " : " + e.getEmpName() + " : " + e.getRole()));
	}
	
	public static void generateReport(List<Employee> lstEmp, Consumer<Employee> consumer) {
		for (Employee e : lstEmp) {
			consumer.accept(e);
		}
	}
}
