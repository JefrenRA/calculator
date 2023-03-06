package com.tap.calculator;

import com.tap.calculator.beans.CalculatorFrame;

public class Main {
	
	public Main() {
		CalculatorFrame main = new CalculatorFrame();
		main.display();
	}
	
	public static void main(String[] args) {
		new Main();
	}

	
}