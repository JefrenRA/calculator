package com.tap.calculator.ops.impl;

import com.tap.calculator.ops.Operations;

public class ArithmeticOperations implements Operations {

	public String add(String addend, String augend) {
		double addVal1 = Double.valueOf(addend);
		double addVal2 = Double.valueOf(augend);
		double sum = addVal1 + addVal2;
		
		return String.format("%1$,.2f", sum);
	}

	public String subt(String minuend, String subtrahend) {
		double subVal1 = Double.valueOf(minuend);
		double subVal2 = Double.valueOf(subtrahend);
		double difference = subVal1 - subVal2;

		return String.format("%1$,.2f",difference);
	}

	public String mul(String multiplier, String multiplicand) {
		double mulVal1 = Double.valueOf(multiplier);
		double mulVal2 = Double.valueOf(multiplicand);
		double product = mulVal1 * mulVal2;

		return String.format("%1$,.2f",product);
	}

	public String div(String dividend, String divisor) {
		double divVal1 = Double.valueOf(dividend);
		double divVal2 = Double.valueOf(divisor);
		double quotient = divVal1 / divVal2;

		return String.format("%1$,.2f", quotient);
	}

	public String finalizeAns(String ans) {
		if (ans.endsWith(".00")) {
			int deci = ans.indexOf(".");
			ans = ans.substring(0,deci);
		}
		
		return "="+ans;
	}

}
