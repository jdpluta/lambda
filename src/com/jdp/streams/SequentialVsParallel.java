package com.jdp.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class SequentialVsParallel {
	public static void processSequential(List<String> values) {
		long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
	}

	public static void processParallel(List<String> values) {
		long t0 = System.nanoTime();
		long count = values.parallelStream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("parallel sort took: %d ms", millis));
	}

	public static void main(String[] args) {
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		long t0 = System.nanoTime();
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println("Generation of " + max + " values took " + millis);
		processSequential(values);
		processParallel(values);
	}
}
