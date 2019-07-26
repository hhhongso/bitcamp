import javax.swing.*;
import java.awt.*;


class ScoreForm extends JFrame {
	private JLabel idNumL, nameL, korL, engL, mathL;
	private JTextField idNumT, nameT, korT, engT, mathT;
	private JTextArea output; 
	private JButton addB, dispB, searchB, sortB, saveB, loadB; //�˻��� �й��˻�. // sort �������� �������� 
	private JPanel p0, p1, p2;

	public ScoreForm(){
		idNumL = new JLabel("�й�");		nameL = new JLabel("�̸�");		korL = new JLabel("����");		engL = new JLabel("����");		mathL = new JLabel("����");
		idNumT = new JTextField(10);		nameT = new JTextField(10); 		korT = new JTextField(10);		engT = new JTextField(10);		mathT = new JTextField(10);
		
		output = new JTextArea();
		
		addB = new JButton("�Է�");		dispB = new JButton("���");		searchB = new JButton("�й��˻�");		
		sortB = new JButton("����");		saveB = new JButton("��������");		loadB = new JButton("���Ͽ���");

		p0 = new JPanel(); //��ü 
		p1 = new JPanel(); //��ư
		p2 = new JPanel(); //�й�~~����


		JPanel[] p4 = new JPanel[5];
		for(int i = 0; i < p4.length; i++) {	p4[i] = new JPanel();	}
		p4[0].add(idNumL);	p4[0].add(idNumT);
		p4[1].add(nameL);	 p4[1].add(nameT);
		p4[2].add(korL);	 p4[2].add(korT);
		p4[3].add(engL);	 p4[3].add(engT);
		p4[4].add(mathL);	 p4[4].add(mathT);

	

		p0.setLayout(new GridLayout(1, 2, 5, 5));
		for(int i = 0; i < p4.length; i++) {	p4[i].setLayout(new FlowLayout(FlowLayout.CENTER));	}
		p2.setLayout(new GridLayout(5, 1, 10, 10));
//		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p1.add(addB);		p1.add(dispB);		p1.add(searchB);		p1.add(sortB);		p1.add(saveB);		p1.add(loadB);
	
		p2.add(p4[0]);
		p2.add(p4[1]);
		p2.add(p4[2]);
		p2.add(p4[3]);
		p2.add(p4[4]);		
		
		JScrollPane scroll = new JScrollPane(output);
		Container con = this.getContentPane();

		p0.add("West", p2);
		p0.add("East", scroll);

		con.add("South", p1);
		con.add("Center", p0);

		setBounds(700, 100, 400, 400);
		setResizable(false);
		setVisible(true);

	} //constructor
	
}
