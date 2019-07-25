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

		
		//���̺� ���� 1��[���̵�, �̸�, �̸���, ��й�ȣ]�� ���� ���ͷ� ����. 
		vector = new Vector<String>();		
		vector.addElement("���̵�"); 		//addElement, add ���� ���
		vector.addElement("�̸�");
		vector.add("�̸���");
		vector.add("��ȭ��ȣ");
		
		//�� > �� ���� ������ �����. �� �ȿ� vector �� ����. 
		model = new DefaultTableModel(vector, 0){
			@Override
			public boolean isCellEditable(int row, int column){
				return (column != 0) ? true : false;
			}};

		//���̺� �����͸� �Ѱ��� �Ѱ��ش�. 
		for(PersonDTO dto : list) {
			Vector<String> vector2 = new Vector<String>();
			vector2.add(dto.getId());
			vector2.add(dto.getName());
			vector2.add(dto.getEmail());
			vector2.add(dto.getTel());

			model.addRow(vector2);
			//�𵨿� arrayList�� ���� ���� ���� > vector�� �������. 
		}

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		insertB = new JButton("�߰�");
		deleteB = new JButton("����");
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
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		//���̵� �ߺ� üũ 
		
/*		for(int i = 0; i < model.getRowCount(); i++){
			if(id.equals(model.getValueAt(i, 0)) {
				JOptionPane.showMessageDialog(this, "�ߺ��� ���̵��Դϴ� !");
				return;
			}
		} */

		for(PersonDTO dto : list) {
			if(dto.getId().equals(id)) {
				JOptionPane.showMessageDialog(this, "�ߺ��� ���̵��Դϴ� !");
				return; // insert�Լ��� ������.	break; �ݺ����� ������. 
			}
		}
		
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		String email = JOptionPane.showInputDialog(this, "�̸����� �Է��ϼ���");
		String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���");
		
		vector2.add(id);
		vector2.add(name);
		vector2.add(email);
		vector2.add(tel);
		model.addRow(vector2);
//		list.add(model);

		JOptionPane.showMessageDialog(this, "��� �Ϸ� !");
			
	}


	public void delete(){
		int sw = 0; 
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
	
	/*1. �ڿ������� �˻��ϱ�
	for(int i = model.getRowCount(); i > 0; i--){
		if(name.equals(model.getValueAt(i, 1))) {
			model.removeRow(i);	
		}
	}
	
	*/
		for(int i = 0; i < model.getRowCount(); i++){	
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);		
				i--; //���� �� �ε����� �ϳ� ���� > i�� �ϳ� �ٿ��ְ� >> for������ �ö󰡸� i++ �� �Ǵϱ� �ٽ� i=0���� ������ �� �ִ�. 
				sw = 1; 
			}
		}
	
		if(sw == 0) JOptionPane.showMessageDialog(this, "������ �̸��� �����ϴ� !");
		else JOptionPane.showMessageDialog(this, "�ش� �̸��� �����Ǿ����ϴ�.");
	}


	public static void main(String[] args) {
		new JTableEx2();
	}
}
