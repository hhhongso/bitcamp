import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class JTableModel extends AbstractTableModel {
	//배열로하면 행,렬이 고정되니까 입력 데이터 제한이 생김 > vector 로 사용
	Object[][] data ={{"id1", "마루치", new Integer(1111), "얍"}, 
					{"id2", "아라치", new Integer(2222), "얍!"}, 
					{"id3", "아라리", new Integer(3333), "아라라라라"}, 
					{"id4", "마라탕", new Integer(4444), "먹구싶다"}};
	
	String[] name = {"아이디", "이름", "비밀번호", "구분"};

	//  AbstractTableModel의 추상메소드: 필수 구현
	@Override 
	public int getRowCount(){  //행
		return data.length;
	}
	@Override
	public int getColumnCount(){ //렬
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
} // JTable 클래스 

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

