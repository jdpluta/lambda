package com.jdp.streams;

import java.util.ArrayList;
import java.util.List;

public class ListToArray {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("Apple");
		myList.add("Banana");
		myList.add("Orange");
		String[] myArray = myList.stream().toArray(String[]::new);
		System.out.println(myArray);
		for (String str : myArray) {
			System.out.println(str);
		}
	}
}
