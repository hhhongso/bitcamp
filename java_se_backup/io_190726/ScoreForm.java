import javax.swing.*;
import java.awt.*;


class ScoreForm extends JFrame {
	private JLabel idNumL, nameL, korL, engL, mathL;
	private JTextField idNumT, nameT, korT, engT, mathT;
	private JTextArea output; 
	private JButton addB, dispB, searchB, sortB, saveB, loadB; //검색은 학번검색. // sort 총점으로 내림차순 
	private JPanel p0, p1, p2;

	public ScoreForm(){
		idNumL = new JLabel("학번");		nameL = new JLabel("이름");		korL = new JLabel("국어");		engL = new JLabel("영어");		mathL = new JLabel("수학");
		idNumT = new JTextField(10);		nameT = new JTextField(10); 		korT = new JTextField(10);		engT = new JTextField(10);		mathT = new JTextField(10);
		
		output = new JTextArea();
		
		addB = new JButton("입력");		dispB = new JButton("출력");		searchB = new JButton("학번검색");		
		sortB = new JButton("순위");		saveB = new JButton("파일저장");		loadB = new JButton("파일열기");

		p0 = new JPanel(); //전체 
		p1 = new JPanel(); //버튼
		p2 = new JPanel(); //학번~~수학


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
