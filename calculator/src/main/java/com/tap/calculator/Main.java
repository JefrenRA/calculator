package com.tap.calculator;
 
import com.tap.calculator.events.ButtonClick;

public class Main {
	private ButtonClick btnClick = new ButtonClick();
	public Main() {
		btnClick.action();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}