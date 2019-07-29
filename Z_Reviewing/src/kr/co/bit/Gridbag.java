package kr.co.bit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gridbag extends JFrame {
	private JTextArea output;
	private JTextField inputT;	
	private JButton sendB;

	public Gridbag() {
		output = new JTextArea(); // 편집불가 
		
		JPanel p1 = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		p1.setLayout(gbl);
		
		inputT = new JTextField(15); // p1		
		gbc.weightx = 1.0; //여백 독점
		gbc.fill = GridBagConstraints.BOTH; // 여백 채우기 
		p1.add(inputT, gbc);
						
		sendB = new JButton("보내기"); // p1	
		gbc.weightx = 0.0;//여백 지정하지 않음 
		p1.add(sendB, gbc);
		
		gbl.setConstraints(p1, gbc);	
		this.add("South", p1);

		setResizable(true); 
		setBounds(700, 100, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Gridbag();
	}
}
