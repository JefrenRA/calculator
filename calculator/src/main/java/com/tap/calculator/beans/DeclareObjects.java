package com.tap.calculator.beans;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class DeclareObjects {
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
	
	private void btnSet() {
		getBtnFunction()[0] = btnClearAll;
		getBtnFunction()[1] = btnBckSpc;
		getBtnFunction()[2] = btnAdd;
		getBtnFunction()[3] = btnSub;
		getBtnFunction()[4] = btnMul;
		getBtnFunction()[5] = btnDiv;
		getBtnFunction()[6] = btnEqual;
		getBtnFunction()[7] = btnDot;
		
		int indexFunc= 0;
		while (indexFunc < 8) {
			getBtnFunction()[indexFunc].setFocusPainted(false);
			getBtnFunction()[indexFunc].setBorderPainted(false);
			getBtnFunction()[indexFunc].setBackground(new Color(222,206,190));
			getBtnFunction()[indexFunc].setForeground(Color.BLACK);
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

	private void objectBounds() {
		btnClearAll.setBounds(3, 80, 121, 60);
		btnBckSpc.setBounds(125, 80, 60, 60);
		btnDot.setBounds(186, 80, 60, 60);
		getBtnDigit()[7].setBounds(3, 141, 60, 60);
		getBtnDigit()[4].setBounds(3, 202, 60, 60);
		getBtnDigit()[1].setBounds(3, 263, 60, 60);
		getBtnDigit()[8].setBounds(64, 141, 60, 60);
		getBtnDigit()[5].setBounds(64, 202, 60, 60);
		getBtnDigit()[2].setBounds(64, 263, 60, 60);
		getBtnDigit()[9].setBounds(125, 141, 60, 60);
		getBtnDigit()[6].setBounds(125, 202, 60, 60);
		getBtnDigit()[3].setBounds(125, 263, 60, 60);
		getBtnDigit()[0].setBounds(3, 324, 60, 60);
		btnDiv.setBounds(186, 141, 60, 60);
		btnMul.setBounds(186, 202, 60, 60);
		btnSub.setBounds(186, 263, 60, 60);
		btnAdd.setBounds(186, 324, 60, 60);
		btnEqual.setBounds(64, 324, 121, 60);
		lblExp.setBounds(3, 0, 243, 80);
	}

	public void setUpObjects() {
		lblExp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblExp.setOpaque(true);
		lblExp.setBackground(new Color(245,243,242));
		lblExp.setForeground(Color.BLACK);
		lblExp.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblExp.setBorder(BorderFactory.createLineBorder(new Color(222,206,190), 2));

		calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calFrame.setSize(265, 425);
		calFrame.setLayout(null);
		calFrame.setLocationRelativeTo(null);
		calFrame.add(lblExp);

		btnSet();
		objectBounds();

		for (int i = 0; i < 10; i++) {
			getBtnDigit()[i].setFont(font);
			calFrame.add(getBtnDigit()[i]);
		}

		for (int j = 0; j < 8; j++) {
			getBtnFunction()[j].setFont(font);
			calFrame.add(getBtnFunction()[j]);
		}

		calFrame.setVisible(true);
	}
	
	public String getLblExp() {
		return lblExp.getText();
	}
	

	public void setLblExp(String strExp) {
		this.lblExp.setText(strExp);
	}

	public JButton[] getBtnDigit() {
		return btnDigit;
	}

	public void setBtnDigit(JButton[] btnDigit) {
		this.btnDigit = btnDigit;
	}

	public JButton[] getBtnFunction() {
		return btnFunction;
	}

	public void setBtnFunction(JButton[] btnFunction) {
		this.btnFunction = btnFunction;
	}
}
