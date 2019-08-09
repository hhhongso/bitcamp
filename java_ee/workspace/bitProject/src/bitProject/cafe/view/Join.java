package bitProject.cafe.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import bitProject.cafe.dao.Status;
import bitProject.cafe.dto.LoginDTO;
import bitProject.cafe.dto.MemberDTO;

public class Join extends JFrame implements KeyListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6364185965047627498L;
	private String inEmailConfirmCode;
	private String exEmailConfirmCode;
	private boolean emailConfirm; // 나중에 로컬변수 변경 여부 확인

	private JButton btnIdConfirm;
	private JButton btnEmailConfirm;
	private JButton btnEmailConfirmDone;
	private JButton btnComplete;
	private JButton btnCancel;

	private JCheckBox cbxInfoAgreeEssen;
	private JCheckBox cbxInfoAgreeSelec;

	private JLabel lblIdWaring;
	private JLabel lblPwWaring;
	private JLabel lblPwConfirmWaring;
	private JLabel lblEmailConfirmWaring;

	private JTextArea taInfoAgreeEssen;
	private JTextArea taInfoAgreeSelec;

	private JTextField tfId;
	private JPasswordField ptfPw;
	private JPasswordField ptfPwConfirm;
	private JTextField tfName;
	private JTextField tfEmailAccount;
	private JTextField tfEmailDomain;
	private JTextField tfEmailConfirm;
	private JTextField tfTel1; // 010
	private JTextField tfTel2; // 0000
	private JTextField tfTel3; // 0000
	private JTextField tfBirthYear;
	private JTextField tfBirthMonth;
	private JTextField tfBirthDate;

	private Login login;

	public Join(Login login) {
		super("선홍유림_회원가입");
		this.login = login;

		this.setLayout(null);
		setSize(500, 600);
		setLocationRelativeTo(login);
		this.setResizable(false);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		// 제목, 틀 생성 및 배치 종료
		JLabel lblJoin;
		JLabel lblId;
		JLabel lblIdEx;
		JLabel lblPw;
		JLabel lblPwEx;
		JLabel lblPwConfirm;
		JLabel lblPwExConfirm;
		JLabel lblName;
		JLabel lblEmail;
		JLabel lblEmailAt;
		JLabel lblEmailConfirm;
		JLabel lblTel;
		JLabel lblTelHyphen1;
		JLabel lblTelHyphen2;
		JLabel lblBirthYear;
		JLabel lblBirthMonth;
		JLabel lblBirthDate;
		JLabel lblInfoAgreeEssen;
		JLabel lblInfoAgreeSelec;

		JPanel pnlId;
		JPanel pnlPW;
		JPanel pnlPWConfirm;
		JPanel pnlName;
		JPanel pnlEmail;
		JPanel pnlEmailConfirm;
		JPanel pnlTel;
		JPanel pnlBirth;
		JPanel pnlInfoAgree;
		JPanel pnlComplete;

		JScrollPane scrollInfoAgreeEssen;
		JScrollPane scrollInfoAgreeSelec;
		// 변수 초기화
		// 테스트용 입력

		// 레이아웃 설정
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbl);

		// 1번째 행 제목
		lblJoin = new JLabel("회원가입");
		lblJoin.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
		gbc.fill = GridBagConstraints.NORTH;
		gbc.insets = new Insets(20, 0, 10, 0);
		addGrid(gbl, gbc, lblJoin, 1, 1, 6, 1, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 0, 0);

		// 2번째 행 아이디
		lblId = new JLabel("아이디");
		addGrid(gbl, gbc, lblId, 1, 2, 1, 1, 1, 1);

		pnlId = new JPanel(new FlowLayout(FlowLayout.LEFT));

		tfId = new JTextField(8);
		lblIdWaring = new JLabel("");
		lblIdWaring.setName("아이디");
		lblIdWaring.setEnabled(false);
		;
		btnIdConfirm = new JButton("ID 확인");
		lblIdEx = new JLabel("아이디는 4~12자 이내");
		pnlId.add(tfId);
		pnlId.add(lblIdWaring);
		pnlId.add(btnIdConfirm);
		pnlId.add(lblIdEx);
		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlId, 2, 2, 1, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 3번째 행 비밀번호
		lblPw = new JLabel("비밀번호");
		addGrid(gbl, gbc, lblPw, 1, 3, 1, 1, 1, 1);

		pnlPW = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ptfPw = new JPasswordField(8);
		ptfPw.setName("비밀번호");

		lblPwWaring = new JLabel("");
		lblPwWaring.setName("비밀번호");
		lblPwWaring.setEnabled(false);

		lblPwEx = new JLabel("비밀번호는 8~13자 이내, 숫자와 영어 조합");
		pnlPW.add(ptfPw);
		pnlPW.add(lblPwWaring);
		pnlPW.add(lblPwEx);
		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlPW, 2, 3, 1, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 4번째 행 비밀번호 확인
		lblPwConfirm = new JLabel("비밀번호 확인");
		addGrid(gbl, gbc, lblPwConfirm, 1, 4, 1, 1, 1, 1);

		pnlPWConfirm = new JPanel(new FlowLayout(FlowLayout.LEFT));
		ptfPwConfirm = new JPasswordField(8);
		ptfPwConfirm.setName("비밀번호 확인");

		lblPwConfirmWaring = new JLabel("");
		lblPwConfirmWaring.setEnabled(false);
		lblPwConfirmWaring.setName("비밀번호 확인");

		lblPwExConfirm = new JLabel("위와 동일하게 입력");
		pnlPWConfirm.add(ptfPwConfirm);
		pnlPWConfirm.add(lblPwConfirmWaring);
		pnlPWConfirm.add(lblPwExConfirm);
		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlPWConfirm, 2, 4, 1, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 5번째 행 이름
		lblName = new JLabel("이 름");
		addGrid(gbl, gbc, lblName, 1, 5, 1, 1, 1, 1);
		tfName = new JTextField(8);

		pnlName = new JPanel(new FlowLayout(FlowLayout.LEFT));

		pnlName.add(tfName);
		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlName, 2, 5, 1, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 6번째 행 이메일
		lblEmail = new JLabel("이메일");
		addGrid(gbl, gbc, lblEmail, 1, 6, 1, 1, 1, 1);

		pnlEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));

		tfEmailAccount = new JTextField(8);
		lblEmailAt = new JLabel("@");
		tfEmailDomain = new JTextField(8);

		pnlEmail.add(tfEmailAccount);
		pnlEmail.add(lblEmailAt);
		pnlEmail.add(tfEmailDomain);
		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlEmail, 2, 6, 4, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 7번째 행 이메일 확인
		lblEmailConfirm = new JLabel("이메일 확인");
		addGrid(gbl, gbc, lblEmailConfirm, 1, 7, 1, 1, 1, 1);

		pnlEmailConfirm = new JPanel(new FlowLayout(FlowLayout.LEFT));

		btnEmailConfirm = new JButton("확인코드 발송");
		tfEmailConfirm = new JTextField(6);
		lblEmailConfirmWaring = new JLabel("");
		lblEmailConfirmWaring.setName("이메일 확인");
		lblEmailConfirmWaring.setEnabled(false);
		;
		btnEmailConfirmDone = new JButton("확인 완료");

		pnlEmailConfirm.add(btnEmailConfirm);
		pnlEmailConfirm.add(tfEmailConfirm);
		pnlEmailConfirm.add(lblEmailConfirmWaring);
		pnlEmailConfirm.add(btnEmailConfirmDone);

		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlEmailConfirm, 2, 7, 4, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 8번째 행 전화번호
		lblTel = new JLabel("전화번호");
		addGrid(gbl, gbc, lblTel, 1, 8, 1, 1, 1, 1);

		pnlTel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		tfTel1 = new JTextField("010", 3);
		lblTelHyphen1 = new JLabel("-");
		tfTel2 = new JTextField(5);
		lblTelHyphen2 = new JLabel("-");
		tfTel3 = new JTextField(5);

		pnlTel.add(tfTel1);
		pnlTel.add(lblTelHyphen1);
		pnlTel.add(tfTel2);
		pnlTel.add(lblTelHyphen2);
		pnlTel.add(tfTel3);
		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlTel, 2, 8, 4, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 9번째 행 생년월일
		lblBirthDate = new JLabel("생년월일");
		addGrid(gbl, gbc, lblBirthDate, 1, 9, 1, 1, 1, 1);

		pnlBirth = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tfBirthYear = new JTextField(4);
		lblBirthYear = new JLabel("년");
		tfBirthMonth = new JTextField(3);
		lblBirthMonth = new JLabel("월");
		tfBirthDate = new JTextField(3);
		lblBirthDate = new JLabel("일");

		pnlBirth.add(tfBirthYear);
		pnlBirth.add(lblBirthYear);
		pnlBirth.add(tfBirthMonth);
		pnlBirth.add(lblBirthMonth);
		pnlBirth.add(tfBirthDate);
		pnlBirth.add(lblBirthDate);

		gbc.anchor = GridBagConstraints.WEST;
		addGrid(gbl, gbc, pnlBirth, 2, 9, 4, 1, 1, 1);
		gbc.anchor = GridBagConstraints.CENTER;

		// 10번째 행
		lblInfoAgreeEssen = new JLabel("개인정보 동의 안내(필수)");
		addGrid(gbl, gbc, lblInfoAgreeEssen, 1, 10, 5, 1, 1, 1);

		// 11번째 행
		taInfoAgreeEssen = new JTextArea();
		taInfoAgreeEssen.setText(" 1. 수집하는 개인정보 : 이름, 이메일 \n 2. 목적  \n 예약자 확인, 예약확인 안내메일 발송 \n * 동의하지 않을 경우 회원가입 불가 ");
		taInfoAgreeEssen.setBorder(new LineBorder(Color.GRAY));
		taInfoAgreeEssen.setEditable(false);

		scrollInfoAgreeEssen = new JScrollPane(taInfoAgreeEssen);
		scrollInfoAgreeEssen.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbc.insets = new Insets(0, 20, 0, 20);
		gbc.fill = GridBagConstraints.BOTH;
		addGrid(gbl, gbc, scrollInfoAgreeEssen, 1, 11, 6, 1, 0, 0);

		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 0, 0);

		// 12번째 행
		lblInfoAgreeSelec = new JLabel("개인정보 동의 안내(선택)");
		addGrid(gbl, gbc, lblInfoAgreeSelec, 1, 12, 5, 1, 1, 1);

		// 13번째 행
		taInfoAgreeSelec = new JTextArea();
		taInfoAgreeSelec.setText(
				" 1. 수집하는 개인정보 : 생년월일, 전화번호 \n 2. 목적\n 예약자 확인문자 발송, 생일쿠폰 발송 \n * 동의하지 않을 경우 예약시간 문자 안내 및 생일 쿠폰 서비스 불가");
		taInfoAgreeSelec.setBorder(new LineBorder(Color.GRAY));
		taInfoAgreeSelec.setEditable(false);

		scrollInfoAgreeSelec = new JScrollPane(taInfoAgreeSelec);
		scrollInfoAgreeSelec.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		gbc.ipadx = 1;
		gbc.ipady = 1;
		gbc.insets = new Insets(0, 20, 0, 20);
		gbc.fill = GridBagConstraints.BOTH;
		addGrid(gbl, gbc, scrollInfoAgreeSelec, 1, 13, 6, 1, 1, 1);

		gbc.fill = GridBagConstraints.NONE;
		gbc.insets = new Insets(0, 0, 0, 0);

		// 14번째 행
		pnlInfoAgree = new JPanel(new FlowLayout(FlowLayout.CENTER));
		cbxInfoAgreeEssen = new JCheckBox("개인정보 동의(필수)");
		cbxInfoAgreeSelec = new JCheckBox("개인정보 동의(선택)");

		pnlInfoAgree.add(cbxInfoAgreeEssen);
		pnlInfoAgree.add(cbxInfoAgreeSelec);

		addGrid(gbl, gbc, pnlInfoAgree, 1, 14, 5, 1, 1, 1);

		// 15번째 행
		pnlComplete = new JPanel(new FlowLayout(FlowLayout.CENTER));

		btnComplete = new JButton("완료");
		btnCancel = new JButton("취소");

		pnlComplete.add(btnComplete);
		pnlComplete.add(btnCancel);

		addGrid(gbl, gbc, pnlComplete, 1, 15, 5, 1, 1, 1);
		this.setVisible(true);
		event();
	}

	public boolean isIdOverlap() { // 동일한 아이디가 있으면 true, 없으면 false
		boolean result = false;
		String inputId = tfId.getText();
		Object temp = null;
		try {
			login.getOos().writeObject(new LoginDTO(inputId, Status.CHECK_MY_ID));
			login.getOos().flush();
			while (true) {
				temp = login.getOis().readObject();
				if (temp instanceof LoginDTO) {
					LoginDTO loginDTO = (LoginDTO) temp;
					if (loginDTO.getStatus() == Status.FAILURE) {
						result = true;
						break;
					} else if (loginDTO.getStatus() == Status.CHECK_MY_ID) {
						break;
					}
				}
			}
		} catch (EOFException e) {
			temp = null;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean isIdValidation() { // 아이디 유효성 검사, 유효하지 않으면 false 반환 // pw랑 생각 좀 필요
		boolean idV = false;
		idV = (tfId.getText().length() >= 4 && tfId.getText().length() <= 12);
		return idV;
	}

	public boolean isPwValidation() { // 패스워드 유효성 검사, 유효하지 않으면 false 반환 // 나눌 필요 있음

		boolean pwV = false;
		char[] currentPW = ptfPw.getPassword(); // 현재까지 입력된 패스워드 get
		int pWLength = currentPW.length; // 패스워드 길이 get, 숫자알파벳 변수 선언
		int countNumber = 0;
		int countAlphabet = 0;

		for (char charNum : currentPW) {
			if (charNum >= 48 && charNum <= 57) {
				countNumber++;
			} else if (charNum >= 65 && charNum <= 90) {
				countAlphabet++;
			} else if (charNum >= 97 && charNum <= 122) {
				countAlphabet++;
			}
		}
		// 1. 숫자 있는지 체크 2. 알파벳 있는지 체크 3. 길이가 적합한지 체크
		pwV = (pWLength >= 8 && pWLength <= 13 && countNumber >= 1 && countAlphabet >= 1) ? true : false;

		return pwV;
	}

	public boolean isNameValidation() { // 이름 유효성 검사, 유효하지 않으면 false 반환
		boolean nameV = false;
		nameV = (tfName.getText().length() >= 1 && tfName.getText().length() <= 12);
		return nameV;
	}

	public boolean isTelValidation() { // 전화번호 유효성 검사, 유효하지 않으면 false 반환 , 아직 적용 안됨
		boolean telV = false;
		telV = ((tfTel1.getText().length() >= 3 && tfTel1.getText().length() <= 3)
				&& (tfTel2.getText().length() >= 3 && tfTel2.getText().length() <= 4)
				&& (tfTel3.getText().length() >= 4 && tfTel3.getText().length() <= 4));
		return telV;
	}

	public boolean isPwConfirm() { // 두개의 입력한 패스워드가 동일한지 체크, 다르면 false 반환

		boolean pWC = false;
		char[] currentPW = ptfPw.getPassword();
		char[] confirmPW = ptfPwConfirm.getPassword();

		if (currentPW.length == confirmPW.length) {
			int i = 0;
			for (char charNum : confirmPW) {
				if (charNum == currentPW[i]) {
					pWC = true;
					i++;
				} else {
					pWC = false;
					break;
				}
			}
		}
		return pWC;
	}

	public void sendEmail(String[] mailAddresses, String fromEmail, String fromName, String subject, String content) {

		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.gmail.com"); // 지메일
		props.put("mail.smtp.port", "587"); // tls용 지메일 포트번호
		props.put("mail.smtp.user", "bitProject.cafe"); // 보내는 사람 이름? 역할이 뭔지 모르겠음
		props.put("mail.smtp.auth", "true");

		try {
			Authenticator cafeAccount = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("aquavictoria2", "fkatptm4"); // 보낼 지메일 계정
				}
			};

			Session mailSession = Session.getInstance(props, cafeAccount);
			Message msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress(fromEmail, MimeUtility.encodeText(fromName, "B", "UTF-8"))); // 보내는 사람 설정

			int mailCount = mailAddresses.length;
			InternetAddress[] addresses = new InternetAddress[mailCount];
			for (int i = 0; mailCount > i; i++) {
				addresses[i] = new InternetAddress(mailAddresses[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date()); // 보내는 날짜 = 현재 시간
			msg.setContent(content, "text/html;charset=euc-kr"); // html 형식 내용설정

			Transport.send(msg); // 메일 보내기

		} catch (AddressException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	public String createEmailCode() { // 이메일 코드 생성
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i <= 6; i++) {
			if ((int) (Math.random() * 2) == 0) {
				buffer.append((char) ((int) (Math.random() * 10) + 48));
			} else {
				buffer.append((char) ((int) (Math.random() * 26) + 97));
			}
		}
		return buffer.toString();
	}

	public boolean isEmailConfirm() { // 이메일 코드가 동일한지 체크
		boolean emailConfirm = false;
		inEmailConfirmCode = tfEmailConfirm.getText();
		emailConfirm = (inEmailConfirmCode.equals(exEmailConfirmCode)) ? true : false;
		return emailConfirm;
	}

	public boolean isCompleteOk() { // 완료버튼 조건 여기다 다 주기
		// emailConfirm //true
		boolean completeOk = false; // 자동정렬하면 저따구로 정렬됨 ㅡㅡ
		completeOk = lblIdWaring.getText().equals("O") ? lblPwWaring.getText().equals("O")
				? lblPwConfirmWaring.getText().equals("O")
						? lblEmailConfirmWaring.getText().equals("O") ? cbxInfoAgreeEssen.isSelected() ? true : false
								: false
						: false
				: false : false;
		tfName.getText();
		tfEmailAccount.getText();
		tfEmailDomain.getText();
		tfTel1.getText();
		tfTel2.getText();
		tfTel3.getText();

		return completeOk;
	}

	public String whyImcomplet() { // 완료버튼 조건 여기다 다 주기
		// emailConfirm //true
		String imcompletReason = null;

		imcompletReason = lblIdWaring.getText().equals("O")
				? lblPwWaring.getText().equals("O")
						? lblPwConfirmWaring.getText().equals("O") ? lblEmailConfirmWaring.getText().equals("O")
								? cbxInfoAgreeEssen.isSelected() ? "" : cbxInfoAgreeEssen.getText()
								: lblEmailConfirmWaring.getName() : lblPwConfirmWaring.getName()
						: lblPwWaring.getName()
				: lblIdWaring.getName();

		return imcompletReason;
	}

	// 유틸리티 메서드

	private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c, int gridx, int gridy, int gridwidth,
			int gridheight, double weightx, double weighty) { // 그리드백레이아웃 생성용
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		add(c);
	}

	private void changelblOX(JLabel label, boolean ox) { // 라벨 OX 생성용
		if (ox) {
			label.setText("O");
			label.setForeground(Color.BLUE);
			label.setEnabled(true);
		} else {
			label.setText("X");
			label.setForeground(Color.RED);
			label.setEnabled(true);
		}
	}

	// 이벤트 추가

	public void event() {
		btnIdConfirm.addActionListener(this);
		ptfPw.addKeyListener(this);
		ptfPwConfirm.addKeyListener(this);
		btnEmailConfirm.addActionListener(this);
		btnEmailConfirmDone.addActionListener(this);
		btnCancel.addActionListener(this);
		btnComplete.addActionListener(this);
	}

	// 이벤트 처리

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getComponent().getName()) {
		case "비밀번호":
			changelblOX(lblPwWaring, isPwValidation());
			break;

		case "비밀번호 확인":
			changelblOX(lblPwConfirmWaring, isPwConfirm());
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) { // 버튼누를 시 버튼 이름에 따른 명령 발동
		switch (e.getActionCommand()) {
		case "ID 확인":
			changelblOX(lblIdWaring, (isIdValidation() && !isIdOverlap()));

			if (!isIdValidation()) {
				JOptionPane.showMessageDialog(this, "아이디가 유효하지 않습니다.");
				break;
			}
			if (isIdOverlap()) {
				JOptionPane.showMessageDialog(this, "아이디가 중복됩니다.");
				break;
			}
			JOptionPane.showMessageDialog(this, "사용하실 수 있는 아이디입니다.");
			break;
		case "확인코드 발송":
			exEmailConfirmCode = createEmailCode(); // 비번 받기
			String joinEmailAddress = tfEmailAccount.getText() + "@" + tfEmailDomain.getText(); // 이메일 받기
			sendEmail(new String[] { joinEmailAddress }, "aquavictoria2@gmail.com", tfId.getText(), "선홍유림 카페가입 확인코드 발송",
					exEmailConfirmCode);// 메일보내기
			JOptionPane.showMessageDialog(this, "작성하신 이메일로 확인코드를 발송했습니다.");
			btnEmailConfirm.setEnabled(false);
			break;
		case "확인 완료":
			if (isEmailConfirm()) {
				emailConfirm = true;
				changelblOX(lblEmailConfirmWaring, emailConfirm);
				JOptionPane.showMessageDialog(this, "이메일이 확인되셨습니다.");
				btnEmailConfirmDone.setEnabled(false);
			} else {
				emailConfirm = false;
				changelblOX(lblEmailConfirmWaring, emailConfirm);
				JOptionPane.showMessageDialog(this, "코드가 일치하지 않습니다.");
				btnEmailConfirm.setEnabled(true);
			}
			break;
		case "완료":
			if (isCompleteOk()) {
				// 완료 조건
				String id = tfId.getText();
				String pw = String.valueOf(ptfPw.getPassword());
				String name = tfName.getText();
				String emailAccount = tfEmailAccount.getText();
				String emailDomain = tfEmailDomain.getText();
				String tel1 = tfTel1.getText();
				String tel2 = tfTel2.getText();
				String tel3 = tfTel3.getText();
				int birthYear = Integer.parseInt(tfBirthYear.getText());
				int birthMonth = Integer.parseInt(tfBirthMonth.getText());
				int birthDate = Integer.parseInt(tfBirthDate.getText());
				boolean isAgreeEssen = cbxInfoAgreeEssen.isSelected();
				boolean isAgreeSelec = cbxInfoAgreeSelec.isSelected();

				MemberDTO member = new MemberDTO(id, pw, name, emailAccount, emailDomain, tel1, tel2, tel3, birthYear,
						birthMonth, birthDate, isAgreeEssen, isAgreeSelec);
				member.setStatus(Status.JOIN);
				Object temp = null;
				try {
					login.getOos().writeObject(member);
					login.getOos().flush();

					while (true) {
						temp = login.getOis().readObject();
						if (temp instanceof MemberDTO) {
							member = (MemberDTO) temp;
							if (member.getStatus() == Status.JOIN) {
								JOptionPane.showMessageDialog(this, "회원가입 성공");
								this.setVisible(false);
							} else if (member.getStatus() == Status.FAILURE) {
								JOptionPane.showMessageDialog(this, "회원가입 실패");
							}
						} else {
							return;
						}
					}
				} catch (EOFException eofe) {
					temp = null;
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}

			} else {
				System.out.println(whyImcomplet());
				switch (whyImcomplet()) {
				case "아이디":
					JOptionPane.showMessageDialog(this, "아이디를 확인해주세요.");
					break;
				case "비밀번호":
					JOptionPane.showMessageDialog(this, "비밀번호를 확인해주세요.");
					break;
				case "비밀번호 확인":
					JOptionPane.showMessageDialog(this, "비밀번호를 확인해주세요.");
					break;
				case "이메일 확인":
					JOptionPane.showMessageDialog(this, "이메일을 확인해주세요.");
					break;
				case "개인정보 동의(필수)":
					JOptionPane.showMessageDialog(this, "개인정보 동의(필수)를 확인해주세요.");
					break;
				default:
					JOptionPane.showMessageDialog(this, "필수사항을 모두 입력해주세요.");
					break;
				}
			}
			// 회원DTO에 넣기
			break;
		case "취소":
			this.setVisible(false);
			// 나가기
			break;

		}

	}

}
