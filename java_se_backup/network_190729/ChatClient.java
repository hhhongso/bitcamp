import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.Socket;
import java.net.UnknownHostException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.IOException;


class ChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField inputT;	
	private JButton sendB;
	private Socket socket; 
	private BufferedReader br; 
	private PrintWriter pw; 

	public ChatClient(){		
		JPanel p = new JPanel(new BorderLayout()); // 남쪽에 붙일 패널을 다시 보더레이아웃 잠
//		GridBagLayout gbl = new GridBagLayout();
//		GridBagConstraints gbc = new GridBagConstraints();
//		p.setLayout(gbl);
		
		output = new JTextArea(); 
		output.setEditable(false); // 편집불가

		inputT = new JTextField(15); // p		
//		gbc.weightx = 1.0; // 여백 독점
//		gbc.fill = GridBagConstraints.BOTH;
//		p.add(inputT, gbc);		
 		
		sendB = new JButton("보내기"); // p
//		gbc.weightx = 0.0; // 여백 지정하지 않음
//		p.add(sendB, gbc);
		
//		gbl.setConstraints(p, gbc);

		p.add("Center", inputT);
		p.add("East", sendB);

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		Container con = this.getContentPane();
		con.add("Center", scroll);
		con.add("South", p);

		setBounds(700, 100, 300, 300);
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				pw.println("exit");
				pw.flush();
			}
		});


	}//constructor

	public void service() {
		//서버 IP 잡아오기 
//		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요", "서버 IP", JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this, "서버 IP를 입력하세요", "192.168.0.60");

		if(serverIP == null || serverIP.length() == 0){	
			System.out.println("서버IP가 입력되지 않았습니다.");
			System.exit(0);
		}

		//닉네임 가져오기
		String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0){
			nickName = "guest";
		}

		//소켓 생성하기
		try{
			socket = new Socket(serverIP, 9500);			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		//서버로 [닉네임] 보내기 
			pw.println(nickName); //엔터값까지 포함
			pw.flush();

		}catch(UnknownHostException uhe){ 
			System.out.println("서버를 찾을 수 없습니다..");
			uhe.printStackTrace();

		}catch(IOException ioe){
			System.out.println("서버가 연결되지 않았습니다..");
			ioe.printStackTrace();
		}

		sendB.addActionListener(this);
		inputT.addActionListener(this);
		Thread t = new Thread(this);
		t.start();	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e){		
// sendB를 누를때, inputT에서 enter를 누를 때 동일한 액션을 수행 => if로 나눠줄 필요 없음

		//서버로 [채팅내용] 보내기
		pw.println(inputT.getText());
		pw.flush(); // 버퍼를 비워주어야 그 다음 데이터가 들어갈 수 있다! 
		inputT.setText("");
		
	}
	
	@Override
	public void run(){
		//서버로부터 받기
		String line; 
		while(true){ // 스레드는 시스템이 종료할 때까지 무한반복
			try{
				line = br.readLine();
										
			//연결 끊을 때					//소문자로 바꾼다.(protocol exit / EXIT / Exit ==> exit로 보도록 한다.) cf)Oracle: lower()
				if(line == null || line.toLowerCase().equals("exit")) { //null이 뜰 때: exit를 누르고 나서, 클라이언트는 null이 되는데, 스레드로 인해 해당 클라이언트로 올 때 
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				}
				output.append(line + "\n"); // readLine은 엔터값 전까지만 읽어옴 => 다음으로 넘어가게 엔터값 입력해주어야. 	
				
				//스크롤바 자동 따라가기
				int pos = output.getText().length();
				output.setCaretPosition(pos); // output 안에 있는 글자수를 계산하여 scrollbar를 position
	
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}//스레드 while
	}

	public static void main(String[] args) {
		new ChatClient().service();
	}
}
