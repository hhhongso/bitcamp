package bitProject.cafe.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bitProject.cafe.dao.SalesDAO;

import bitProject.cafe.dto.OrderDTO;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class OrderDisp extends JPanel implements ActionListener {
	private JTable table;
	private DefaultTableModel model;

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	private JButton btnUpdate;
	private OrderDTO order;

	private JTextField tfById;
	private JTextField tfByDate;

	private JRadioButton rbtnByDate;
	private JRadioButton rbtnById;
	private JRadioButton rbtnDispAll;
	
	private ArrayList<OrderDTO> list;

	public OrderDisp() {
		setLayout(null);

		JLabel lblOrderDisp = new JLabel("주문내역 확인");
		lblOrderDisp.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblOrderDisp.setBounds(28, 21, 178, 36);
		add(lblOrderDisp);

		String[] colName = { "주문자", "주문 메뉴", "수량", "단가", "금액", "주문날짜" };
		model = new DefaultTableModel(colName, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		table.getTableHeader().setReorderingAllowed(false); // 이동 불가
		table.getTableHeader().setResizingAllowed(false); // 크기 조절 불가
		setAlignmentCenter(table);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		scroll.setBounds(28, 107, 823, 363);
		add(scroll);

		btnUpdate = new JButton("조회");
		btnUpdate.setBounds(745, 69, 97, 23);
		add(btnUpdate);
		
		rbtnDispAll = new JRadioButton("전체 조회");
		rbtnDispAll.setBounds(28, 69, 121, 23);
		add(rbtnDispAll);
		
		rbtnById = new JRadioButton("이용자별 조회");
		rbtnById.setBounds(181, 69, 116, 23); 
		add(rbtnById);
		
		rbtnByDate = new JRadioButton("주문날짜별 조회");
		rbtnByDate.setBounds(471, 69, 123, 23);
		add(rbtnByDate);
		
		ButtonGroup btnGroup = new ButtonGroup();
		rbtnDispAll.setSelected(true);
		btnGroup.add(rbtnDispAll);
		btnGroup.add(rbtnById);
		btnGroup.add(rbtnByDate);

		tfByDate = new JTextField();
		tfByDate.setBounds(602, 70, 116, 21);
		add(tfByDate);
		tfByDate.setColumns(10);

		tfById = new JTextField();
		tfById.setBounds(305, 70, 116, 21);
		add(tfById);
		tfById.setColumns(10);

		btnUpdate.addActionListener(this);
		
		list = new ArrayList<OrderDTO>();
		
	} // 생성자

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdate) {
			if(rbtnDispAll.isSelected()) {
				list = SalesDAO.getInstance().dispAll();	
				disp();
				
			} else if(rbtnById.isSelected()) {
				String searchId = tfById.getText();
				list = SalesDAO.getInstance().dispById(searchId);	
				if(model.getRowCount() != 0) { table.removeAll();}
				disp();
				
			} else if(rbtnByDate.isSelected()) {
				list.clear();
				String searchDate = tfByDate.getText();
				list = SalesDAO.getInstance().dispByDate(searchDate);	
				disp();
				
			}
		}

	}
	
	public void disp() {
		for (OrderDTO order : list) {
			Vector<Object> vec = new Vector<Object>();
			int totPrice = order.getAmount() * order.getMenuPrice();
			vec.addElement(order.getId());
			vec.addElement(order.getMenuName());
			vec.addElement(order.getAmount());
			vec.addElement(order.getMenuPrice());
			vec.addElement(totPrice);
			vec.addElement(order.getOrderDate());
			model.addRow(vec);
		}
		
	}

	public void setAlignmentCenter(JTable table) { // JTable의 내용 가운데 정렬
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

// 임시 main =========================================================================================================================	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		OrderDisp orderDisp = new OrderDisp();
		f.getContentPane().add(orderDisp);
		f.setBounds(700, 100, 1300, 600);
		f.setVisible(true);
	}
}
