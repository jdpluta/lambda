package com.jdp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Person. Name: " + name + " age: " + age;
	}
}

public class TestLambdaStream {

	public static void main(String[] args) {
		// Before Java8
		List<String> lines = Arrays.asList("spring", "node", "mkyong");
		List<String> result = TestLambdaStream.getFilterOutput(lines, "mkyong");
		for (String temp : result) {
			System.out.println(temp); // output : spring, node
		}

		// Java8
		List<String> lines2 = Arrays.asList("spring", "node", "mkyong");

		List<String> result2 = lines2.stream() // convert list to stream
		    .filter(line -> !"mkyong".equals(line)) // we dont like mkyong
		    .collect(Collectors.toList()); // collect the output and convert streams to a List

		result2.forEach(System.out::println); // output : spring, node

		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20), new Person("lawrence", 40));

		Person result3 = getStudentByName(persons, "jack");
		System.out.println(result3);

		List<Person> persons2 = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20), new Person("lawrence", 40));
		Person result21 = persons.stream() // Convert to steam
		    .filter(x -> "jack".equals(x.getName())) // we want "jack" only
		    .findAny() // If 'findAny' then return found
		    .orElse(null); // If not found, return null

		System.out.println("result21: " + result21);

		Person result22 = persons.stream().filter(x -> "ahmook".equals(x.getName())).findAny().orElse(null);

		System.out.println("result22: " + result22);

		List<Person> persons3 = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20), new Person("lawrence", 40));
		String name = persons3.stream().filter(x -> "jack".equals(x.getName())).map(Person::getName) // convert stream to String
		    .findAny().orElse("");
		System.out.println("name : " + name);

		List<String> collect = persons3.stream().map(Person::getName).collect(Collectors.toList());
		collect.forEach(System.out::println);

	}

	private static List<String> getFilterOutput(List<String> lines, String filter) {
		List<String> result = new ArrayList<>();
		for (String line : lines) {
			if (!"mkyong".equals(line)) { // we dont like mkyong
				result.add(line);
			}
		}
		return result;
	}

	private static Person getStudentByName(List<Person> persons, String name) {

		Person result = null;
		for (Person temp : persons) {
			if (name.equals(temp.getName())) {
				result = temp;
			}
		}
		return result;
	}
}
