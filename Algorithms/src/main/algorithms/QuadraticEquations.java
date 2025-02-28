package main.algorithms;

public class QuadraticEquations {
	
	public double[] calculeRootOfEquation(int a, int b, int c){
		double delta = Math.pow(b, 2) - (4 * a * c);
		if(delta < 0) {
			System.out.println("Não existem raízes reais para esta equação. Use a técnica com o o numero imaginario i");
			return null;
		}
			
		double x1 = (-b + Math.sqrt(delta))/(2 * a);
		double x2 = (-b - Math.sqrt(delta))/(2 * a);
		double [] result = {x1, x2};
		System.out.println("X1 = " + result[0] + " X2 = " + result[1]);
		return result;
	}

}
