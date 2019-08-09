package bitProject.cafe.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import bitProject.cafe.dao.Status;
import bitProject.cafe.dto.LoginDTO;
import bitProject.cafe.dto.MemberDTO;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = -883731442213980503L;
	private static final String SERVER_IP = "192.168.0.60";
	private static final int PORT = 10200;

	private JButton btnLogin;
	private JButton btnClear;
	private JButton btnJoin;
	private JButton btnFind;

	private ButtonGroup btnGroupLogin;
	private JRadioButton rbtnStaff;
	private JRadioButton rbtnClient;

	private JTextField tfId;
	private JPasswordField ptfPw;

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public Login() {
		// 제목, 틀 생성 및 배치 시작
		this.setLayout(null);
		this.setSize(475, 200);
		this.setLocationRelativeTo(null);
		Container c = this.getContentPane();
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 제목, 틀 생성 및 배치 종료
		JLabel lblId;
		JLabel lblPw;

		// 로그인 라벨, 필드 생성 및 배치 시작
		btnGroupLogin = new ButtonGroup();

		btnLogin = new JButton("로그인");
		btnClear = new JButton("다시입력");
		btnJoin = new JButton("회원가입");
		btnFind = new JButton("ID/PW찾기");

		lblId = new JLabel("●  아이디");
		lblPw = new JLabel("●  비밀번호");

		tfId = new JTextField(30);
		ptfPw = new JPasswordField(30);
		rbtnStaff = new JRadioButton("Staff", false);
		rbtnClient = new JRadioButton("Client", true);

		btnGroupLogin.add(rbtnStaff);
		btnGroupLogin.add(rbtnClient);

		btnLogin.setBounds(30, 115, 95, 30);
		btnClear.setBounds(135, 115, 95, 30);
		btnJoin.setBounds(240, 115, 95, 30);
		btnFind.setBounds(345, 115, 95, 30);
		lblId.setBounds(40, 30, 100, 30);
		lblPw.setBounds(40, 60, 100, 30);
		tfId.setBounds(135, 30, 200, 30);
		ptfPw.setBounds(135, 60, 200, 30);
		rbtnStaff.setBounds(370, 30, 100, 30);
		rbtnClient.setBounds(370, 60, 100, 30);

		c.add(lblId);
		c.add(lblPw);
		c.add(tfId);
		c.add(ptfPw);
		c.add(rbtnStaff);
		c.add(rbtnClient);
		c.add(btnLogin);
		c.add(btnClear);
		c.add(btnJoin);
		c.add(btnFind);

		connectToServer();

		// 로그인 라벨, 필드 생성 및 배치 종료
		this.setVisible(true);
		addEvent();
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object temp = null;
				try {
					oos.writeObject(new LoginDTO("", Status.FAILURE));
					oos.flush();
					while (true) {
						temp = ois.readObject();
						if (temp instanceof LoginDTO) {
							LoginDTO loginDTO = (LoginDTO) temp;
							if (loginDTO.getStatus() == Status.FAILURE) {
								oos.close();
								ois.close();
								socket.close();
								System.exit(0);
							}
						}
					}
				} catch (EOFException eofe) {
					temp = null;
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			String inputId = tfId.getText();
			String inputPw = String.valueOf(ptfPw.getPassword());
			LoginDTO login = new LoginDTO(inputId, inputPw, Status.LOGIN);
			Object temp = null;

			try {
				oos.writeObject(login);
				oos.flush();

				while (true) {
					try {
						temp = ois.readObject();
						if (temp instanceof MemberDTO) {
							MemberDTO member = (MemberDTO) temp;
							if (member.getStatus() == Status.LOGIN) {
								ClientFrame cf = new ClientFrame(member);
								cf.setVisible(true);
								this.setVisible(false);
								break;
							} else {
								return;
							}
						} else {
							return;
						}
					} catch (EOFException e1) {
						temp = null;
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == btnJoin) {
			new Join(this);
		}
	}

	public void connectToServer() {
		try {
			socket = new Socket(SERVER_IP, PORT);
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addEvent() {
		btnLogin.addActionListener(this);
		btnClear.addActionListener(this);
		btnJoin.addActionListener(this);
		btnFind.addActionListener(this);
	}

	public void clear() {
		tfId.setText("");
		ptfPw.setText("");
	}

	public ObjectInputStream getOis() {
		return ois;
	}

	public ObjectOutputStream getOos() {
		return oos;
	}
}
