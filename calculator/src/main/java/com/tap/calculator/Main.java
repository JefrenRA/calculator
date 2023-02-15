package com.tap.calculator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("restriction")
public class Main {
	//Declaration of objects
	JPanel panelExp = new JPanel();
	JPanel panelSet1 = new JPanel();
	JPanel panelSet2 = new JPanel();
	JPanel panelSet3 = new JPanel();
	JPanel panelSet4 = new JPanel();
	JPanel panelSet5 = new JPanel();
	JFrame Calframe = new JFrame();
	JLabel lblExp = new JLabel();
	JButton btnClearAll = new JButton("CLEAR");
	JButton btnBackSpace = new JButton("X");
	JButton btnAdd = new JButton("+");
	JButton btnSub= new JButton("-");
	JButton btnMul = new JButton("*");
	JButton btnDiv = new JButton("/");
	JButton btnEqual = new JButton("=");
	JButton btn0 = new JButton("0");
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btnDot = new JButton(".");	
	String Exp = "";
	
	public Main() {
		lblExp.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		lblExp.setOpaque(true);
		lblExp.setBackground(Color.BLUE);
		lblExp.setForeground(Color.WHITE);
		lblExp.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		Dimension dim = new Dimension(50,50);
		btnDot.setPreferredSize(dim);
		btn0.setPreferredSize(dim);
		btn1.setPreferredSize(dim);
		btn2.setPreferredSize(dim);
		btn3.setPreferredSize(dim);
		btn4.setPreferredSize(dim);
		btn5.setPreferredSize(dim);
		btn6.setPreferredSize(dim);
		btn6.setPreferredSize(dim);
		btn7.setPreferredSize(dim);
		btn8.setPreferredSize(dim);
		btn9.setPreferredSize(dim);
		btnClearAll.setPreferredSize(new Dimension(105,50));
		btnBackSpace.setPreferredSize(dim);
		btnAdd.setPreferredSize(dim);
		btnSub.setPreferredSize(dim);
		btnMul.setPreferredSize(dim);
		btnDiv.setPreferredSize(dim);
		btnEqual.setPreferredSize(new Dimension(105,50));
		
		panelExp.setLayout(new BorderLayout());
		panelExp.setBackground(Color.BLUE);
		panelExp.add(lblExp, BorderLayout.EAST);
		
		FlowLayout panLay= new FlowLayout();
		panelSet1.setLayout(panLay);
		panelSet1.add(btnClearAll);
		panelSet1.add(btnBackSpace);
		panelSet1.add(btnDiv);

		panelSet2.setLayout(panLay);
		panelSet2.add(btn7);
		panelSet2.add(btn8);
		panelSet2.add(btn9);
		panelSet2.add(btnMul);
		
		panelSet3.setLayout(panLay);
		panelSet3.add(btn4);
		panelSet3.add(btn5);
		panelSet3.add(btn6);
		panelSet3.add(btnSub);
		
		panelSet4.setLayout(panLay);
		panelSet4.add(btn1);
		panelSet4.add(btn2);
		panelSet4.add(btn3);
		panelSet4.add(btnAdd);
		
		panelSet5.setLayout(panLay);
		panelSet5.add(btn0);
		panelSet5.add(btnDot);
		panelSet5.add(btnEqual);
		
		Calframe.setPreferredSize(new Dimension (250, 400));
		Calframe.add(panelExp);
		Calframe.add(panelSet1);
		Calframe.add(panelSet2);
		Calframe.add(panelSet3);
		Calframe.add(panelSet4);
		Calframe.add(panelSet5);
		Calframe.setLayout(new GridLayout(0,1));
		Calframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calframe.setTitle("Day 2 Practice Java Code");
		Calframe.pack();
		Calframe.setVisible(true);
		btnClick();
	}
	
	public void btnClick() {
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblExp.setText("");
			}
		});
		
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Equate();
			}
		});
		
		
		btnBackSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int ExpLen = Exp.length();
				Exp = Exp.substring(0, ExpLen-1);
				lblExp.setText(Exp);
			}
		});
		
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit(".");
			}
		});
		
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("0");
			}
		});
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("1");
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("2");
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("3");
			}
		});
		
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("4");
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("5");
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("6");
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("7");
			}
		});
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("8");
			}
		});
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Digit("9");
			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arithmethicOperation("+");
			}
		});
		
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arithmethicOperation("-");
			}
		});
		
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arithmethicOperation("*");
			}
		});
		
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arithmethicOperation("/");
			}
		});
	}
	
	//Code for Numbers in Expression
	public void Digit(String d) {
		if (Exp == "") {
			Exp = d;	
		}
		else {
			Exp = lblExp.getText() + d;
		}
		lblExp.setText(Exp);
	}
	
	//Code for Arithmetic Operation in Expression 
	public void arithmethicOperation(String Operation){
		if (Exp != "") {
			int ExpLen = Exp.length();
			if (Exp.endsWith("+") || Exp.endsWith("-") || Exp.endsWith("*") || Exp.endsWith("/")) {			
				Exp = Exp.substring(0, ExpLen-1) + Operation;
			}
			else {
				Exp = Exp + Operation;
			}
			lblExp.setText(Exp);
		}
	}
	
	//Code for getting the result of the Expression
	public void Equate() {
		ScriptEngineManager scptEngMngr = new ScriptEngineManager();
		ScriptEngine scptEng = scptEngMngr.getEngineByName("Nashorn");
		
		if (Exp.endsWith("+") || Exp.endsWith("-") || Exp.endsWith("*") || Exp.endsWith("/")) {			
			Exp = Exp.substring(0, Exp.length()-1);
			lblExp.setText(Exp);
		}
		
		try {
			Object Result = scptEng.eval(Exp);
			lblExp.setText("= " + Result);
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
