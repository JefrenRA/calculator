package com.tap.calculator;

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
	protected JButton[] btnDigit = new JButton[10];
	protected JButton[] btnFunction = new JButton[8];
	final protected JButton btnClearAll = new JButton("CLEAR");
	final protected JButton btnBckSpc = new JButton("<-");
	final protected JButton btnAdd = new JButton("+");
	final protected JButton btnSub = new JButton("-");
	final protected JButton btnMul = new JButton("*");
	final protected JButton btnDiv = new JButton("/");
	final protected JButton btnEqual = new JButton("=");
	final protected JButton btnDot = new JButton(".");
	
	final Font font = new Font("Century Gothic", Font.BOLD, 18);

	private void btnSet() {
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

	private void objectBounds() {
		btnClearAll.setBounds(3, 80, 121, 60);
		btnBckSpc.setBounds(125, 80, 60, 60);
		btnDot.setBounds(186, 80, 60, 60);
		btnDigit[7].setBounds(3, 141, 60, 60);
		btnDigit[4].setBounds(3, 202, 60, 60);
		btnDigit[1].setBounds(3, 263, 60, 60);
		btnDigit[8].setBounds(64, 141, 60, 60);
		btnDigit[5].setBounds(64, 202, 60, 60);
		btnDigit[2].setBounds(64, 263, 60, 60);
		btnDigit[9].setBounds(125, 141, 60, 60);
		btnDigit[6].setBounds(125, 202, 60, 60);
		btnDigit[3].setBounds(125, 263, 60, 60);
		btnDigit[0].setBounds(3, 324, 60, 60);
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
			btnDigit[i].setFont(font);
			calFrame.add(btnDigit[i]);
		}

		for (int j = 0; j < 8; j++) {
			btnFunction[j].setFont(font);
			calFrame.add(btnFunction[j]);
		}

		calFrame.setVisible(true);
	}
	
	public String getLblExp() {
		return lblExp.getText();
	}
	

	public void setLblExp(String strExp) {
		this.lblExp.setText(strExp);
	}
}
