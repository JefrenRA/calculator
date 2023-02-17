package com.tap.calculator;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DeclareObjects {
	private JFrame calFrame = new JFrame("Simple Calculator");
	protected JLabel lblExp = new JLabel();
	protected JButton[] btnDigit = new JButton[10];
	protected JButton[] btnFunction = new JButton[8];
	protected JButton btnAdd, btnSub, btnMul, btnDiv, btnClearAll, btnBckSpc, btnDot, btnEqual;
	
	Font font = new Font("Century Gothic", Font.BOLD, 18);

	private void btnSet() {
		btnClearAll = new JButton("CLEAR");
		btnBckSpc = new JButton("<-");
		btnAdd = new JButton("+");
		btnSub = new JButton("-");
		btnMul = new JButton("*");
		btnDiv = new JButton("/");
		btnEqual = new JButton("=");
		btnDot = new JButton(".");

		btnFunction[0] = btnClearAll;
		btnFunction[1] = btnBckSpc;
		btnFunction[2] = btnAdd;
		btnFunction[3] = btnSub;
		btnFunction[4] = btnMul;
		btnFunction[5] = btnDiv;
		btnFunction[6] = btnEqual;
		btnFunction[7] = btnDot;
		

		int indexNum = 0;
		while (indexNum < 10) {
			btnDigit[indexNum] = new JButton(String.valueOf(indexNum));
			indexNum++;
		}
	}

	private void objectBounds() {
		btnClearAll.setBounds(3, 80, 121, 60);
		btnBckSpc.setBounds(125, 80, 60, 60);
		btnDot.setBounds(186, 80, 60, 60);
		btnDigit[7].setBounds(3, 140, 60, 60);
		btnDigit[4].setBounds(3, 202, 60, 60);
		btnDigit[1].setBounds(3, 263, 60, 60);
		btnDigit[8].setBounds(64, 140, 60, 60);
		btnDigit[5].setBounds(64, 202, 60, 60);
		btnDigit[2].setBounds(64, 263, 60, 60);
		btnDigit[9].setBounds(125, 141, 60, 60);
		btnDigit[6].setBounds(125, 202, 60, 60);
		btnDigit[3].setBounds(125, 263, 60, 60);
		btnDigit[0].setBounds(3, 323, 60, 60);
		btnDiv.setBounds(186, 141, 60, 60);
		btnMul.setBounds(186, 202, 60, 60);
		btnSub.setBounds(186, 263, 60, 60);
		btnAdd.setBounds(186, 323, 60, 60);
		btnEqual.setBounds(64, 323, 121, 60);
		lblExp.setBounds(0, 0, 300, 80);
	}

	public void setUpObjects() {
		lblExp.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
		lblExp.setOpaque(true);
		lblExp.setBackground(Color.BLUE);
		lblExp.setForeground(Color.WHITE);
		lblExp.setFont(new Font("Century Gothic", Font.BOLD, 24));

		calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calFrame.setSize(265, 430);
		calFrame.setLayout(null);
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
}
