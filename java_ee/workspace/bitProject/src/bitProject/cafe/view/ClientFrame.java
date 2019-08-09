package bitProject.cafe.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import bitProject.cafe.dao.Status;
import bitProject.cafe.dto.MemberDTO;

public class ClientFrame extends JFrame implements ActionListener, Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6815773521340214556L;
	private MemberDTO member;
	private JPanel mainPanel; // 전체를 감싸는 패널

	// 오른쪽 상단 슬라이더
	private JPanel pnlSlider; // 실제로 움직이는 슬라이드 패널
	private JButton btnMenuArr[]; // 슬라이더 패널 내에 담을 메뉴들의 배열
	private JButton btnPrev; // 메뉴 위치를 앞으로.
	private JButton btnNext; // 메뉴 위치를 뒤로.
	private int sliderX; // 슬라이더 X의 위치.
	private int sizeBtn; // 버튼 가로세로 크기.

	// 스테이터스 창
	private JLabel lblId; // 로그인 한 계정의 아이디를 표시해줌.
	private JButton btnLogOut; // 로그아웃 버튼

	// 카드레이아웃 컨트롤
	private JPanel pnlMenuWrap; // Card 레이아웃 잡혀있는 패널
	private CardLayout card; // Card 컨트롤
	private RoomReservation roomReservation;
	private MyInfomation myInfomation;
	private Board board;
	private Order order = new Order();

	// 네트워킹
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public ClientFrame(MemberDTO member) {
		this.member = member;

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(1280, 800);
		setResizable(false);
		setLocationRelativeTo(null);

		mainPanel = new JPanel();
		pnlSlider = new JPanel();
		JPanel pnlStatus = new JPanel();
		JPanel pnlBtns = new JPanel();

		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);

		pnlStatus.setBounds(25, 25, 265, 200);
		pnlStatus.setLayout(null);

		pnlBtns.setBounds(374, 65, 810, 160);
		pnlBtns.setLayout(null);

		lblId = new JLabel(member.getName());
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblId.setBounds(12, 23, 161, 52);

		JLabel lblExpression = new JLabel("님 로그인");
		lblExpression.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpression.setFont(new Font("나눔바른고딕", Font.BOLD, 13));
		lblExpression.setBounds(154, 23, 99, 52);

		btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(88, 152, 97, 23);

		pnlStatus.add(lblExpression);
		pnlStatus.add(lblId);
		pnlStatus.add(btnLogOut);

		// 슬라이더 구현
		sizeBtn = 160;

		String btnMenusName[] = { "홈", "스터디예약", "주문하기", "관리자문의", "개인정보", };
		btnMenuArr = new JButton[btnMenusName.length];
		for (int i = 0; i < btnMenuArr.length; i++) {
			btnMenuArr[i] = new JButton(btnMenusName[i]);
			btnMenuArr[i].setPreferredSize(new Dimension(sizeBtn - 5, sizeBtn - 5));
			btnMenuArr[i].addActionListener(this);
			pnlSlider.add(btnMenuArr[i]);
		}
		pnlSlider.setBounds(0, 0, sizeBtn * btnMenuArr.length, 160);
		sliderX = pnlSlider.getLocation().x;
		pnlBtns.add(pnlSlider);

		// 이전, 다음 버튼
		btnPrev = new JButton("prev");
		btnPrev.setBounds(325, 65, 35, 160);
		btnPrev.setVisible(false);

		btnNext = new JButton("prev");
		btnNext.setBounds(1200, 65, 35, 160);
		btnNext.setVisible(false);

		LblClock lblClock = new LblClock();
		lblClock.setHorizontalAlignment(SwingConstants.RIGHT);
		lblClock.setFont(new Font("나눔바른고딕", Font.BOLD, 20));
		lblClock.setBounds(1099, 25, 136, 30);

		mainPanel.add(pnlStatus);
		mainPanel.add(pnlBtns);
		mainPanel.add(btnPrev);
		mainPanel.add(btnNext);
		mainPanel.add(lblClock);

		btnPrev.addActionListener(this);
		btnNext.addActionListener(this);
		// 서버 연결하고, 카드레이아웃에 모든 패널을 붙임.
		connectToServer();
		addCardPanels();

		// 프로그램 강제종료 처리.
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object temp = null;
				try {
					oos.writeObject(new MemberDTO(member.getName(), Status.LOGOUT));
					oos.flush();
					while (true) {
						temp = ois.readObject();
						if (temp instanceof MemberDTO) {
							MemberDTO memberDTO = (MemberDTO) temp;
							if (memberDTO.getStatus() == Status.LOGOUT) {
								oos.close();
								ois.close();
								socket.close();
								System.exit(0);
							}
						} else {
							return;
						}
					}
				} catch (EOFException e1) {
					temp = null;
					return;
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	public void connectToServer() {
		String serverIP = null;
		try {
			serverIP = "192.168.0.60";
			socket = new Socket(serverIP, 10200);

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread t = new Thread(this);
		t.start();
	}

	public void addCardPanels() {
		pnlMenuWrap = new JPanel();
		card = new CardLayout();
		pnlMenuWrap.setLayout(card);
		pnlMenuWrap.setBounds(25, 250, 1210, 500);
		// 문제가 생김.
		myInfomation = new MyInfomation(member, this);
		roomReservation = new RoomReservation(member, this);
		board = new Board(member, this);

		pnlMenuWrap.add(board, "board");
		pnlMenuWrap.add(roomReservation, "roomReservation");
		pnlMenuWrap.add(order, "order");
		pnlMenuWrap.add(myInfomation, "myInfomation");

		mainPanel.add(pnlMenuWrap);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPrev) { // Prev 버튼 이벤트
			sliderX += sizeBtn; // slider의 위치를 버튼 사이즈 만큼 이동.
			if (sliderX >= 0) { // slider의 위치가 0이라면 이동 불가.
				sliderX = 0;
				btnPrev.setVisible(false);
			}
			if (sliderX > -sizeBtn * (btnMenuArr.length - 5)) {
				btnNext.setVisible(true);
			}
			pnlSlider.setLocation(sliderX, 0);

		} else if (e.getSource() == btnNext) { // Next버튼 이벤트
			sliderX -= sizeBtn;
			if (sliderX <= -sizeBtn * (btnMenuArr.length - 5)) {
				sliderX = -sizeBtn * (btnMenuArr.length - 5);
				btnNext.setVisible(false);
			}
			if (sliderX < 0) {
				btnPrev.setVisible(true);
			}
			pnlSlider.setLocation(sliderX, 0);
		} else if (e.getSource() == btnMenuArr[0]) { // 홈으로 가기
			card.next(pnlMenuWrap);
			card.show(pnlMenuWrap, "board");
		} else if (e.getSource() == btnMenuArr[1]) { // 스터디룸 예약
			card.next(pnlMenuWrap);
			card.show(pnlMenuWrap, "roomReservation");
		} else if (e.getSource() == btnMenuArr[2]) { // 주문 하러 가기
			card.next(pnlMenuWrap);
			card.show(pnlMenuWrap, "order");
		} else if (e.getSource() == btnMenuArr[3]) {
			System.out.println("아직 갖추어지지 않음");

		} else if (e.getSource() == btnMenuArr[4]) {
			card.next(pnlMenuWrap);
			card.show(pnlMenuWrap, "myInfomation");
		}
	}

	@Override
	public void run() {
		try {
			oos.writeObject(member);
			oos.flush();
			while (true) {
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ClientFrame frame = new ClientFrame(new MemberDTO("gildong", "pw", "홍길동", "honggilddong", "gmail.com",
//							"010", "1111", "2222", 1991, 1, 1, false, false));
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

}
