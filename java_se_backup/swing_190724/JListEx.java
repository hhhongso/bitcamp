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

		//관리역할(View): 넣었다가 뺐다가하는 내부작업. 보여주는 것.  
		//arrayList(Collection) 에서도 add, remove 할 수는 있으나, 일부 없는 기능이 존재 >> 그 기능을 해주고 관리해주는게 DefaultListModel
		DefaultListModel<String> model = new DefaultListModel<String>(); 
		JList<String> list2 = new JList<String>(model);	
		model.addElement("사과");
		model.addElement("딸기");
		model.addElement("바나나");
		model.addElement("망고");
		list2.setSelectedIndex(1);

		//Vector: 관리역할 없음. 컬렉션. 모아주는 역할 
		Vector<String> vListData = new Vector<String>();
		JList<String> list3 = new JList<String>(vListData);
		JScrollPane scroll = new JScrollPane(list3);
		vListData.add("축구");	vListData.add("수영");
		vListData.add("야구");	vListData.add("태권도");
		vListData.add("농구");	vListData.add("유도");
		vListData.add("배구");	vListData.add("하키");
		vListData.add("탁구");	vListData.add("스키");
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
		model2.addElement(new Student("2011", "이름1", "부서1"));
		model2.addElement(new Student("2012", "이름2", "부서2"));
		model2.addElement(new Student("2013", "이름3", "부서3"));
		model2.addElement(new Student("2014", "이름4", "부서4"));
		model2.addElement(new Student("2015", "이름5", "부서5"));
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
