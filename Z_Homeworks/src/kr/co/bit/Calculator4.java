package kr.co.bit;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;


public class Calculator4 extends Frame implements ActionListener {
	
	private Panel[] p = new Panel[8];
	private Button[] button = new Button[18];
	private String[] str = {"0", "1","2", "3", "4", "5", "6", "7", "8", "9", 
							"+", "-", "*", "/", ".", "=", "CE", "BACKSPACE"};
	private Label lb1, lb2; 
	private StringBuffer lb1sb, lb2sb;
	private double result;
	private int op; 
	
	private DecimalFormat df = new DecimalFormat("#,###.#####");
	
	public Calculator4() {
		setTitle("계산기");
		setBounds(700, 100, 300, 400);
		setVisible(true);
		setResizable(false);
		lb1 = new Label();
		lb2 = new Label("0");
		
		lb1sb = new StringBuffer();
		lb2sb = new StringBuffer();

		
		lb2.setFont(new Font("궁서", Font.BOLD, 15));
		
		lb1.setAlignment(Label.RIGHT);
		lb2.setAlignment(Label.RIGHT);
		
		for (int i = 0; i < p.length; i++) { p[i] = new Panel(); }
		for (int j = 0 ; j < button.length; j++) { button[j] = new Button(str[j]); }
		
		p[0].setLayout(new GridLayout(7, 1, 5, 5));
		p[1].setBackground(new Color(255, 200, 150));
		p[2].setBackground(new Color(255, 200, 150));
		
		p[1].add(lb1);
		p[1].setLayout(new GridLayout(1, 1, 5, 5));
		p[2].add(lb2);
		p[2].setLayout(new GridLayout(1, 1, 5, 5));
	
		for (int i = 3; i < 8; i++) {
			p[i].setLayout(new GridLayout(1, 4, 5, 5));
		}
		
	/*	int num = 0; int count = 3; 
		if(num < 18) {
			for (int j = num; j < num+4; j++) {
				p[count].add(button[j]);
			}
			count++;
			num+=4;
		}
		*/

		for (int j = 0; j < 4; j++) {
			p[3].add(button[j]);	
		}
		for (int j = 4; j < 8; j++) {	
			p[4].add(button[j]);					
		}
		for (int j = 8; j < 12; j++) {	
			p[5].add(button[j]);					
		}
		for (int j = 12; j < 16; j++) {
			p[6].add(button[j]);					
		}
		for (int j = 16; j < 18; j++) {	
			p[7].add(button[j]);					
		}
		for (int i = 1; i < p.length; i++) {
			p[0].add(p[i]);
		}
		
		this.add("Center", p[0]);		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);				
			}			
		});		
		for (int j = 0; j < button.length; j++) {
			button[j].addActionListener(this);			
		}
		
	}//constructor
	
// main ======================================================================================================
	public static void main(String[] args) {
		new Calculator4();
	
	}

@Override
public void actionPerformed(ActionEvent e) {
	
	if(e.getActionCommand() == "1" || e.getActionCommand() == "2" ||
		e.getActionCommand() == "3" || e.getActionCommand() == "4" ||
		e.getActionCommand() == "5" || e.getActionCommand() == "6" ||
		e.getActionCommand() == "7" || e.getActionCommand() == "8" ||
		e.getActionCommand() == "9" || e.getActionCommand() == "0") {
		
		if((lb2sb.toString()).equals("0")) lb2sb.delete(0, 1);		
		lb2sb.append(e.getActionCommand());
		lb2.setText(lb2sb+"");
	}
	
	if(e.getActionCommand() == "+")	{
		calc();
		lb1sb.append(lb2sb+"+");
		lb2sb.delete(0, lb2sb.length());
		lb2sb.append("0");
		
		op = '+';
		lb1.setText(lb1sb+"");
		lb2.setText(df.format(result));
	//	lb2.setText(lb2sb+"");
	} else if(e.getActionCommand() == "-") {
		calc();
		lb1sb.append(lb2sb+"-");
		lb2sb.delete(0, lb2sb.length());
		lb2sb.append("0");
		
		op = '-';
		lb1.setText(lb1sb+"");
		lb2.setText(df.format(result));
		
	} else if(e.getActionCommand() == "*") {
		calc();
		lb1sb.append(lb2sb+"*");
		lb2sb.delete(0, lb2sb.length());
		lb2sb.append("0");
		
		op = '*';
		lb1.setText(lb1sb+"");
		lb2.setText(df.format(result));
		
	} else if(e.getActionCommand() == "/") {
		calc();
		lb1sb.append(lb2sb+"/");
		lb2sb.delete(0, lb2sb.length());
		lb2sb.append("0");
		
		op = '/';
		lb1.setText(lb1sb+"");
		lb2.setText(df.format(result));
		
	} else if(e.getActionCommand() == "=") {
		calc();
		lb1sb.delete(0, lb1sb.length());
		op = '=';
		lb1.setText(lb1sb+"");
		lb2.setText(df.format(result));
		
	} else if(e.getActionCommand() == ".") {
		if(lb2sb.indexOf(".") == -1) lb2sb.append(".");
		else if(lb2sb.indexOf(".") == -1 && (lb2sb+"").equals("0")) lb2sb.append("0.");
		lb2.setText(lb2sb+"");
		
/*		if(lb2sb.indexOf(".") == -1) {
			lb2sb.append(".");
			lb2.setText(lb2sb+"");
		} */
		
	} else if(e.getActionCommand() == "CE") {
		lb1sb.delete(0, lb1sb.length());
		lb2sb.delete(0, lb2sb.length());
		
		lb2sb.append("0");
		
		lb1.setText("");
		lb2.setText(lb2sb+"");
		
	} else if(e.getActionCommand() == "BACKSPACE") {
		if(lb2sb.length() >= 1) {
			lb2sb.delete(lb2sb.length()-1, lb2sb.length());
			lb2.setText(lb2sb+"");			
		} else if(lb2sb.length() == 0) {
			lb2sb.delete(0, 1);
			lb2sb.append("0");
			lb2.setText(lb2sb+"");	
		}
	}
	
} // actionPerformed

	public void calc() {
		if(op == 0) {
			result = Double.parseDouble(lb2sb.toString());
		}else if(op == '+') result = result + Double.parseDouble(lb2sb.toString());
		else if(op == '-') result = result - Double.parseDouble(lb2sb.toString());
		else if(op == '*') result = result * Double.parseDouble(lb2sb.toString());
		else if(op == '/') result = result / Double.parseDouble(lb2sb.toString());
		else if(op == '=') result += result;
			
		
	
	}
	


	
}
	