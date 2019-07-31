package W0729;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ScoreMain extends JFrame implements ActionListener {
	private JLabel idNumL, nameL, korL, engL, mathL;
	private JTextField idNumT, nameT, korT, engT, mathT;
	private JTextArea output; 
	private JButton addB, dispB, searchB, sortB, saveB, loadB; 
	private JPanel p0, p1, p2;
	private ScoreImp imp;
	private ScoreMain sm;

	public ScoreMain(){
		idNumL = new JLabel("학번");			nameL = new JLabel("이름");			korL = new JLabel("국어");		
		engL = new JLabel("영어");			mathL = new JLabel("수학");
		
		idNumT = new JTextField(10);		nameT = new JTextField(10); 		korT = new JTextField(10);		
		engT = new JTextField(10);			mathT = new JTextField(10);
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		addB = new JButton("입력");		dispB = new JButton("출력");			searchB = new JButton("학번 검색");		
		sortB = new JButton("총점 정렬");		saveB = new JButton("파일 저장");		loadB = new JButton("파일 열기");

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
		
		p1.add(addB);		p1.add(dispB);		p1.add(searchB);		p1.add(sortB);		p1.add(saveB);		p1.add(loadB);
		p1.setLayout(new GridLayout(1, 6));
		p2.add(p4[0]);		p2.add(p4[1]);		p2.add(p4[2]);			p2.add(p4[3]);		p2.add(p4[4]);		
		
		Container con = this.getContentPane();

		p0.add("West", p2);
		p0.add("East", scroll);

		con.add("South", p1);
		con.add("Center", p0);
		
		imp = new ScoreImp();

		setBounds(700, 100, 550, 300);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} //constructor
	
	public JTextField getIdNumT() {
		return idNumT;
	}

	public JTextField getNameT() {
		return nameT;
	}

	public JTextField getKorT() {
		return korT;
	}
	
	public JTextField getEngT() {
		return engT;
	}

	public JTextField getMathT() {
		return mathT;
	}
	//=========================================================================================================================================	
	public void event(){
		addB.addActionListener(this);
		dispB.addActionListener(this);
		searchB.addActionListener(this);
		sortB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "입력") {		
			String idNum = idNumT.getText();
			String name = nameT.getText();
			int kor = Integer.parseInt(korT.getText());
			int eng = Integer.parseInt(engT.getText());
			int math = Integer.parseInt(mathT.getText());
			
			ScoreDTO dto = new ScoreDTO(idNum, name, kor, eng, math);
			dto.calc();
			imp.input(dto);
			
			idNumT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		} else if(e.getActionCommand() == "출력") {
			imp.disp(output);
			
		} else if(e.getActionCommand() == "학번 검색") {
			imp.search(output);
			
		} else if(e.getActionCommand() == "총점 정렬") {
			imp.sort();
			imp.disp(output);
			
		} else if(e.getActionCommand() == "파일 저장") {
			imp.save();
			
		} else if(e.getActionCommand() == "파일 열기") {
			imp.load();
			imp.disp(output);
		}	
	}
//=========================================================================================================================================	
	public static void main(String[] args) {
		new ScoreMain().event();
	}
}

