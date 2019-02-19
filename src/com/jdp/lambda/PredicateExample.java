package com.jdp.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
	public static void main(String[] args) {
		List<Integer> lstEmpIds = Arrays.asList(2001, 2002, 2003, 2004);
		System.out.println("Printing even Employee IDs");
		evaluate(lstEmpIds, (n) -> n % 2 == 0);
		System.out.println("Printing odd Employee IDs");
		evaluate(lstEmpIds, (n) -> n % 2 == 1);
		System.out.println("Printing even Employee less than 2003");
		evaluate(lstEmpIds, 
				(n) -> n < 2003);
	}
	public static void evaluate(List<Integer> lstEmpIds, Predicate<Integer> predicateArg) {
		for (int empId : lstEmpIds) {
			if (predicateArg.test(empId))
				System.out.println(empId);
		}
	}
}
