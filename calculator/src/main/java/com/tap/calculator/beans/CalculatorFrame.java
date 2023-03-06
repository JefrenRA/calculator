package com.tap.calculator.beans;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.tap.calculator.gateway.ops.impl.ArithmeticOperations;


public class CalculatorFrame implements ActionListener{
	//Initialization of Objects
	private ArithmeticOperations arithmeticOps = new ArithmeticOperations();
	private JFrame calFrame = new JFrame("Simple Calculator");
	private JLabel lblExp = new JLabel();
	private JButton[] btnDigit = new JButton[10];
	private JButton[] btnFunction = new JButton[8];
	final private JButton btnClearAll = new JButton("CLEAR");
	final private JButton btnBckSpc = new JButton("<-");
	final private JButton btnAdd = new JButton("+");
	final private JButton btnSub = new JButton("-");
	final private JButton btnMul = new JButton("*");
	final private JButton btnDiv = new JButton("/");
	final private JButton btnEqual = new JButton("=");
	final private JButton btnDot = new JButton(".");
	
	final Font font = new Font("Century Gothic", Font.BOLD, 18);
	
	//label expression getter
	public String getLblExp() {
		return lblExp.getText();
	}
	
	//label expression setter
	public void setLblExp(String strExp) {
		this.lblExp.setText(strExp);
	}

	public void display() {
		setUpObjectProperties();
		setUpButtonAction();
	}
	
	private void setUpButton() {
		btnFunction[0] = btnClearAll;
		btnFunction[1] = btnBckSpc;
		btnFunction[2] = btnAdd;
		btnFunction[3] = btnSub;
		btnFunction[4] = btnMul;
		btnFunction[5] = btnDiv;
		btnFunction[6] = btnEqual;
		btnFunction[7] = btnDot;
		
		int indexFunc= 0;
		while (indexFunc < 8) {
			btnFunction[indexFunc].setFocusPainted(false);
			btnFunction[indexFunc].setBorderPainted(false);
			btnFunction[indexFunc].setBackground(new Color(222,206,190));
			btnFunction[indexFunc].setForeground(Color.BLACK);
			indexFunc++;
		}

		int indexNum = 0;
		while (indexNum < 10) {
			btnDigit[indexNum] = new JButton(String.valueOf(indexNum));
			btnDigit[indexNum].setBackground(new Color(199,185,171));
			btnDigit[indexNum].setForeground(Color.BLACK);
			btnDigit[indexNum].setFocusPainted(false);
			btnDigit[indexNum].setBorderPainted(false);
			indexNum++;
		}
	}

	//setting size and position of the Objects
	private void setObjectBounds() {
		btnClearAll.setBounds(6, 86, 121, 60);
		btnBckSpc.setBounds(128, 86, 60, 60);
		btnDot.setBounds(189, 86, 60, 60);
		btnDigit[7].setBounds(6, 147, 60, 60);
		btnDigit[4].setBounds(6, 208, 60, 60);
		btnDigit[1].setBounds(6, 269, 60, 60);
		btnDigit[8].setBounds(67, 147, 60, 60);
		btnDigit[5].setBounds(67, 208, 60, 60);
		btnDigit[2].setBounds(67, 269, 60, 60);
		btnDigit[9].setBounds(128, 147, 60, 60);
		btnDigit[6].setBounds(128, 208, 60, 60);
		btnDigit[3].setBounds(128, 269, 60, 60);
		btnDigit[0].setBounds(6, 330, 60, 60);
		btnDiv.setBounds(189, 147, 60, 60);
		btnMul.setBounds(189, 208, 60, 60);
		btnSub.setBounds(189, 269, 60, 60);
		btnAdd.setBounds(189, 330, 60, 60);
		btnEqual.setBounds(67, 330, 121, 60);
		lblExp.setBounds(6, 3, 243, 80);
	}
	
