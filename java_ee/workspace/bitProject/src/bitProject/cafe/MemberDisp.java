package bitProject.cafe;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JCheckBox;

import bitProject.cafe.dao.MemberDAO;
import bitProject.cafe.dto.MemberDTO;

public class MemberDisp extends JPanel implements ActionListener {
	private JTextField tfSearchInput;
	private JButton btnDisp;
	
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private TableColumn column;
	
	private JRadioButton rbtnId;
	private JRadioButton rbtnName;
	
	private JCheckBox cbxId;
	private JCheckBox cbxName;
	private JCheckBox cbxTel;
	private JCheckBox cbxBirth;
	
//	private ArrayList<MemberDTO> list;

	public MemberDisp() {
		setLayout(null);
		
		JLabel lblMemberSearch = new JLabel("회원 검색");
		lblMemberSearch.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblMemberSearch.setBounds(22, 23, 99, 36);
		add(lblMemberSearch);
		
		JLabel lblMemberDisp = new JLabel("회원정보조회");
		lblMemberDisp.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lblMemberDisp.setBounds(22, 219, 163, 36);
		add(lblMemberDisp);
		
		JLabel lblSearchOption = new JLabel("검색 조건");
		lblSearchOption.setBounds(22, 68, 57, 15);
		add(lblSearchOption);
		
		rbtnId = new JRadioButton("아이디", true);
		rbtnId.setBounds(91, 64, 121, 23);
		add(rbtnId);
		
		rbtnName = new JRadioButton("이름");
		rbtnName.setBounds(232, 64, 121, 23);
		add(rbtnName);
		
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rbtnId);
		btnGroup.add(rbtnName);
		
		JLabel lblSearchInput = new JLabel("아이디/이름 입력");
		lblSearchInput.setBounds(22, 103, 99, 15);
		add(lblSearchInput);
		
		tfSearchInput = new JTextField();
		tfSearchInput.setBounds(22, 128, 131, 21);
		add(tfSearchInput);
		tfSearchInput.setColumns(10);
		
		btnDisp = new JButton("조회");
		btnDisp.setBounds(232, 127, 97, 23);
		add(btnDisp);
		
		JLabel lblNewLabel = new JLabel("조회 내용");
		lblNewLabel.setBounds(22, 169, 57, 15);
		add(lblNewLabel);
		
		cbxId = new JCheckBox("아이디");
		cbxId.setBounds(22, 190, 115, 23);
		add(cbxId);
		
		cbxName = new JCheckBox("이름");
		cbxName.setBounds(188, 190, 115, 23);
		add(cbxName);
		
		cbxTel = new JCheckBox("전화번호");
		cbxTel.setBounds(390, 190, 115, 23);
		add(cbxTel);
		
		cbxBirth = new JCheckBox("생년월일");
		cbxBirth.setBounds(591, 190, 115, 23);
		add(cbxBirth);
		
		cbxId.setSelected(false);
		cbxName.setSelected(false);
		cbxTel.setSelected(false);
		cbxBirth.setSelected(false);
		
		table = new JTable();
		model = new DefaultTableModel(0, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
		
		scroll.setBounds(22, 265, 1153, 209);
		add(scroll);
		
		btnDisp.addActionListener(this);
	}// 생성자
	
	public int setIndex() {
		int idx = 0; // 0123
		
		System.out.println(idx);
		return idx;
	}
	
	public void addColumn() {		
		if(cbxId.isSelected()) { model.addColumn("아이디");	}
		else if(cbxName.isSelected()) {	model.addColumn("이름");	}
		else if(cbxTel.isSelected()) {model.addColumn("전화번호");	}
		else if(cbxBirth.isSelected()) {model.addColumn("생년월일");	}
	}
	
	public void removeColumn(int idx) {
		// DefaultTableModel을 확장하고 removeColumn (int 열) 메서드를 직접 만듭니다.
		//이 메서드는 Vector의 모든 행을 반복하고 Vector.remove (int) 메서드를 사용하여 영구 행의 열을 제거해야합니다.
		// 마지막으로이 작업이 완료되면 fireTableStructureChanged () 메소드를 호출하여 열을 제거하여 테이블을 다시 칠할 수 있도록 테이블에 알릴 필요가 있습니다.
		
		column = table.getColumnModel().getColumn(idx);
		table.getColumnModel().removeColumn(column);
//		table.removeColumn(column);
		table.revalidate();		
	}
	
	public void setTable() {
		table.setModel(model);
		
		System.out.println("model" + model.getColumnCount());
		System.out.println("table" + table.getColumnCount());
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDisp) {
			int idx = setIndex();
			addColumn();
			removeColumn(idx);
			setTable();
			
			add(scroll);
			
			
			//검색 옵션(이름 / 아이디) 에 일치하면
			if(rbtnId.isSelected()) { 
				//그에 해당하는 데이터를 DAO에서 가져온다. tryLogin을 오버로드한 후, 필요한 정보만 table 열에 vector로 추가.
//				MemberDTO member = MemberDAO.getInstance().tryLogin(tfSearchInput.getText());
				
			} else if(rbtnName.isSelected()) {
//				MemberDTO member = MemberDAO.getInstance().tryLogin(tfSearchInput.getText());				
			}
	
		}
		
	} // actionPerformed
	
	
//임시 main =====================================================================================
	public static void main(String[] args) {
		JFrame f = new JFrame();
		MemberDisp disp = new MemberDisp();
		f.getContentPane().add(disp);
		f.setBounds(700, 100, 1300, 600);
		f.setVisible(true);
		
	}


}
