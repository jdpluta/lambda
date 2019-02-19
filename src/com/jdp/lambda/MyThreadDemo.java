package com.jdp.lambda;

public class MyThreadDemo {
	public static void staticThreadProcess() {
		System.out.println("In staticThreadProcess. Name: " + Thread.currentThread().getName());
	}
	public void threadProcess() {
		System.out.println("In threadProcess. Name: " + Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println(" Hello from thread 1. Name: " + Thread.currentThread().getName());
			}
		});
		t.start();
		t = new Thread(() -> {
			System.out.println(" Hello from thread 2. Name: " + Thread.currentThread().getName());
		});
		t.start();
		t = new Thread(() -> System.out.println(" Hello from thread 3. Name: " + Thread.currentThread().getName()));
		t.start();
		Runnable r = () -> System.out.println(" Hello from thread 4. Name: " + Thread.currentThread().getName());
		t = new Thread(r);
		t.start();
		t = new Thread(() -> MyThreadDemo.staticThreadProcess());
		t.start();
		t = new Thread(() -> new MyThreadDemo().threadProcess());
		t.start();
	}
}
