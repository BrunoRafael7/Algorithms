package main.algorithms;

public class Fatorial {
	public int fatorial (int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		return calculateNumberFatorialRecursive(n);
	}

	private int calculateNumberFatorial(int n) {//10
		int result = 1;
		for (int i = n; i >= 1; i--) {
			result *= i;
		}
		return result;
	}
	
	private int calculateNumberFatorialRecursive(int n) {//10
		if(n <= 1) {
			return 1;
		}
		
		return n * calculateNumberFatorialRecursive(n - 1);
	}
	
	
	
	
}