	//setting object properties
	public void setUpObjectProperties() {
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setOpaque(true);
		lblExp.setBackground(new Color(245,243,242));
		lblExp.setForeground(Color.BLACK);
		lblExp.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblExp.setBorder(BorderFactory.createLineBorder(new Color(222,206,190), 2));
		
		calFrame.setSize(260, 425);
		calFrame.setResizable(false);
		calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calFrame.setLayout(null);
		calFrame.setLocationRelativeTo(null);
		calFrame.add(lblExp);

		setUpButton();
		setObjectBounds();

		for (int i = 0; i < 10; i++) {
			btnDigit[i].setFont(font);
			calFrame.add(btnDigit[i]);
		}

		for (int j = 0; j < 8; j++) {
			btnFunction[j].setFont(font);
			calFrame.add(btnFunction[j]);
		}
		
		calFrame.setVisible(true);
	}
	
	public void setDigit(String d) {
		if (getLblExp().contentEquals("0")){
			setLblExp(d);	
		}
		else if (getLblExp() == arithmeticOps.getResult()) {
			setLblExp(d);
		}
		else {
			setLblExp(getLblExp() + d);
		}
	}
	
	//method to filter inputs in assigning arithmetic operation
	public void setArithmethicOperation(String operation){
		try {
			if (getLblExp().startsWith("=")) {
				setLblExp(getLblExp().substring(1));
			}
			
			if (!(getLblExp().contentEquals(""))){
				if (!(getLblExp().contentEquals("."))) {
					if (!(getLblExp().endsWith("."))) {
						int expLen = getLblExp().length();
						if (getLblExp().contains("+") || getLblExp().contains("-") || getLblExp().contains("*") || getLblExp().contains("/")) {
							if(getLblExp().endsWith("+") || getLblExp().endsWith("-") || getLblExp().endsWith("*") || getLblExp().endsWith("/")) {
								setLblExp(getLblExp().substring(0, expLen-1) + operation);
							}
							else if(getLblExp().startsWith("-")) {
								setLblExp(arithmeticOps.getResult()+operation);
							}
							else {
								arithmeticOps.solveExpression(getLblExp());
								setLblExp(arithmeticOps.getResult()+operation);
							}
						}
						else {
							setLblExp(getLblExp()+operation);
						}
					}
					else {
						int expLen = getLblExp().length();
						setLblExp(getLblExp().substring(0, expLen-1));
						
					}
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//method for filtering dot(.) inputs
	public void filterDot() {
		if(getLblExp().contentEquals("")) {
			setDigit("0.");
		}
		else if(getLblExp().endsWith("+") || getLblExp().endsWith("-") || getLblExp().endsWith("*") || getLblExp().endsWith("/")) {
			setDigit("0.");
		}
		else if((!(getLblExp().contains(".")))){
			setDigit(".");
		}
	}
	
	//method to ignore backspace action once the length of the expression is 0
	public void doBckSpc() {
		try {
			int expLen = getLblExp().length();
			if (!(expLen == 0)) {
				setLblExp(getLblExp().substring(0, expLen-1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//method to get the result of the expression
	public void equateExpression() {
		if (!(getLblExp().isEmpty())) {
			if (getLblExp().contains("+") || getLblExp().contains("-") || getLblExp().contains("*") || getLblExp().contains("/")) {
				if (!(getLblExp().contains("="))){
					try {
						arithmeticOps.solveExpression(getLblExp());
						setLblExp(arithmeticOps.getResult());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//set up action listener to buttons
	public void setUpButtonAction(){
		for (int i = 0; i < 10; i++) {
			btnDigit[i].addActionListener(this);
		}
		
		for (int i = 0; i < 8; i++) {
			btnFunction[i].addActionListener(this);
		}
	}
	
	//button action perform when clicked
	public void actionPerformed(ActionEvent btn) {
		if (btn.getSource()== btnClearAll) setLblExp("");
		if (btn.getSource()== btnEqual) equateExpression();
		if (btn.getSource()== btnBckSpc) doBckSpc();
		if (btn.getSource()== btnDot) filterDot();
		if (btn.getSource()== btnAdd) setArithmethicOperation("+");
		if (btn.getSource()== btnSub) setArithmethicOperation("-");
		if (btn.getSource()== btnMul) setArithmethicOperation("*");
		if (btn.getSource()== btnDiv) setArithmethicOperation("/");
		
		for (int i = 0; i < 10; i++) {
			if (btn.getSource()== btnDigit[i]) setDigit(String.valueOf(i));
		}
	}
}
