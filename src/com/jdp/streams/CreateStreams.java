package com.jdp.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.jdp.lambda.Employee;

public class CreateStreams {
	public static void main(String[] args) {
		List<Employee> lstEmp = Employee.getEmpList();
		Stream<Employee> empStream = lstEmp.stream();
		String[] emps = { "Jose Jacob", "Robert King", "John Mathew" };
		Stream<String> nameStream = Arrays.stream(emps);
		String fileName = "c://Employees.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(System.out::println);
		}
		catch (IOException excIO) {
			excIO.printStackTrace();
		}
		Stream<String> stream = Stream.of("Jose Jacob", "Robert King", "John Mathew");
		Stream<Employee> filterdStream = empStream.filter(emp -> emp.getEmpId() < 4);
		// filterdStream.forEach(System.out::println);
		Stream<Employee> sortedStream = filterdStream
				.sorted((emp1, emp2) -> emp1.getEmpName().compareTo(emp2.getEmpName()));
		sortedStream.forEach(System.out::println);
		System.out.println("Pipe stream");
		Stream<Employee> sortedStream2 = lstEmp.stream().filter(e -> e.getEmpId() < 5)
				.sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()));
		sortedStream2.forEach(System.out::println);
		System.out.println("Double salary");
//		Stream<Employee> sortedStream3 = 
		lstEmp.stream()
			.filter(e -> e.getEmpId() < 5).sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()))
			.map(e -> {e.setSal(e.getSal() * 2); return e;})
			.forEach(e -> System.out.println(e));
		System.out.println("Original List");
		lstEmp.forEach(System.out::println);
		
		System.out.println("List of Double salary");
		List<Employee> newLstEmp = lstEmp.stream()
				.filter(e -> e.getEmpId() < 5)
				.sorted((e1, e2) -> e1.getEmpName().compareTo(e2.getEmpName()))
				.map(e -> {e.setSal(e.getSal() * 2); return e;})
				.collect(Collectors.toList());
		newLstEmp.forEach(e -> System.out.println(e));
	}
}
