package com.tap.calculator.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.tap.calculator.beans.DeclareObjects;
import com.tap.calculator.util.SolveExpression;;

public class ButtonClick {
	private DeclareObjects decObj = new DeclareObjects();
	private String exp = decObj.getLblExp();
	private SolveExpression ans = new SolveExpression();
	
	public void action(){
		decObj.setUpObjects();
		decObj.getBtnFunction()[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decObj.setLblExp("");
				exp = "";
			}
		});
		decObj.getBtnFunction()[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				equal();
			}
		});
		decObj.getBtnFunction()[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bckSpc();
			}
		});
		decObj.getBtnFunction()[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dot();
			}
		});
		decObj.getBtnFunction()[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("+");
			}
		});
		
		decObj.getBtnFunction()[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("-");
			}
		});
		
		decObj.getBtnFunction()[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("*");
			}
		});
		
		decObj.getBtnFunction()[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("/");
			}
		});
		decObj.getBtnDigit()[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(exp.contentEquals("0"))) {
					digit("0");
				}
			}
		});
		
		decObj.getBtnDigit()[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("1");
			}
		});
		
		decObj.getBtnDigit()[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("2");
			}
		});
		
		decObj.getBtnDigit()[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("3");
			}
		});
		
		decObj.getBtnDigit()[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("4");
			}
		});
		
		decObj.getBtnDigit()[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("5");
			}
		});
		
		decObj.getBtnDigit()[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("6");
			}
		});
		
		decObj.getBtnDigit()[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("7");
			}
		});
		
		decObj.getBtnDigit()[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("8");
			}
		});
		
		decObj.getBtnDigit()[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("9");
			}
		});

	}
	public void digit(String d) {
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
	
	public void arithmethicOperation(String operation){
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
	
	public void testInput(String op) {
		if (exp.startsWith("=")) {
			exp = exp.substring(1);
		}
		
		if (!(exp.contentEquals(""))){
			if (!(exp.contentEquals("."))) {
				if (!(exp.endsWith("."))) {
					arithmethicOperation(op);
				}
				else {
					int expLen = exp.length();
					exp = exp.substring(0, expLen-1);
				}
			}
		}
	}
	
	public void dot() {
		if(exp.contentEquals("")) {
			digit("0.");
		}
		else if(exp.endsWith("+") || exp.endsWith("-") || exp.endsWith("*") || exp.endsWith("/")) {
			digit("0.");
		}
		else if((!(exp.contains(".")))){
			digit(".");
		}
	}
	
	public void bckSpc() {
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
	
	public void equal() {
		if (!(exp.isEmpty())) {
			if (!(exp.contains("="))){
				ans.solve(exp);
				exp = ans.getResult();
				decObj.setLblExp(exp);
			}
		}
	}
}
