package com.tap.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
	private SolveExpression ans = new SolveExpression();
	private DeclareObjects decObj = new DeclareObjects();
	private String exp = decObj.getLblExp();
	
	public Main() {
		decObj.setUpObjects();
		action();
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	public void action(){
		decObj.btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decObj.setLblExp("");
				exp = "";
			}
		});
		
		decObj.btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ans.solve(exp);
				exp = ans.result;
				decObj.setLblExp(exp);
			}
		});
		
		decObj.btnBckSpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		
		decObj.btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
			
		decObj.btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("+");
			}
		});
		
		decObj.btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("-");
			}
		});
		
		decObj.btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("*");
			}
		});
		
		decObj.btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				testInput("/");
			}
		});
		decObj.btnDigit[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!(exp.contentEquals("0"))) {
					digit("0");
				}
			}
		});
		
		decObj.btnDigit[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("1");
			}
		});
		
		decObj.btnDigit[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("2");
			}
		});
		
		decObj.btnDigit[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("3");
			}
		});
		
		decObj.btnDigit[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("4");
			}
		});
		
		decObj.btnDigit[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("5");
			}
		});
		
		decObj.btnDigit[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("6");
			}
		});
		
		decObj.btnDigit[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("7");
			}
		});
		
		decObj.btnDigit[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("8");
			}
		});
		
		decObj.btnDigit[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				digit("9");
			}
		});

	}
	private void digit(String d) {
		if (exp.contentEquals("0")){
			exp = d;	
		}
		else if (exp == ans.result) {
			exp = d;
		}
		else {
			exp = decObj.getLblExp() + d;
		}
		decObj.setLblExp(exp);
	}
	
	private void arithmethicOperation(String operation){
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
						exp = ans.result + operation;
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
}