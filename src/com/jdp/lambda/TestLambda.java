package com.jdp.lambda;

interface Executable {
	public int execute(int a, int b);
}

class Runner {
	public int run(Executable e) {
		System.out.println("Entered Runner. run. method.");
		int a = 7;
		int b = 8;
		int ret = e.execute(a, b);
		System.out.println("Runner. run. Return value: " + ret);
		return ret;
	}
}
public class TestLambda {

	public static void main(String[] args) {
		//Java 1.7 way of doing it
		Runner runner = new Runner();
//		int a = 10;
//		int b = 12;
		runner.run(new Executable () {
			public int execute(int a, int b) {
				System.out.println("Java 1.7 execute");
				return a+b;
			}
		});

		//Java 1.8 Lambda expression way. One statement, NO return value
		//runner.run( () -> System.out.println("Java 1.8 execute. Lambda. single statement"));
	
		//Java 1.8 Lambda expression way. Multiple statements. return value
//		runner.run( () -> {
//			System.out.println("Java 1.8 execute. Lambda. multiple statements 1");
//			System.out.println("Java 1.8 execute. Lambda. multiple statements 2");
//			return 8;
//		});

		//Java 1.8 Lambda expression way. Just return some value
		//runner.run( () -> 8);

		//Java 1.8 Lambda expression way. Pass one parameter. Just return some value 		
//		runner.run( (a) -> { 
//			System.out.println("Java 1.8 execute. Lambda. Pass input parameter: " + a);
//			return a+2;
//		});

	//Java 1.8 Lambda expression way. Pass two parameters. Just return some value
		runner.run( (a, b) -> { 
			System.out.println("Java 1.8 execute. Lambda. Pass two input parameters: " + a + " " + b);
			return a+b;
		});
		
		Executable ex = (a, b) -> {
			System.out.println("In executable");
			return a+b;
		};
		
		runner.run(ex);
		
		Object codeblock = (Executable)(a, b) -> {
			System.out.println("In Object executable");
			return a+b;
		};
		
		runner.run((Executable)codeblock);
	}
}
