package com.jdp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {
	public static void main(String[] args) {
		List<Employee> empList = Employee.getEmpList();
		for(Employee e : empList) {
			double sal = computeSalary(e, e1 -> e1.getSal() * 1.10);
			System.out.println(e.toString() + " new salary: " + sal);
		}
	}
	public static double computeSalary(Employee e, Function<Employee, Double> fn) {
		return fn.apply(e);
	}
}
