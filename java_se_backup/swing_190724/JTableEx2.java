import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

class JTableEx2 extends JFrame implements ActionListener {
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private JTable table; 
	private JButton insertB, deleteB;

	public JTableEx2(){
		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("id1", "aaa", "maruchi@naver.com", "010-1234-1234"));
		list.add(new PersonDTO("id2", "bbb", "arachi@hotmail.com", "010-4567-7890"));
		list.add(new PersonDTO("id3", "ccc", "arachi@hotmail.com", "010-4567-7890"));
		list.add(new PersonDTO("id4", "ddd", "arachi@hotmail.com", "010-4567-7890"));
		list.add(new PersonDTO("id5", "eee", "arachi@hotmail.com", "010-4567-7890"));
		list.add(new PersonDTO("id6", "bbb", "arachi@hotmail.com", "010-4567-7890"));

		
		//테이블 안의 1줄[아이디, 이름, 이메일, 비밀번호]을 각각 벡터로 설정. 
		vector = new Vector<String>();		
		vector.addElement("아이디"); 		//addElement, add 같은 기능
		vector.addElement("이름");
		vector.add("이메일");
		vector.add("전화번호");
		
		//모델 > 빈 행의 갯수를 만든다. 모델 안에 vector 가 들어간다. 
		model = new DefaultTableModel(vector, 0){
			@Override
			public boolean isCellEditable(int row, int column){
				return (column != 0) ? true : false;
			}};

		//테이블에 데이터를 한개씩 넘겨준다. 
		for(PersonDTO dto : list) {
			Vector<String> vector2 = new Vector<String>();
			vector2.add(dto.getId());
			vector2.add(dto.getName());
			vector2.add(dto.getEmail());
			vector2.add(dto.getTel());

			model.addRow(vector2);
			//모델에 arrayList를 더할 수가 없어 > vector로 만들었음. 
		}

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		insertB = new JButton("추가");
		deleteB = new JButton("삭제");
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		p.add(insertB); 
		p.add(deleteB);

		getContentPane().add("Center", scroll);	
		getContentPane().add("South", p);
		
		setBounds(700, 100, 500, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		insertB.addActionListener(this);
		deleteB.addActionListener(this);
	}//constructor

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == insertB) { insert(); }
		else if(e.getSource() == deleteB) { delete(); }
	}

	public void insert(){
		Vector<String> vector2 = new Vector<String>();
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		//아이디 중복 체크 
		
/*		for(int i = 0; i < model.getRowCount(); i++){
			if(id.equals(model.getValueAt(i, 0)) {
				JOptionPane.showMessageDialog(this, "중복된 아이디입니다 !");
				return;
			}
		} */

		for(PersonDTO dto : list) {
			if(dto.getId().equals(id)) {
				JOptionPane.showMessageDialog(this, "중복된 아이디입니다 !");
				return; // insert함수를 나간다.	break; 반복문을 나간다. 
			}
		}
		
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		String email = JOptionPane.showInputDialog(this, "이메일을 입력하세요");
		String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요");
		
		vector2.add(id);
		vector2.add(name);
		vector2.add(email);
		vector2.add(tel);
		model.addRow(vector2);
//		list.add(model);

		JOptionPane.showMessageDialog(this, "등록 완료 !");
			
	}


	public void delete(){
		int sw = 0; 
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
	
	/*1. 뒤에서부터 검색하기
	for(int i = model.getRowCount(); i > 0; i--){
		if(name.equals(model.getValueAt(i, 1))) {
			model.removeRow(i);	
		}
	}
	
	*/
		for(int i = 0; i < model.getRowCount(); i++){	
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);		
				i--; //삭제 후 인덱스가 하나 빠짐 > i도 하나 줄여주고 >> for문으로 올라가면 i++ 이 되니까 다시 i=0부터 시작할 수 있다. 
				sw = 1; 
			}
		}
	
		if(sw == 0) JOptionPane.showMessageDialog(this, "삭제할 이름이 없습니다 !");
		else JOptionPane.showMessageDialog(this, "해당 이름이 삭제되었습니다.");
	}


	public static void main(String[] args) {
		new JTableEx2();
	}
}
