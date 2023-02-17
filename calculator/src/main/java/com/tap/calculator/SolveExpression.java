package com.tap.calculator;

public class SolveExpression {
	ArithmeticOperations arithOp = new ArithmeticOperations();
	String[] val;
	String result;
	
	public void solve(String expression) {
		try {
			if (expression.contains("-")) {
				if (!(expression.startsWith("-"))) {
					val = expression.split("\\-");
					result = arithOp.subt(val[0], val[1]);
				}
				else {
					if(expression.contains("+")) {
						val = expression.substring(1).split("\\+");
						result = arithOp.subt(val[1], val[0]);
					}
					else if (expression.contains("*")) {
						val = expression.substring(1).split("\\*");
						result = "-" + arithOp.mul(val[0], val[1]);
					}
					else if (expression.contains("/")) {
						val = expression.substring(1).split("\\/");
						result = "-" + arithOp.div(val[0], val[1]);
					}
					else {
						val = expression.substring(1).split("\\-");
						result = "-" + arithOp.add(val[1], val[0]);
					}
				}
			}
			else if(expression.contains("+")) {
				val = expression.split("\\+");
				result = arithOp.add(val[0], val[1]);
			}
			else if (expression.contains("*")) {
				val = expression.split("\\*");
				result = arithOp.mul(val[0], val[1]);
			}
			else if (expression.contains("/")) {
				val = expression.split("\\/");
				result = arithOp.div(val[0], val[1]);
			}
			else {
				result=expression;
			}
			
			result = arithOp.finalizeAns(result);
		}
		catch(Exception e) {
			result = "0";
		}
		
	}
	
}
