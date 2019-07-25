import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel {
	//�迭���ϸ� ��,���� �����Ǵϱ� �Է� ������ ������ ���� > vector �� ���
	Object[][] data ={{"id1", "����ġ", new Integer(1111), "��"}, 
					{"id2", "�ƶ�ġ", new Integer(2222), "��!"}, 
					{"id3", "�ƶ�", new Integer(3333), "�ƶ����"}, 
					{"id4", "������", new Integer(4444), "�Ա��ʹ�"}};
	
	String[] name = {"���̵�", "�̸�", "��й�ȣ", "����"};

	//  AbstractTableModel�� �߻�޼ҵ�: �ʼ� ����
	@Override 
	public int getRowCount(){  //��
		return data.length;
	}
	@Override
	public int getColumnCount(){ //��
		return name.length;
	}
	@Override
	public Object getValueAt(int row, int column){
		return data[row][column];
	}

	public boolean isCellEditable(int row, int column){
		return (column != 0) ? true : false;
	}

	public String getColumnName(int column){
		return name[column];
	}

	public void setValueAt(Object obj, int row, int column){
		data[row][column] = obj;
	}
} // JTable Ŭ���� 

	public class JTableEx extends JFrame {
		private JTable table; 
		private JTableModel model; 

		public JTableEx(){
			model = new JTableModel();
			table = new JTable(model); 
			this.add(new JScrollPane(table)); 

			setBounds(200, 200, 300, 300);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}
	
	public static void main(String[] args) {
		new JTableEx();
		
	}
}

