package edu.umb.cs680.hw01;

public class Calculator {

	public float multiply(float x, float y){
		return x*y;
	}

	public float divide (float x, float y) {
		if(y == 0){
			throw new IllegalArgumentException("division by zero");
		}
		return x/y;
	}
	
	public static void main(String[] args){
		Calculator	cc = new Calculator();
		System.out.println( cc.multiply(2, 3) );
		System.out.println( cc.divide(10, 2) );
	}
	
}
