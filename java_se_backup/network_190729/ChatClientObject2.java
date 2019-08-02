import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.EOFException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;


class ChatClientObject2 extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField inputT;	
	private JButton sendB;
	
	private ObjectInputStream ois; 
	private ObjectOutputStream oos; 
	private Socket socket;

	public ChatClientObject2(){	
		output = new JTextArea(); 
		inputT = new JTextField(15); // p	
		sendB = new JButton("보내기"); // p			

		output.setEditable(false); // 편집불가
		JPanel p = new JPanel(new BorderLayout()); // 남쪽에 붙일 패널을 다시 보더레이아웃 잠

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
				try{
					if(oos == null || ois == null) System.exit(0);

					InfoDTO dto = new InfoDTO();
					dto.setCommand(Info.EXIT);
					oos.writeObject(dto);
					oos.flush();
				
				}catch(IOException ioe){
					ioe.printStackTrace();
				}
			}
		});
		

		
	}//생성자
//==========================================================================================================================================
	public void service(){
		//1. 서버 IP 입력 
		
			String serverIP = JOptionPane.showInputDialog(this, "IP를 입력하세요", "192.168.0.60");		

			if(serverIP == null || serverIP.length() == 0) {
				System.out.println("연결할 서버를 입력해주세요. ");
				System.exit(0);
			}

		//2. 닉네임 입력	
			String nickName = JOptionPane.showInputDialog(this, "닉네임을 입력하세요");
			if(nickName == null || nickName.length() == 0) {nickName = "guest";}		
			
		//3. 소켓 생성	
		try{
			socket = new Socket(serverIP, 9500);
			// 객체 송수신 시에는 outputStream이 무조건 먼저 !! 
			oos = new ObjectOutputStream(socket.getOutputStream()); 
			ois = new ObjectInputStream(socket.getInputStream());		

		//4. 닉네임 서버에 보내기 : 지역변수로 잡아야 계속 값을 변경시킬 수 있다. 
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickname(nickName);
			oos.writeObject(dto);
			oos.flush();


		sendB.addActionListener(this);
		inputT.addActionListener(this);

		}catch(UnknownHostException uhe){ 
			System.out.println("서버를 찾을 수 없습니다..");
			uhe.printStackTrace();

		}catch(IOException ioe){
			System.out.println("서버가 연결되지 않았습니다..");
			ioe.printStackTrace();
		}	

		Thread t = new Thread(this);
		t.start();

	} // service

	@Override
	public void actionPerformed(ActionEvent e) {
	
		//메세지 서버로 보내기 :command is... JOIN, EXIT, SEND, SECRET
		
		String message = inputT.getText();
		InfoDTO dto = new InfoDTO();
		if(message.toLowerCase().equals("exit")){
			dto.setCommand(Info.EXIT);
		} else {
			dto.setCommand(Info.SEND);
			dto.setMessage(message);
		}
		try{
			oos.writeObject(dto);
			oos.flush();
			inputT.setText("");
		
		}catch(IOException ioe){
			ioe.printStackTrace();
		}		
				
	}

	@Override 
	public void run(){
		//읽어오기
		InfoDTO dto = null; // new할 필요 없음: handelr로부터 받는 내용이 dto 니까 

			while(true){
				try{
					dto = (InfoDTO) ois.readObject();	

					if(dto.getCommand() == Info.EXIT){
						oos.close();
						ois.close();
						socket.close();
						System.exit(0);

					} else if(dto.getCommand() == Info.SEND){
						output.append(dto.getMessage()+"\n");
					}				
				//스크롤바 자동 따라가기
				int pos = output.getText().length();
				output.setCaretPosition(pos);

				}catch(IOException ioe){
					ioe.printStackTrace();
				}catch(ClassNotFoundException cnfe){
					cnfe.printStackTrace();
				}
			}// while
		}

//=================================================================================================================================================
	public static void main(String[] args) {
		new ChatClientObject2().service();
	}
}
