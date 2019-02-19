package com.jdp.lambda;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TestLambdaFunctions {

	public static void main(String[] args) {
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);
		System.out.println("before replaceAll. " + salaries);
		salaries.replaceAll((name, oldValue) -> name.equals("Freddy") ? oldValue : oldValue + 10000);
		System.out.println("after replaceAll" + salaries);

		Supplier<Double> lazyValue = () -> {
			// Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
			return 9d;
		};

		Double valueSquared = TestLambdaFunctions.squareLazy(lazyValue);
		System.out.println("Supplier. valueSquared: " + valueSquared);

		// int[] fibs = { 0, 1 };
		// Stream<Integer> fibonacci = Stream.generate(() -> {
		// int result = fibs[1];
		// int fib3 = fibs[0] + fibs[1];
		// fibs[0] = fibs[1];
		// fibs[1] = fib3;
		// return result;
		// });
		// System.out.println("fibonacci: " + fibonacci.toArray().toString());

		// Consumer
		List<String> names = Arrays.asList("John", "Freddy", "Samuel");
		names.forEach(name -> System.out.println("Consumer. Hello, " + name));

		Map<String, Integer> ages = new HashMap<>();
		ages.put("John", 25);
		ages.put("Freddy", 24);
		ages.put("Samuel", 30);

		ages.forEach((name, age) -> System.out.println("BiConsumer. " + name + " is " + age + " years old"));

		// Predicate
		List<String> names2 = Arrays.asList("Angela", "Aaron", "Bob", "Claire", "David");

		List<String> namesWithA = names2.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		System.out.println("Predicate. namesWithA: " + namesWithA);

		// Operator
		List<String> names3 = Arrays.asList("bob", "josh", "megan");
		names3.replaceAll(name -> name.toUpperCase());
		System.out.println("Operator. names3: " + names3);

		List<Integer> values = Arrays.asList(3, 5, 8, 9, 12);

		int sum = values.stream().
				reduce(0,	(i1, i2) -> i1 + i2);
		System.out.println("Operator. sum: " + sum);

		// Thread
		System.out.println("Main thread: " + Thread.currentThread().getName());
		Thread thread = new Thread(() -> System.out.println("Hello From Another Thread: " +  Thread.currentThread().getName()));
		thread.start();
		Thread thread2 = new Thread(() -> System.out.println("Hello From Another Thread: " +  Thread.currentThread().getName()));
		thread2.start();
	}

	public static double squareLazy(Supplier<Double> lazyValue) {
		return Math.pow(lazyValue.get(), 2);
	}
}
