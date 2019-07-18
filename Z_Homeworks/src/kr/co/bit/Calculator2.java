package kr.co.bit;

/*
p0 = 전체 => grid 7,1
p1 = lb1 
p2 = lb2
p3 = back, ce
p4 = 789/
p5 = 456*
p6 = 123-
p7 = .0=+
*/			
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Calculator2 extends Frame implements ActionListener {
	private Button[] btn;
	private Panel[] p;
	private int[] num;
	private Label lb1, lb2;
	private String lb1Result, lb2Result;
	private String[] op = {"+", "-", "*", "/", ".", "=", "CE", "BACK"};
						//	10	11	 12	  13	14	15	  16	17

	
	public Calculator2() {		
		lb1Result = lb2Result = "";
		
		this.setResizable(false);
		setBounds(700, 100, 300, 400);
		setTitle("미니 계산기");
		setVisible(true);
		
		p = new Panel[8];
		btn = new Button[18];
		num = new int[10];
		
		lb1 = new Label("UPlabel");
		lb2 = new Label("DOWNlabel"); 

// 패널, 버튼, 라벨 배열 생성 =================================================================================================
		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel(); 
		} //패널 0~8 생성
		
		for (int i = 0; i < btn.length; i++) {
			if(i < 10) {
				num[i] = i;
				String a = num[i] + "";
				btn[i] = new Button(a);				
			} //버튼1~10까지 숫자 버튼 배열 생성
			else if (i >= 10) {
				String b = op[i-10];
				btn[i] = new Button(b);		
			} //버튼10~18까지 연산자, CE, Back버튼 배열 생성
		}
		
// 버튼, 라벨 배열 패널에 넣기 ==========================================================================================	
		p[0].setBackground(Color.DARK_GRAY);
		p[0].setLayout(new GridLayout(7, 1, 5, 5));
		this.add(p[0]);
		
		p[1].setBackground(new Color(252, 239, 237));
		p[1].setLayout(new GridLayout(1, 1, 5, 5));	
		p[1].add(lb1);
		
		p[2].setBackground(new Color(252, 239, 237));
		p[2].setLayout(new GridLayout(1, 1, 5, 5));
		p[2].add(lb2);		
		
		p[3].setLayout(new GridLayout(1, 2, 5, 5));
		p[3].add(btn[16]);
		p[3].add(btn[17]);
		btn[16].setBackground(new Color(255, 245, 173));
		btn[17].setBackground(new Color(173, 255, 247));		
		
		p[4].setLayout(new GridLayout(1, 4, 5, 5));
		p[4].add(btn[7]);
		p[4].add(btn[8]);
		p[4].add(btn[9]);
		p[4].add(btn[13]);
		
		p[5].setLayout(new GridLayout(1, 4, 5, 5));
		p[5].add(btn[4]);
		p[5].add(btn[5]);
		p[5].add(btn[6]);
		p[5].add(btn[12]);
		
		p[6].setLayout(new GridLayout(1, 4, 5, 5));
		p[6].add(btn[1]);
		p[6].add(btn[2]);
		p[6].add(btn[3]);
		p[6].add(btn[11]);
		
		p[7].setLayout(new GridLayout(1, 4, 5, 5));
		p[7].add(btn[14]);
		p[7].add(btn[0]);
		p[7].add(btn[15]);
		p[7].add(btn[10]);		
		
		for (int i = 1; i < p.length; i++) {
			p[0].add(p[i]);
		} //1~7 패널을 배경 패널 p0에 넣어주기
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

//버튼 이벤트 처리		
		for (int i = 0; i < btn.length; i++) {
			btn[i].addActionListener(this);		
		}
	} //생성자

//버튼 이벤트 오버라이드==================================================================================================	
@Override
public void actionPerformed(ActionEvent e) {
	for (int i = 0; i < btn.length; i++) {
		if(i < 10) {
			if(e.getSource() == btn[i]) lb2Result += i;
		} 
		else if(i >= 10 && i < 15) {
			String d = op[i-10];
			if(e.getSource() == btn[i]) {
				/*	if(lb2Result.charAt(lb2Result.length()-1) == '+' ||	lb2Result.charAt(lb2Result.length()) == '-' ||
						lb2Result.charAt(lb2Result.length()) == '*' ||	lb2Result.charAt(lb2Result.length()) == '/' ||
						lb2Result.charAt(lb2Result.length()) == '.') break;
				*/
				lb2Result += d;								
			}	
		}
		else if (i == 15) { // =
			if(e.getSource() == btn[15]) {
				//+ Integer.parseInt() 에 사용될 String을 int형으로 형변환 가능한 값으로 초기화 해준다. 
				//각 연산자에게 번호값을 주어야 하는데 
					
		//		String x = lb2Result.substring(0, Integer.parseInt());
		//		String y = lb2Result.substring(Integer.parseInt("+")+1);
				
		//		int plusResult = Integer.parseInt(x) + Integer.parseInt(y);
				
				
				//-
					
				//*
				
				// /

				
				lb1Result = lb2Result;
				lb2Result = "";
			}
		} 
		else if (i == 16) { //CE
			if(e.getSource() == btn[16]) lb1Result =lb2Result = "";
		}
		else if (i == 17) { //Backspace
			if(e.getSource() == btn[17]) lb2Result = lb2Result.substring(0, lb2Result.length()-1);			
		}
	}
	lb1.setText(lb1Result);
	lb2.setText(lb2Result);		
}	


// main ======================================================================================================
	public static void main(String[] args) {
		new Calculator2();
	}



	
}
	

