package com.tap.calculator.util;

import com.tap.calculator.ops.impl.ArithmeticOperations;

public class SolveExpression {
	private ArithmeticOperations arithOp = new ArithmeticOperations();
	private String[] val;
	private String result;
	
	public void solve(String expression) {
		try {
			if (expression.contains("-")) {
				if (!(expression.startsWith("-"))) {
					val = expression.split("\\-");
					setResult(arithOp.subt(val[0], val[1]));
				}
				else {
					if(expression.contains("+")) {
						val = expression.substring(1).split("\\+");
						setResult(arithOp.subt(val[1], val[0]));
					}
					else if (expression.contains("*")) {
						val = expression.substring(1).split("\\*");
						setResult("-" + arithOp.mul(val[0], val[1]));
					}
					else if (expression.contains("/")) {
						val = expression.substring(1).split("\\/");
						setResult("-" + arithOp.div(val[0], val[1]));
					}
					else {
						val = expression.substring(1).split("\\-");
						setResult("-" + arithOp.add(val[1], val[0]));
					}
				}
			}
			else if(expression.contains("+")) {
				val = expression.split("\\+");
				setResult(arithOp.add(val[0], val[1]));
			}
			else if (expression.contains("*")) {
				val = expression.split("\\*");
				setResult(arithOp.mul(val[0], val[1]));
			}
			else if (expression.contains("/")) {
				val = expression.split("\\/");
				setResult(arithOp.div(val[0], val[1]));
			}
			else {
				setResult(expression);
			}
			
			setResult(arithOp.finalizeAns(getResult()));
		}
		catch(Exception e) {
			setResult("0");
		}
		
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
