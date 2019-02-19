package com.jdp.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambdaSort {
	public static void main(String[] args) {
		TestLambdaSort.compareIntegers();
		System.out.println("=====================");
		System.out.println("=====================");
		TestLambdaSort.compareStrings();
	}

	public static void compareIntegers() {
		// Arrays a = new Arrays(3,1,2,6,4,9,1);
		List<Integer> list = Arrays.asList(3, 1, 14, 2, 6, 4, 9, 12);
		System.out.println("List Integers before sort: " + list);
		Collections.sort(list);
		System.out.println("List Integers after sort: " + list);
		System.out.println("=====================");
		list = Arrays.asList(3, 1, 14, 2, 6, 4, 9, 12);
		System.out.println("List Integers before sort: " + list);
		Collections.sort(list, new Comparator<Integer>() {
			public int compare(Integer one, Integer two) {
//				int i = 0;
//				if (one == two || one.equals(two))
//					i = 0;
//				else
//					i = one.compareTo(two);
//				return i;
				// return one.compareTo(two);
				return one.intValue() - two.intValue();
			}
		});
		System.out.println("List Integers after sort: " + list);
		System.out.println("=====================");
		list = Arrays.asList(3, 1, 14, 2, 6, 4, 9, 12);
		System.out.println("List Integers Lambda before sort: " + list);
		Collections.sort(list, (Integer one, Integer two) -> one.intValue() - two.intValue());
		System.out.println("List Integers Lambda after sort: " + list);
		System.out.println("=====================");
		list = Arrays.asList(3, 1, 14, 2, 6, 4, 9, 12);
		System.out.println("List Integers Lambda before sort: " + list);
		Collections.sort(list, (Integer one, Integer two) -> (one.intValue() - two.intValue()) * -1);
		System.out.println("List Integers Lambda after sort reverse order: " + list);
	}

	public static void compareStrings() {
		List<String> list = Arrays.asList("", "one", "three", "fourteen", "seven", "four", "nine", "two");
		System.out.println("List Strings before sort: " + list);
		Collections.sort(list);
		System.out.println("List Strings after sort: " + list);
		System.out.println("=====================");
		list = Arrays.asList("", "one", "three", "fourteen", "seven", "four", "nine", "two");
		System.out.println("List Strings before sort: " + list);
		Collections.sort(list, new Comparator<String>() {
			public int compare(String one, String two) {
				int i = 0;
				if (one == two || one.equals(two))
					i = 0;
				else
					i = one.compareTo(two);
				return i;
			}
		});
		System.out.println("List Strings after sort: " + list);
		System.out.println("=====================");
		list = Arrays.asList("", "one", "three", "fourteen", "seven", "four", "nine", "two");
		System.out.println("List Strings Lambda before sort: " + list);
		Collections.sort(list, (one, two) -> one.compareTo(two));
		System.out.println("List Strings Lambda after sort: " + list);
	}
}
