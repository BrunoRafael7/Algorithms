package main.algorithms;

public class Fibonacci {
	
	public long fibonacci (int position) {
		return fibonacciRecursive(position- 1);
	}
	public long fibonacciWithFor(int n) {

		if(n == 0 || n == 1) {
			return n;
		}
		long[] result = new long[n + 1];
		result[0] = 0;
		result[1] = 1;
		for (int i = 2; i <= n; i++ ) {
			result[i] = (result[i - 1] + result[i - 2]);
		}
		return result[n];
	}
	
	public long fibonacciRecursive (long n) {
		if(n <= 1) {
			return n;
		}
		
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
		
	}
}
