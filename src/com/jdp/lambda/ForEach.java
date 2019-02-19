package com.jdp.lambda;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ForEach {
	
	public static void main(String [] args) {
		List<String> l = Arrays.asList("Str1","str2","sTr3");
		System.out.println("List 1");
		l.forEach(e -> System.out.println(e));
		System.out.println("List 2");
		l.forEach(System.out::println);
		
		Set<String> s = new HashSet<>(Arrays.asList("Str1", "str2", "sTr3"));
		System.out.println("Set 1");
		s.forEach(e->System.out.println(e));
		System.out.println("Set 2");
		s.forEach(System.out::println);
		
		Queue<String> q = new ArrayDeque<>(Arrays.asList("Str1", "str2", "sTr3"));
		System.out.println("Queue 1");
		q.forEach(e->System.out.println(e));
		System.out.println("Queue 2");
		q.forEach(System.out::println);
		
		Map<Integer, String> m = new HashMap<>();
		m.put(1,  "Larry");
		m.put(2,  "Steve");
		m.put(3,  "James");
		System.out.println("Map 1");
		m.forEach((key, value) -> System.out.println(key + " " + value));
		System.out.println("Map 2");
		m.entrySet().forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue() ));
	}
}
