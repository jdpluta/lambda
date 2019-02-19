package com.jdp.lambda;

public class StringFormatter {
	interface StringFormatterI {
		String format(String s1, String s2);
	}
	public static void main(String[] args) {
		StringFormatterI sf1 = (s1, s2) -> s1 + " " + s2;
		System.out.println(sf1.format("Lambda", "Expression"));

		StringFormatterI sf2 = (s1, s2) -> s1 + " - " + s2;
		System.out.println(sf2.format("Lambda", "Expression"));
		
		StringFormatterI sf3 = (s1, s2) -> s1.toUpperCase() + " " + s2.toUpperCase();
		System.out.println(sf3.format("Lambda", "Expression"));
	}
}
