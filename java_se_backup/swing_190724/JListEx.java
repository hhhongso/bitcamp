import java.awt.*; 
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class JListEx extends JFrame {

	public JListEx(){
		super("JList Test");
		setLayout(new FlowLayout());
		String[] listData = {"a", "b", "c", "d", "e"};
		JList<String> list1 = new JList<String>(listData);
		list1.setSelectedIndex(0);

		//��������(View): �־��ٰ� ���ٰ��ϴ� �����۾�. �����ִ� ��.  
		//arrayList(Collection) ������ add, remove �� ���� ������, �Ϻ� ���� ����� ���� >> �� ����� ���ְ� �������ִ°� DefaultListModel
		DefaultListModel<String> model = new DefaultListModel<String>(); 
		JList<String> list2 = new JList<String>(model);	
		model.addElement("���");
		model.addElement("����");
		model.addElement("�ٳ���");
		model.addElement("����");
		list2.setSelectedIndex(1);

		//Vector: �������� ����. �÷���. ����ִ� ���� 
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("�౸");	vListData.add("����");
		vListData.add("�߱�");	vListData.add("�±ǵ�");
		vListData.add("��");	vListData.add("����");
		vListData.add("�豸");	vListData.add("��Ű");
		vListData.add("Ź��");	vListData.add("��Ű");
		list3.setSelectedIndex(6);

		class Student{
			String id; 
			String name; 
			String dept; 

			public Student(String id, String name, String dept){
				this.id = id; 
				this.name = name; 
				this.dept = dept;
			}

			public String toString(){
				return name;
			}
		}

		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		model2.addElement(new Student("2011", "�̸�1", "�μ�1"));
		model2.addElement(new Student("2012", "�̸�2", "�μ�2"));
		model2.addElement(new Student("2013", "�̸�3", "�μ�3"));
		model2.addElement(new Student("2014", "�̸�4", "�μ�4"));
		model2.addElement(new Student("2015", "�̸�5", "�μ�5"));
		list4.setSelectedIndex(3);


		add(list1);
		add(list2);
		add(scroll); 
		add(list4);

		setBounds(300, 200, 300, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JListEx();
	}
}
