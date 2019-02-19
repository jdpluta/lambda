package com.jdp.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.jdp.lambda.Employee;

public class FilterEmployee {
	public static void main(String[] args) {
		List<Employee> lstEmp = Employee.getEmpList();
		List<Employee> lstNewEmp = lstEmp.stream()
				.filter(emp -> emp.getYearsInOrg() < 2)
				.map(e -> {e.setSal(e.getSal() + 5000); return e;	}) // Incrementing salary
				.collect(Collectors.toList());
		System.out.println("Employees less than a year old with increment:");
		lstNewEmp.forEach(e -> System.out.println(e.getEmpId() + ":" + e.getEmpName() + ":" + e.getSal()));
		Optional<Double> max = lstNewEmp.stream()
				.map(e -> e.getSal())
				.reduce(Double::max); // Finding the maximum salary
		System.out.println("Max: " + max.get());
		List<Employee> lstMaxEmp = lstNewEmp.stream()
				.filter(e -> e.getSal().equals(max.get())) // Finding employees with the maximum salary
				.collect(Collectors.toList());
		System.out.println("Count: " + lstMaxEmp.size());
		System.out.println("\nEmployees having maximum salary after increment:");
		lstMaxEmp.forEach(e -> System.out.println(e.getEmpId() + ":" + e.getEmpName() + ":" + e.getSal()));
		
		Stream<String> msg = Stream.of("Java8 ", "in ", "Action ");
    msg.forEach(System.out::print);
//    msg.forEach(System.out::print);
    
  	// Creating a list of Integers 
    List<Integer> list = Arrays.asList(3, 6, 9, 12, 15); 
    // Using Stream map(Function mapper) and 
    // displaying the corresponding new stream 
    list.stream().map(number -> number * 3).forEach(System.out::println); 
	}
}
