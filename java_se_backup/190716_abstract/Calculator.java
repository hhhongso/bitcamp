/*
Ŭ������: Claculator.java
private Label; �� 2�� (������upLabel, �Է�/��� dwLabel) 
private Button[] btn; ��ư �迭 18�� �г� 8��
������ ũ��� ���� (â �ִ�ȭX) => �Լ� �ʿ� 
�󺧻�, ���� ������� ����
�⺻������ �̿� 
*/

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class AwtTest extends Frame{
	private Button[] numAop;
	private String[] num; 
	private Button ce, back;
	private Panel p0;
	private Panel p1, p2;
	
	public AwtTest() {	
	  this.setResizable(false);
		setBounds(700, 100, 300, 400);
		setTitle("�̴� ����");
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		

// ��� �г�p0, �� 2��=================================================
//		Panel p0 = new Panel();
//		this.add(p0);
//		p0.setBackground(Color.DARK_GRAY);

		//���� �׳� �ø��� 
		Panel plb1 = new Panel();
		Label lb1 = new Label("upL");
		lb1.setBackground(Color.CYAN);
		Label lb2 = new Label("downL");
		lb2.setBackground(Color.CYAN);
		
		plb1.setLayout(new GridLayout(2, 1, 5, 5));
		plb1.add(lb1);
		plb1.add(lb2);
		this.add("North", plb1);
		
// back, CE ��ư=====================================================		
		//�� �г� plb2 �ȿ� p1, p2

		back = new Button("backspace");		
		ce = new Button("CE");
		
		p1 = new Panel();	
		p1.setLayout(new GridLayout(1, 2, 5, 5));
		p1.add(ce);
		p1.add(back);
//		p1.setPreferredSize(new Dimension(150,30));
		p1.setBounds(50, 70, 200, 50);
		this.add(p1);
		
		
		
// number, operator ��ư �迭 ========================================		
		num = new String[]{"7", "8", "9", "/",
				"4", "5", "6", "*",
				"1", "2", "3", "-",
				".", "0", "=", "+"};

		numAop = new Button[16];
		p2 = new Panel();
		p2.setLayout(new GridLayout(4, 4, 5, 5));
		for (int i = 0; i < num.length; i++) {
			numAop[i] = new Button(num[i]);
			p2.add(numAop[i]);
		}
	//	p2.setBounds(50, 120, 200, 200);
	//	p2.setPreferredSize(new Dimension(20, 20));

		this.add("South", p2);
	}
	
	public static void main(String[] args) {
		new AwtTest();
		
/*		String $name = "ȫ";
		int #age = 22;
		double *height = 43.8;
		boolean exist = 1; 
		
		12.45674561
		Math.round() �� ����Ͽ� �Ҽ��� 3°�ڸ����� ��Ÿ�����.(�ݿø�)
		*/
	}
	

}