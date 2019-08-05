package bitProject.cafe;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class Order extends JPanel implements ActionListener{
	private JTextField tfAmount;  //수량
	private JTextArea taPrice; //금액
	
	private JPanel pnlOption; // 메뉴옵션 패널
	private JPanel pnlMenuSelect; // 메뉴선택 패널
	private JPanel pnlAmount; // 수량 패널
	private JPanel pnlStatus; //주문현황 패널
	private JPanel pnlTot; // 전체 패널
	private JPanel pnlMenu; // 상단 카테고리 
	
	private JComboBox<String> cbOption; //메뉴옵션 콤보박스
	private JComboBox<String> cbMenu;
	private JComboBox<ImageIcon> cbMenu2; // 메뉴 콤보박스
	
	private JLabel lblMenuOption; //메뉴옵션 라벨
	private JLabel lblMenuSelect; //메뉴선택 라벨
	private JLabel lblMenuAmount; //수량 라벨
	private JLabel lblMenuPrice; //총액 라벨
	private JLabel lblStatus; //주문현황 라벨
	
	private JButton btnAdd; // 주문 추가 
	private JButton btnConfirm; //주문 확정
	private JButton btnCancel;
	
	private DefaultTableModel model;
	private JTable table;
	
	private static final int drinkPrice = 1000;
	private static final int dessertPrice = 2000;
	
	
	public Order() {
		this.setLayout(new BorderLayout());
		
		pnlOption = new JPanel();
		pnlMenuSelect = new JPanel();
		pnlAmount = new JPanel();
		pnlStatus = new JPanel();
		pnlMenu = new JPanel();
		pnlTot = new JPanel();
		
		lblMenuOption = new JLabel("\t\t ● 메뉴옵션");
		String[] optionArr = new String[] {"음료", "디저트"};
		cbOption = new JComboBox<String>(optionArr);	
	
		pnlOption.add(cbOption);
		
		JLabel lblMenuSelect = new JLabel("\t\t ● 메뉴선택");		
		
		ImageIcon[] imgArr = {
			new ImageIcon("C:\\java_ee\\coffee_1.png"),
			new ImageIcon("C:\\java_ee\\coffee_2.png"),
			new ImageIcon("C:\\java_ee\\coffee_3.png"),
			new ImageIcon("C:\\java_ee\\coffee_4.png"),
			new ImageIcon("C:\\java_ee\\coffee_5.png"),
			new ImageIcon("C:\\java_ee\\coffee_6.png")
				
		};
		
		cbMenu2 = new JComboBox<ImageIcon>(imgArr);
		pnlMenuSelect.add(cbMenu2);
	
		
		
/*		if(cbOption.getSelectedItem().equals("음료")) {
			String[] drinkArr = new String[] {"아메리카노", "카페라떼", "카푸치노", "카페모카", "바닐라라떼",
					"핫초코", "레모네이드", "아이스티", "유자차", "녹차", "홍차"};	
			cbMenu = new JComboBox<String>(drinkArr);
			
		}else if(cbOption.getSelectedItem() == "디저트") {
			String[] dessertArr = new String[] {"초코케익", "치즈케익", "마카롱", "쿠키"};
			cbMenu = new JComboBox<String>(dessertArr);
		}
		pnlMenuSelect.add(cbMenu);
		
	*/	
		lblMenuAmount = new JLabel("\t\t ● 수   량");
		tfAmount = new JTextField("0", 5);

		pnlAmount.add(tfAmount);		
		
		lblMenuPrice = new JLabel(" ● 총   액: ");
		taPrice = new JTextArea(0, 10);
		taPrice.setEditable(false);
		
		lblStatus = new JLabel("\t\t ● 주문현황");
		
		String colName[] = new String[]{"메뉴옵션", "선택 메뉴", "수량", "금액"};
		model = new DefaultTableModel(colName, 0);
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		pnlStatus.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlStatus.add(lblMenuPrice);
		pnlStatus.add(taPrice);
		
		btnAdd = new JButton("주문추가");
		pnlStatus.add(btnAdd);
		
		btnCancel = new JButton("주문취소");
		pnlStatus.add(btnCancel);
		
		btnConfirm = new JButton("주문확정");
		pnlStatus.add(btnConfirm);	
		
		pnlTot.setLayout(new GridLayout(1, 4, 5, 5));
		pnlTot.add(pnlOption);
		pnlTot.add(pnlMenuSelect);
		pnlTot.add(pnlAmount);
		pnlTot.add(scroll);
		
		pnlMenu.setLayout(new GridLayout(1, 4, 5, 5));
		pnlMenu.add(lblMenuOption);
		pnlMenu.add(lblMenuSelect);
		pnlMenu.add(lblMenuAmount);
		pnlMenu.add(lblStatus);	
		
		this.setBounds(0, 0, 1200, 500);
		this.add("North", pnlMenu);		
		this.add("Center", pnlTot);
		this.add("South", pnlStatus);
	} // 생성자 
	
	public void cbOptionSelect(){
		
	}

	

	public void event() {
		btnAdd.addActionListener(this);
		btnConfirm.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd) {
			String menuOption = (String) cbOption.getSelectedItem();
			int menuSelect2 = (int) cbMenu2.getSelectedIndex();
			String amount = tfAmount.getText();
			int price = 0; 
			if(menuOption.equals("음료"))	price =	Integer.parseInt(amount) * drinkPrice;
			else price = Integer.parseInt(amount) *dessertPrice;
			
			OrderDTO dto = new OrderDTO();
			dto.setMenuOption(menuOption);
			if (menuSelect2 == 0) { dto.setMenuSelect("아메리카노");			
			} else if(menuSelect2 == 1) { dto.setMenuSelect("카페라떼");
			} else if(menuSelect2 == 2) { dto.setMenuSelect("카푸치노");
			} else if(menuSelect2 == 3) { dto.setMenuSelect("카페모카");
			} else if(menuSelect2 == 4) { dto.setMenuSelect("핫초코");
			} else if(menuSelect2 == 5) { dto.setMenuSelect("레모네이드");
			}
			
			dto.setAmount(amount);
			dto.setPrice(price);
			
			Vector<String> vector = new Vector<String>();
			vector.addElement(dto.getMenuOption());
			vector.addElement(dto.getMenuSelect());
			vector.addElement(dto.getAmount());
			vector.addElement(dto.getPrice()+"");
			model.addRow(vector);
			
			int totalPrice = 0;
//			for (OrderDTO dto : ) {
//				totalPrice  += dto.getPrice(); 
//			}
			taPrice.setText(totalPrice+"");
			
			
		} else if(e.getSource() == btnConfirm) {
			
		}
		
	}
}
