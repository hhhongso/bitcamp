package bitProject.cafe.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import bitProject.cafe.dao.Status;
import bitProject.cafe.dto.MemberDTO;
import bitProject.cafe.dto.RoomDTO;

public class MyInfomation extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1813802878658133486L;
	private JPasswordField ptfPwCurr, ptfPwNew, ptfPwNewRe;
	private JTextField tfId, tfName, tfEmailAccount, tfEmailDomain, tfTel1, tfTel2, tfTel3, tfYear, tfMonth, tfDate;
	private MemberDTO member;
	private JTable tableReservationList;
	private DefaultTableModel modelRoomList;
	private Vector<String> vtColName;
	private Vector<Vector<Integer>> reservationList;
	private JButton btnRefresh, btnCancel, btnUpdateStatus, btnLeave, btnCheckPw, btnCheckEmail, btnClear;
	private JPanel pnlRoomList;
	private ClientFrame main;

	public MyInfomation(MemberDTO member, ClientFrame main) {
		this.member = member;
		this.main = main;

		setBackground(Color.WHITE);
		setBounds(new Rectangle(0, 0, 1200, 500));
		setLayout(null);

		JPanel pnlStatus = new JPanel();
		pnlStatus.setBounds(12, 10, 416, 480);
		add(pnlStatus);
		pnlStatus.setLayout(null);

		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(15, 32, 54, 23);
		pnlStatus.add(lblId);
		lblId.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblPwCurr = new JLabel("이전 비밀번호");
		lblPwCurr.setBounds(15, 83, 122, 23);
		pnlStatus.add(lblPwCurr);
		lblPwCurr.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblPwNew = new JLabel("새 비밀번호");
		lblPwNew.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblPwNew.setBounds(15, 134, 122, 23);
		pnlStatus.add(lblPwNew);

		JLabel lblPwNewRe = new JLabel("비밀번호 재확인");
		lblPwNewRe.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblPwNewRe.setBounds(15, 186, 160, 23);
		pnlStatus.add(lblPwNewRe);

		JLabel lblName = new JLabel("이름");
		lblName.setBounds(15, 237, 36, 23);
		pnlStatus.add(lblName);
		lblName.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblEmail = new JLabel("이메일");
		lblEmail.setBounds(15, 290, 54, 23);
		pnlStatus.add(lblEmail);
		lblEmail.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblTelNum = new JLabel("전화번호");
		lblTelNum.setBounds(12, 348, 72, 23);
		pnlStatus.add(lblTelNum);
		lblTelNum.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		JLabel lblBirthDay = new JLabel("생년월일");
		lblBirthDay.setBounds(12, 408, 72, 23);
		pnlStatus.add(lblBirthDay);
		lblBirthDay.setFont(new Font("나눔바른고딕", Font.BOLD, 20));

		tfId = new JTextField();
		tfId.setText(member.getId());
		tfId.setEditable(false);
		tfId.setBounds(180, 30, 150, 23);
		pnlStatus.add(tfId);
		tfId.setColumns(10);

		ptfPwCurr = new JPasswordField();
		ptfPwCurr.setBounds(180, 85, 150, 21);
		pnlStatus.add(ptfPwCurr);

		ptfPwNew = new JPasswordField();
		ptfPwNew.setBounds(180, 135, 150, 21);
		pnlStatus.add(ptfPwNew);

		ptfPwNewRe = new JPasswordField();
		ptfPwNewRe.setBounds(180, 185, 150, 21);
		pnlStatus.add(ptfPwNewRe);

		btnCheckPw = new JButton("확인");
		btnCheckPw.setBounds(350, 185, 50, 21);
		btnCheckPw.setFont(new Font("나눔바른고딕", Font.BOLD, 8));
		pnlStatus.add(btnCheckPw);

		tfName = new JTextField();
		tfName.setText(member.getName());
		tfName.setEditable(false);
		tfName.setColumns(10);
		tfName.setBounds(180, 235, 150, 23);
		pnlStatus.add(tfName);

		tfEmailAccount = new JTextField();
		tfEmailAccount.setText(member.getEmailAccount());
		tfEmailAccount.setColumns(10);
		tfEmailAccount.setBounds(180, 290, 70, 23);
		pnlStatus.add(tfEmailAccount);

		tfEmailDomain = new JTextField();
		tfEmailDomain.setText(member.getEmailDomain());
		tfEmailDomain.setColumns(10);
		tfEmailDomain.setBounds(270, 290, 75, 23);
		pnlStatus.add(tfEmailDomain);

		btnCheckEmail = new JButton("인증");
		btnCheckEmail.setBounds(353, 290, 50, 21);
		btnCheckEmail.setFont(new Font("나눔바른고딕", Font.BOLD, 8));
		pnlStatus.add(btnCheckEmail);

		tfTel1 = new JTextField();
		tfTel1.setText(member.getTel1());
		tfTel1.setColumns(10);
		tfTel1.setBounds(180, 350, 54, 23);
		pnlStatus.add(tfTel1);

		JLabel lblHyphen = new JLabel("-");
		lblHyphen.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblHyphen.setBounds(237, 350, 17, 23);
		pnlStatus.add(lblHyphen);

		tfTel2 = new JTextField();
		tfTel2.setText(member.getTel2());
		tfTel2.setColumns(10);
		tfTel2.setBounds(254, 350, 66, 23);
		pnlStatus.add(tfTel2);

		tfTel3 = new JTextField();
		tfTel3.setText(member.getTel3());
		tfTel3.setColumns(10);
		tfTel3.setBounds(338, 350, 66, 23);
		pnlStatus.add(tfTel3);

		tfYear = new JTextField();
		tfYear.setText("" + member.getBirthYear());
		tfYear.setEditable(false);
		tfYear.setColumns(10);
		tfYear.setBounds(180, 405, 72, 23);
		pnlStatus.add(tfYear);

		tfMonth = new JTextField();
		tfMonth.setText("" + member.getBirthMonth());
		tfMonth.setEditable(false);
		tfMonth.setColumns(10);
		tfMonth.setBounds(278, 405, 41, 23);
		pnlStatus.add(tfMonth);

		tfDate = new JTextField();
		tfDate.setText("" + member.getBirthDate());
		tfDate.setEditable(false);
		tfDate.setColumns(10);
		tfDate.setBounds(346, 405, 41, 23);
		pnlStatus.add(tfDate);

		JLabel lblYear = new JLabel("년");
		lblYear.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblYear.setBounds(254, 405, 24, 23);
		pnlStatus.add(lblYear);

		JLabel lblMonth = new JLabel("월");
		lblMonth.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblMonth.setBounds(322, 405, 24, 23);
		pnlStatus.add(lblMonth);

		JLabel lblDate = new JLabel("일");
		lblDate.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblDate.setBounds(392, 405, 24, 23);
		pnlStatus.add(lblDate);

		JLabel label = new JLabel("-");
		label.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		label.setBounds(325, 350, 17, 23);
		pnlStatus.add(label);

		JLabel lblAt = new JLabel("@");
		lblAt.setFont(new Font("나눔바른고딕", Font.BOLD, 12));
		lblAt.setBounds(252, 290, 24, 23);
		pnlStatus.add(lblAt);

		btnClear = new JButton("다시입력");
		btnClear.setBounds(65, 438, 90, 30);
		pnlStatus.add(btnClear);

		btnUpdateStatus = new JButton("수정");
		btnUpdateStatus.setBounds(165, 438, 90, 30);
		pnlStatus.add(btnUpdateStatus);

		btnLeave = new JButton("탈퇴");
		btnLeave.setBounds(265, 438, 90, 30);
		pnlStatus.add(btnLeave);

		pnlRoomList = new JPanel();
		pnlRoomList.setBounds(467, 10, 347, 408);
		add(pnlRoomList);
		setTable();

		btnRefresh = new JButton("갱신");
		btnRefresh.setBounds(467, 430, 163, 60);
		add(btnRefresh);

		btnCancel = new JButton("예약취소");
		btnCancel.setEnabled(false);
		btnCancel.setBounds(651, 430, 163, 60);
		add(btnCancel);

		addEvent();
	}

	public void addEvent() {
		btnClear.addActionListener(this);
		btnRefresh.addActionListener(this);
		btnCancel.addActionListener(this);
		btnCheckPw.addActionListener(this);
		btnUpdateStatus.addActionListener(this);
		btnLeave.addActionListener(this);
		btnCheckEmail.addActionListener(this);
	}

	@SuppressWarnings("serial")
	public void setTable() {
		setTableCol(); // 테이블 컬럼명 세팅
		getMyReservation(); // DB에서 데이터를 다 가지고 옴.

		// tableModel에 컬럼명, DB에서 가져온 예약리스트를 넣음.
		// 수정 불가능하게 막음.
		modelRoomList = new DefaultTableModel(reservationList, vtColName) {
			@Override
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		tableReservationList = new JTable(modelRoomList); // tableModel을 Jtable에 넣음
		tableReservationList.setRowSelectionAllowed(true);
		tableReservationList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setAlignmentCenter(tableReservationList); // JTabel 가운데 정렬

		JScrollPane scroll = new JScrollPane(tableReservationList);
		scroll.setPreferredSize(new Dimension(pnlRoomList.getSize()));
		pnlRoomList.add(scroll);
	}

	public void setAlignmentCenter(JTable table) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
	}

	public void setTableCol() {
		vtColName = new Vector<String>();
		vtColName.add("연도");
		vtColName.add("월");
		vtColName.add("일");
		vtColName.add("시작시간");
		vtColName.add("종료시간");
		vtColName.add("방 번호");
	}

	public void getMyReservation() {
		RoomDTO room = new RoomDTO(member.getId());
		room.setStatus(Status.GET_MY_RESERVATION);
		try {
			request(room);
			while (true) {
				Object objectReceived = null;
				try {
					objectReceived = main.getOis().readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				if (objectReceived instanceof RoomDTO) {
					RoomDTO roomDTO = (RoomDTO) objectReceived;
					if (roomDTO.getStatus() == Status.GET_MY_RESERVATION) {
						reservationList = roomDTO.getReservationList();
						return;
					} else {
						return;
					}
				} else {
					return;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isSamePw(String pw) {
		boolean result = false;
		if (pw.equals(member.getPw())) {
			result = true;
		}
		return result;
	}

	public boolean isSamePw(String pwNew, String pwNewRe) {
		boolean result = false;
		if (pwNew.equals(pwNewRe)) {
			result = true;
		}
		return result;
	}

	public void clear() {
		tfEmailAccount.setText(member.getEmailAccount());
		tfEmailDomain.setText(member.getEmailDomain());
		ptfPwCurr.setText("");
		ptfPwNew.setText("");
		ptfPwNewRe.setText("");
		tfTel1.setText(member.getTel1());
		tfTel2.setText(member.getTel2());
		tfTel3.setText(member.getTel3());
		btnCheckPw.setEnabled(true);
		ptfPwNew.setEditable(true);
		ptfPwNewRe.setEditable(true);
	}

	public void request(MemberDTO member) {
		try {
			main.getOos().writeObject(member);
			main.getOos().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void request(RoomDTO room) {
		try {
			main.getOos().writeObject(room);
			main.getOos().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Object response() {
		Object objectRecieved = null;
		while (true) {
			try {
				objectRecieved = main.getOis().readObject();
				break;
			} catch (EOFException e) {
				objectRecieved = null;
				break;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				break;
			} catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		return objectRecieved;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRefresh) { // 예약리스트 갱신
			btnCancel.setEnabled(true);
			for (int i = 0; i < modelRoomList.getRowCount(); i++) {
				modelRoomList.removeRow(i);
				i--;
			}
			getMyReservation();
			for (int i = 0; i < reservationList.size(); i++) {
				modelRoomList.addRow(reservationList.get(i));
			}
		} else if (e.getSource() == btnCancel) { // 예약취소
			int rowIdx = tableReservationList.getSelectedRow();
			if (rowIdx == -1) {
				JOptionPane.showMessageDialog(this, "선택한 예약 리스트가 없습니다.");
				return;
			}
			int year = (Integer) tableReservationList.getValueAt(rowIdx, 0);
			int month = (Integer) tableReservationList.getValueAt(rowIdx, 1);
			int date = (Integer) tableReservationList.getValueAt(rowIdx, 2);
			int inHour = (Integer) tableReservationList.getValueAt(rowIdx, 3);
			int outHour = (Integer) tableReservationList.getValueAt(rowIdx, 4);
			int roomNum = (Integer) tableReservationList.getValueAt(rowIdx, 5);

			RoomDTO room = new RoomDTO(roomNum, member.getId(), year, month, date, inHour, outHour);
			room.setStatus(Status.CANCEL_MY_RESERVATION);
			request(room);

			Object temp = response();
			if (temp instanceof RoomDTO) {
				room = (RoomDTO) temp;
				if (room.getStatus() == Status.CANCEL_MY_RESERVATION) {
					modelRoomList.removeRow(rowIdx);
					btnCancel.setEnabled(false);
					return;
				} else if (room.getStatus() == Status.FAILURE) {
					System.out.println("삭제 실패");
					return;
				}
			}
		} else if (e.getSource() == btnCheckPw) {
			String pwNew = String.valueOf(ptfPwNew.getPassword());
			String pwNewRe = String.valueOf(ptfPwNewRe.getPassword());

			if (pwNew.length() == 0 || pwNewRe.length() == 0) {
				JOptionPane.showMessageDialog(this, "변경할 비밀번호를 입력해주세요.");
				return;
			}
			if (isSamePw(pwNew, pwNewRe)) {
				JOptionPane.showMessageDialog(this, "동일한 비밀번호를 입력하셨습니다.");
				btnCheckPw.setEnabled(false);
				ptfPwNew.setEditable(false);
				ptfPwNewRe.setEditable(false);
			} else {
				JOptionPane.showMessageDialog(this, "입력하신 비밀번호가 다릅니다.");
				ptfPwNew.setText("");
				ptfPwNewRe.setText("");
			}

		} else if (e.getSource() == btnUpdateStatus) {
			String id = tfId.getText();
			String pwCurr = String.valueOf(ptfPwCurr.getPassword());
			String pwNew = String.valueOf(ptfPwNewRe.getPassword());
			String emailAccount = tfEmailAccount.getText();
			String emailDomain = tfEmailDomain.getText();
			String tel1 = tfTel1.getText();
			String tel2 = tfTel2.getText();
			String tel3 = tfTel3.getText();

			// 비밀번호가 맞는지 검사.
			if (!isSamePw(pwCurr)) {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다.");
				return;
			}

			if (btnCheckPw.isEnabled()) { // 비밀번호는 변경하지 않는경우
				request(new MemberDTO(id, pwCurr, emailAccount, emailDomain, tel1, tel2, tel3));
			} else { // 비밀번호까지 변경하는 경우
				request(new MemberDTO(id, pwNew, emailAccount, emailDomain, tel1, tel2, tel3));
			}
			Object temp = response();
			if (temp instanceof MemberDTO) {
				MemberDTO memberDTO = (MemberDTO) temp;
				if (memberDTO.getStatus() == Status.CHANGE_MY_INFO) {
					JOptionPane.showMessageDialog(this, "성공적으로 수정되었습니다.");
					clear();
				} else if (memberDTO.getStatus() == Status.FAILURE) {
					JOptionPane.showMessageDialog(this, "수정 실패");
				}
			}

		} else if (e.getSource() == btnClear) { // 다시 입력
			clear();
		}
	}
}
