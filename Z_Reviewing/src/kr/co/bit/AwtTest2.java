package kr.co.bit;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class AwtTest2 extends Frame{
	private Button[] numAop;
	private String[] num; 
	private Button ce, back;
	private Panel[] p0;
	private Panel p1, p2;
	
	public AwtTest2() {	
		setBounds(700, 100, 300, 400);
		setTitle("미니 계산기");
		setVisible(true);
		setBackground(Color.RED);
		
		
	
	}	
	
	
	public static void main(String[] args) {
		new AwtTest2();

	
	}
}
