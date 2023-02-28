package com.tap.calculator;
 
import com.tap.calculator.events.ButtonClick;

public class Main {
	@SuppressWarnings("unused")
	private ButtonClick btnClick = new ButtonClick();
	public Main() {
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}