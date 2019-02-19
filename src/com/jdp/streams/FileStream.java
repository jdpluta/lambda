package com.jdp.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStream {
	public static void main(String[] args) {
//		String fileName = "c://Employees.txt";
		String fileName = "./Employees.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream
			.sorted((e1, e2) -> {System.out.format("e1 %s e2 %s\n", e1, e2); return e1.compareTo(e2);})
			.forEach(System.out::println);
		}
		catch (IOException excIO) {
			excIO.printStackTrace();
		}
//		String fileName = "./Employees.txt";
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream
			.sorted((e1, e2) -> {System.out.format("e1 %s e2 %s\n", e1, e2); return e2.compareTo(e1);})
			.forEach(System.out::println);
		}
		catch (IOException excIO) {
			excIO.printStackTrace();
		}
		System.out.println("Content of directory '.'");
		try (Stream<Path> stream = Files.walk(Paths.get("."))) {
			stream
			.forEach(System.out::println);
		}
		catch (IOException excIO) {
			excIO.printStackTrace();
		}
		System.out.println("Sub-directories of '.'");
		try (Stream<Path> stream = Files.walk(Paths.get("."))) {
			stream
			.filter(Files::isDirectory)
			.forEach(System.out::println);
		}
		catch (IOException excIO) {
			excIO.printStackTrace();
		}
	}
}
