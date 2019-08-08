package ing;

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
import javax.swing.table.TableColumnModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JCheckBox;

import bitProject.cafe.dao.MemberDAO;
import bitProject.cafe.dto.MemberDTO;

	public class MemberDisp_2 extends JPanel implements ActionListener {
		private JTextField tfSearchInput;
		private JButton btnDisp;
		
		private JTable table;
		private DefaultTableModel model;
		
		private JRadioButton rbtnId;
		private JRadioButton rbtnName;
		
		private JCheckBox cbxId;
		private JCheckBox cbxName;
		private JCheckBox cbxTel;
		private JCheckBox cbxBirth;
		
//		private ArrayList<MemberDTO> list;
		private static final String[] header = {"아이디", "이름", "전화번호", "생년월일"};

		public MemberDisp_2() {
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
			
			model = new DefaultTableModel(0, 0) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			table = new JTable(model);
			JScrollPane scroll = new JScrollPane(table);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);		
			
			scroll.setBounds(22, 265, 1153, 209);
			add(scroll);
			
			btnDisp.addActionListener(this);
		}// 생성자
	
		
		public void addColumn() {				
			if(cbxId.isSelected()) {
				if(model.findColumn("아이디") == -1) model.addColumn("아이디");		
			}
			if(cbxName.isSelected()) {
				if(model.findColumn("이름") == -1) model.addColumn("이름");		
			}
			if(cbxTel.isSelected()) {
				if(model.findColumn("전화번호") == -1) model.addColumn("전화번호");		
			}
			if(cbxBirth.isSelected()) {
				if(model.findColumn("생년월일") == -1) model.addColumn("생년월일");		
			}
		}
		
		public void checkColumn() {
			if(!cbxId.isSelected())		removeColumn(0);
			if(!cbxName.isSelected())	removeColumn(1);
			if(!cbxTel.isSelected())	removeColumn(2);
			if(!cbxBirth.isSelected())	removeColumn(3);
		}
		
		public void removeColumn(int idx) {
				if(model.findColumn(header[idx]) != -1) {
					TableColumn tc = table.getColumnModel().getColumn(idx);
					table.removeColumn(tc);
					System.out.println("아이디 후: "+ model.findColumn("아이디"));
					System.out.println("이름 후: "+ model.findColumn("이름"));
					System.out.println("전화번호 후: "+ model.findColumn("전화번호"));
					System.out.println("생년월일 후: "+ model.findColumn("생년월일"));
				}	

		}
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			if(e.getSource() == btnDisp) {
				addColumn();
	//			checkColumn();				
			
			}
			
		} // actionPerformed
		
		
	//임시 main =====================================================================================
		public static void main(String[] args) {
			JFrame f = new JFrame();
			MemberDisp_2 disp = new MemberDisp_2();
			f.getContentPane().add(disp);
			f.setBounds(700, 100, 1300, 600);
			f.setVisible(true);
			
		}


	}
