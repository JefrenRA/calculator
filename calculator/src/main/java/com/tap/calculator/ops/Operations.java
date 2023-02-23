package com.tap.calculator.ops;

public interface Operations {
	public String add(String addend, String augend);

	public String subt(String minuend, String subtrahend);

	public String mul(String multplier, String multiplicand);

	public String div(String dividend, String divisor);
	
	public String finalizeAns(String ans);
}
