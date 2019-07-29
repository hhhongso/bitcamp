import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class ScoreForm extends JFrame implements ActionListener {
	private JLabel idNumL, nameL, korL, engL, mathL;
	private JTextField idNumT, nameT, korT, engT, mathT;
	private JTextArea output; 
	private JButton addB, dispB, searchB, sortB, saveB, loadB; 
	private JPanel p0, p1, p2;
	private ScoreImpl scImp;

	public ScoreForm(){
		idNumL = new JLabel("학번");			nameL = new JLabel("이름");			korL = new JLabel("국어");		engL = new JLabel("영어");		mathL = new JLabel("수학");
		idNumT = new JTextField(10);		nameT = new JTextField(10); 		korT = new JTextField(10);		engT = new JTextField(10);		mathT = new JTextField(10);
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		addB = new JButton("입력");		dispB = new JButton("출력");			searchB = new JButton("학번검색");		
		sortB = new JButton("순위");		saveB = new JButton("파일저장");		loadB = new JButton("파일열기");

		p0 = new JPanel(); //전체 
		p1 = new JPanel(); //버튼
		p2 = new JPanel(); //학번~~수학

		JPanel[] p4 = new JPanel[5];
		for(int i = 0; i < p4.length; i++) {
			p4[i] = new JPanel();
			p4[i].setLayout(new FlowLayout(FlowLayout.CENTER));
		}
		p4[0].add(idNumL);	 p4[0].add(idNumT);
		p4[1].add(nameL);	 p4[1].add(nameT);
		p4[2].add(korL);	 p4[2].add(korT);
		p4[3].add(engL);	 p4[3].add(engT);
		p4[4].add(mathL);	 p4[4].add(mathT);

		p0.setLayout(new GridLayout(1, 2, 5, 5));
		p2.setLayout(new GridLayout(5, 1, 10, 10));
//		p2.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		p1.add(addB);		p1.add(dispB);		p1.add(searchB);		p1.add(sortB);		p1.add(saveB);		p1.add(loadB);
		p2.add(p4[0]);		p2.add(p4[1]);		p2.add(p4[2]);			p2.add(p4[3]);		p2.add(p4[4]);		
		
		Container con = this.getContentPane();

		p0.add("West", p2);
		p0.add("East", scroll);

		con.add("South", p1);
		con.add("Center", p0);

		setBounds(700, 100, 500, 300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		scImp = new ScoreImpl();

	} //constructor
	



// =====================================================================
	public void event(){
		addB.addActionListener(this);
		dispB.addActionListener(this);
		searchB.addActionListener(this);
		sortB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addB) { 
			//데이터 받기
			String idNum = idNumT.getText();
			String name = nameT.getText();
			int kor = Integer.parseInt(korT.getText());
			int eng = Integer.parseInt(engT.getText());
			int math = Integer.parseInt(mathT.getText());

			ScoreDTO dto = new ScoreDTO(idNum, name, kor, eng, math);
			dto.calc();	
			scImp.input(dto); 
			JOptionPane.showMessageDialog(this, "등록 완료!");
			
			idNumT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		}
		else if(e.getSource() == dispB) {
			scImp.print(output); //TextArea 를 넘김 
		}
		else if(e.getSource() == searchB) { //검색은 학번검색.
			scImp.search(output);
		}
		else if(e.getSource() == sortB) {  // sort 총점으로 내림차순 
			scImp.sort();
			scImp.print(output);
		}
		else if(e.getSource() == saveB) { 		
			scImp.save();
		}
		else if(e.getSource() == loadB) {
			scImp.load();
			scImp.print(output);
		}
	}
}
