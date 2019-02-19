package com.jdp.streams;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sum50Numbers {
	public static void main(String[] args) {
		int iLimit = 5;
		Set<Integer> iS = Stream.iterate(1, i -> i = i + 1).limit(5).collect(Collectors.toSet());
		iS.forEach(i -> System.out.println(i));
		Set<Integer> iL = Stream.iterate(1, i -> i = i + 1).limit(5).collect(Collectors.toSet());
		iL.forEach(i -> System.out.println(i));

		iLimit = 10;
		int ii = Stream.iterate(1, i -> ++i)
				.limit(iLimit)
				.mapToInt(i -> i.intValue())
				.reduce(0, (x, y) -> {
						System.out.println("x: " + x + " y: " + y);
						return x + y;
				});
		System.out.println(ii);
		ii = Stream.iterate(1, i -> ++i)
				.limit(iLimit)
				.mapToInt(i -> i.intValue())
				.reduce(0, (x, y) -> x + y);
		System.out.println(ii);
		ii = Stream.iterate(1, i -> ++i)
				.limit(iLimit)
				.reduce(0, (x, y) -> {
					System.out.println("x: " + x + " y: " + y);
					return x + y;
		});
		System.out.println(ii);
		ii = Stream.iterate(1, i -> ++i).limit(iLimit).reduce(0, (x, y) -> x + y);
		System.out.println(ii);
		ii = Stream.iterate(1, i -> ++i).limit(iLimit).mapToInt(i -> i.intValue()).reduce(0, Integer::sum);
		System.out.println(ii);
		ii = Stream.iterate(1, i -> ++i).limit(iLimit).mapToInt(i -> i.intValue()).sum();
		System.out.println(ii);
	}
}
