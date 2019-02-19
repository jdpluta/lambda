package com.jdp.lambda;

import java.util.function.BiFunction;

public class Calculator {
	public static void main(String[] args) {
		int sum = evaluate(3,2, (i, j) -> i + j);
		System.out.println("Sum: " + sum);
		int sub = evaluate(3,2, (i, j) -> i - j);
		System.out.println("Sum: " + sub);
		int mult = evaluate(3,2, (i, j) -> i * j);
		System.out.println("Sum: " + mult);
}
	public static Integer evaluate(Integer t, Integer u, BiFunction<Integer, Integer, Integer> fn) {
		return fn.apply(t, u);
	}
}
