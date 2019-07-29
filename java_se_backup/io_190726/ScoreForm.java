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
		idNumL = new JLabel("�й�");			nameL = new JLabel("�̸�");			korL = new JLabel("����");		engL = new JLabel("����");		mathL = new JLabel("����");
		idNumT = new JTextField(10);		nameT = new JTextField(10); 		korT = new JTextField(10);		engT = new JTextField(10);		mathT = new JTextField(10);
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		addB = new JButton("�Է�");		dispB = new JButton("���");			searchB = new JButton("�й��˻�");		
		sortB = new JButton("����");		saveB = new JButton("��������");		loadB = new JButton("���Ͽ���");

		p0 = new JPanel(); //��ü 
		p1 = new JPanel(); //��ư
		p2 = new JPanel(); //�й�~~����

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
			//������ �ޱ�
			String idNum = idNumT.getText();
			String name = nameT.getText();
			int kor = Integer.parseInt(korT.getText());
			int eng = Integer.parseInt(engT.getText());
			int math = Integer.parseInt(mathT.getText());

			ScoreDTO dto = new ScoreDTO(idNum, name, kor, eng, math);
			dto.calc();	
			scImp.input(dto); 
			JOptionPane.showMessageDialog(this, "��� �Ϸ�!");
			
			idNumT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		}
		else if(e.getSource() == dispB) {
			scImp.print(output); //TextArea �� �ѱ� 
		}
		else if(e.getSource() == searchB) { //�˻��� �й��˻�.
			scImp.search(output);
		}
		else if(e.getSource() == sortB) {  // sort �������� �������� 
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
