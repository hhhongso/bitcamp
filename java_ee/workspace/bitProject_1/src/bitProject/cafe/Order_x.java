package bitProject.cafe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Order_x extends JPanel implements ActionListener {
	private JPanel pnlOption; // 메뉴[음료/디저트] 패널
	private JPanel pnlMenuSelect; // 메뉴선택 패널
	private JPanel pnlTot; // 전체 패널
	private JPanel pnlAmount; // 수량 패널
	private JPanel pnlStatus;// 주문현황 패널
	private JPanel pnlMenu; // 상단 카테고리
	private JPanel pnlMenuPrice;

	private JTextField tfAmount; // 수량
	private JTextField taPrice; // 금액
	private JTextArea taTotPrice; // 총 결제금액

	private JComboBox<String> cbxOption; // 메뉴옵션[음료, 디저트] 콤보박스
	private JComboBox<ImageIcon> cbxMenu; // 메뉴 콤보박스

	private JLabel lblTotPrice;

	private JButton btnAdd; // 주문 추가
	private JButton btnConfirm; // 주문 확정
	private JButton btnCancel; // 주문 취소

	private DefaultTableModel model;
	private JTable table;
	private ArrayList<OrderDTO> list;

	private OrderDTO dto;

	public Order_x() {
		this.setLayout(new BorderLayout());

		pnlMenuSelect = new JPanel();
		pnlAmount = new JPanel();
		pnlMenuPrice = new JPanel();
		pnlStatus = new JPanel();
		pnlMenu = new JPanel();
		pnlTot = new JPanel();

		JLabel lblMenuOption = new JLabel("\t\t ● 메뉴옵션");
		JLabel lblMenuSelect = new JLabel("\t\t ● 메뉴선택");
		JLabel lblMenuPrice = new JLabel("\t\t ● 금    액");
		JLabel lblMenuAmount = new JLabel("\t\t ● 수   량");
		lblTotPrice = new JLabel(" ● 총   액: ");
		JLabel lblStatus = new JLabel("\t\t ● 주문현황");

//메뉴 콤보		
		ImageIcon[] imgArr = { new ImageIcon("img\\coffee_1.png"), new ImageIcon("img\\coffee_2.png"),
				new ImageIcon("img\\coffee_3.png"), new ImageIcon("img\\coffee_4.png"),
				new ImageIcon("img\\coffee_5.png"), new ImageIcon("img\\coffee_6.png") };
		cbxMenu = new JComboBox<ImageIcon>(imgArr);

//수량, 금액 
		taPrice = new JTextField("1000", 5);
		tfAmount = new JTextField("0", 5);
		taPrice.setEditable(false);

		taTotPrice = new JTextArea(0, 10);
		taTotPrice.setEditable(false);

		String colName[] = new String[] { "선택 메뉴", "수량", "금액" };
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(250, 400));

		btnAdd = new JButton("주문추가");
		btnCancel = new JButton("주문취소");
		btnConfirm = new JButton("주문확정");

		pnlMenu.setLayout(new GridLayout(1, 5, 5, 5));
		pnlMenu.add(lblMenuOption);
		pnlMenu.add(lblMenuSelect);
		pnlMenu.add(lblMenuPrice);
		pnlMenu.add(lblMenuAmount);
		pnlMenu.add(lblStatus);

		pnlStatus.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlStatus.add(lblTotPrice);
		pnlStatus.add(taTotPrice);
		pnlStatus.add(btnAdd);
		pnlStatus.add(btnCancel);
		pnlStatus.add(btnConfirm);

		pnlOption = new JPanel(); // 메뉴옵션 패널
		String[] optionArr = new String[] { "음료", "디저트" };
		cbxOption = new JComboBox<String>(optionArr);
		pnlOption.add(cbxOption);

		list = new ArrayList<OrderDTO>();
		dto = new OrderDTO();

		pnlMenuSelect.add(cbxMenu);
		pnlMenuPrice.add(taPrice);
		pnlAmount.add(tfAmount);

		pnlTot.setLayout(new GridLayout(1, 3, 5, 5));
		pnlTot.add(pnlMenuSelect);
		pnlTot.add(pnlMenuPrice);
		pnlTot.add(pnlAmount);

		this.add("Center", pnlTot);

		this.setBounds(0, 0, 1200, 500);
		this.add("West", pnlOption);
		this.add("North", pnlMenu);
		this.add("East", scroll);
		this.add("South", pnlStatus);

	} // 생성자

	public void event() {
		cbxOption.addActionListener(this);
		cbxMenu.addActionListener(this);
		btnAdd.addActionListener(this);
		btnConfirm.addActionListener(this);
	}
	
	public void replacePanel() {
		pnlMenuSelect.add(cbxMenu);
		pnlMenuPrice.add(taPrice);
		pnlAmount.add(tfAmount);

		pnlTot.add(pnlMenuSelect);
		pnlTot.add(pnlMenuPrice);
		pnlTot.add(pnlAmount);
		this.add("Center", pnlTot);
	}

	public void menuSelect() {
		int menuIndex = 0;
		String menuSelect = null;
		int price = 0;
		int amount = 0;

		if (cbxOption.getSelectedIndex() == 0) {
			menuIndex = (int) cbxMenu.getSelectedIndex();
			String[] menuArr = { "아메리카노", "카페라떼", "카푸치노", "카페모카", "핫초코", "레모네이드" };
			int[] priceArr = { 1000, 2000, 2500, 3000, 3000, 2000 };
			for (int i = 0; i < menuArr.length; i++) {
				if (menuIndex == i) {
					menuSelect = menuArr[i];
					price = priceArr[i];
				}
			}
		} else if (cbxOption.getSelectedIndex() == 1) {
			menuIndex = (int) cbxMenu.getSelectedIndex();
			System.out.println(menuIndex);
			String[] menuArr = { "초코케익", "치즈케익", "마카롱", "쿠키" };
			int[] priceArr = { 2000, 2000, 1500, 1000 };

			for (int i = 0; i < menuArr.length; i++) {
				if (menuIndex == i) {
					menuSelect = menuArr[i];
					price = priceArr[i];
				}
			}
		}

		taPrice.setText(price + "");
		taPrice.setEditable(false);
		amount = Integer.parseInt(tfAmount.getText());

//		dto.setMenuSelect(menuSelect);
//		dto.setAmount(amount);
//		dto.setPrice(price);


	}

	public void optionSelect() {
		if (cbxOption.getSelectedIndex() == 0) {
			ImageIcon[] imgArr = { new ImageIcon("img\\coffee_1.png"), new ImageIcon("img\\coffee_2.png"),
					new ImageIcon("img\\coffee_3.png"), new ImageIcon("img\\coffee_4.png"),
					new ImageIcon("img\\coffee_5.png"), new ImageIcon("img\\coffee_6.png") };
			cbxMenu = new JComboBox<ImageIcon>(imgArr);
		} else if (cbxOption.getSelectedIndex() == 1) {
			ImageIcon[] img2Arr = { new ImageIcon("img\\img.png"), new ImageIcon("img\\img.png"),
					new ImageIcon("img\\img.png"), new ImageIcon("img\\img.png") };
			cbxMenu = new JComboBox<ImageIcon>(img2Arr);
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cbxOption) {
			if (pnlMenuSelect != null)
				pnlMenuSelect.removeAll();
			if (pnlMenuPrice != null)
				pnlMenuPrice.removeAll();
			if (pnlAmount != null)
				pnlAmount.removeAll();
			optionSelect();
			replacePanel();
		}

		else if (e.getSource() == cbxMenu) {
			if (pnlMenuSelect != null)
				pnlMenuSelect.removeAll();
			if (pnlMenuPrice != null)
				pnlMenuPrice.removeAll();
			if (pnlAmount != null)
				pnlAmount.removeAll();
			menuSelect();
			replacePanel();

		}

		else if (e.getSource() == btnAdd) {
			int totPrice = 0;
//			for (OrderDTO dto : list) {
//				totPrice += (dto.getPrice() *dto.getAmount());
//			}

			Vector<Object> vec = new Vector<Object>();
//			vec.addElement(dto.getMenuSelect());
//			vec.addElement(dto.getAmount());
//			vec.addElement(dto.getPrice());

			list.add(dto);
			model.addRow(vec);
			System.out.println(list.size());
			System.out.println(model.getRowCount());

//			int totalPrice = 0;
//			for (OrderDTO dto : ) {
//				totalPrice  += dto.getPrice(); 
//			}
//			taTotPrice.append(totalPrice+"");

		} else if (e.getSource() == btnConfirm) {

		}

	}

}
