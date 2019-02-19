package com.jdp.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CubeNumbers {
	public static void main(String[] args) {
//		Stream<Integer> stream = Stream.of(1,2,3,4,5);
		Stream.of(1,2,3,4,5)
		.map(i -> {
			int j = i*i*i; 
			return j;})
		.forEach(i -> System.out.print(i + " "));
		
		List<Integer> cubedList = Stream.of(1,2,3,4,5)
		.map(i -> i*i*i)
		.collect(Collectors.toList());
		int[] cubedArray = new int[cubedList.size()];
		System.out.println("\n");
		int inx = 0;
		for (Integer iI : cubedList)
			cubedArray[inx++] = Integer.valueOf(iI);
		for (int i : cubedArray) 
			System.out.print(i + " ");
	}
}
