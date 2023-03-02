package com.tap.calculator.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.tap.calculator.beans.DeclareObjects;
import com.tap.calculator.gateway.util.SolveExpression;;

public class ButtonClick {
	private DeclareObjects decObj = new DeclareObjects();
	private String exp = decObj.getLblExp();
	private SolveExpression ans = new SolveExpression();
	
	public ButtonClick() {
		this.doButtonAction();
	}
	
	//method for button action performed, click.
	public void doButtonAction(){
		decObj.getBtnFunction()[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decObj.setLblExp("");
				exp = "";
			}
		});
		decObj.getBtnFunction()[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equateExpression();
			}
		});
		decObj.getBtnFunction()[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doBckSpc();
			}
		});
		decObj.getBtnFunction()[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				filterDot();
			}
		});
		decObj.getBtnFunction()[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateInput("+");
			}
		});
		
		decObj.getBtnFunction()[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateInput("-");
			}
		});
		
		decObj.getBtnFunction()[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateInput("*");
			}
		});
		
		decObj.getBtnFunction()[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validateInput("/");
			}
		});
		decObj.getBtnDigit()[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(exp.contentEquals("0"))) {
					setDigit("0");
				}
			}
		});
		
		decObj.getBtnDigit()[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("1");
			}
		});
		
		decObj.getBtnDigit()[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("2");
			}
		});
		
		decObj.getBtnDigit()[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("3");
			}
		});
		
		decObj.getBtnDigit()[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("4");
			}
		});
		
		decObj.getBtnDigit()[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("5");
			}
		});
		
		decObj.getBtnDigit()[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("6");
			}
		});
		
		decObj.getBtnDigit()[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("7");
			}
		});
		
		decObj.getBtnDigit()[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("8");
			}
		});
		
		decObj.getBtnDigit()[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDigit("9");
			}
		});

	}
	
	public void setDigit(String d) {
		if (exp.contentEquals("0")){
			exp = d;	
		}
		else if (exp == ans.getResult()) {
			exp = d;
		}
		else {
			exp = decObj.getLblExp() + d;
		}
		decObj.setLblExp(exp);
	}
	
	//method to filter inputs in assigning arithmetic operation
	public void setArithmethicOperation(String operation){
		try {
			int expLen = exp.length();
			
				if (exp.contains("+") || exp.contains("-") || exp.contains("*") || exp.contains("/")) {
					if(exp.endsWith("+") || exp.endsWith("-") || exp.endsWith("*") || exp.endsWith("/")) {			
						exp = exp.substring(0, expLen-1) + operation;
					}
					else if (exp.startsWith("-")) {
						exp = exp + operation;
						decObj.setLblExp(exp);
						ans.solve(exp);
					}
					else {
						ans.solve(exp);
						exp = ans.getResult() + operation;
					}
				}
				else {
					exp = exp + operation;
				}
				decObj.setLblExp(exp);
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//method to filter and validate null and dot inputs
	public void validateInput(String op) {
		if (exp.startsWith("=")) {
			exp = exp.substring(1);
		}
		
		if (!(exp.contentEquals(""))){
			if (!(exp.contentEquals("."))) {
				if (!(exp.endsWith("."))) {
					setArithmethicOperation(op);
				}
				else {
					int expLen = exp.length();
					exp = exp.substring(0, expLen-1);
				}
			}
		}
	}
	
	//method for filtering dot(.) inputs
	public void filterDot() {
		if(exp.contentEquals("")) {
			setDigit("0.");
		}
		else if(exp.endsWith("+") || exp.endsWith("-") || exp.endsWith("*") || exp.endsWith("/")) {
			setDigit("0.");
		}
		else if((!(exp.contains(".")))){
			setDigit(".");
		}
	}
	
	//method to ignore backspace action once the length of the expression is 0
	public void doBckSpc() {
		try {
			int expLen = exp.length();
			if (!(expLen == 0)) {
				exp = exp.substring(0, expLen-1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		decObj.setLblExp(exp);
	}
	
	//method to get the result of the expression
	public void equateExpression() {
		if (!(exp.isEmpty())) {
			if (exp.contains("+") || exp.contains("-") || exp.contains("*") || exp.contains("/")) {
				if (!(exp.endsWith("+") || exp.endsWith("-") || exp.endsWith("*") || exp.endsWith("/"))) {
					if (!(exp.contains("="))){
						try {
							ans.solve(exp);
							exp = ans.getResult();
							decObj.setLblExp(exp);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}
