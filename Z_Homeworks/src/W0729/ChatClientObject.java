package W0729;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.EOFException;

import java.io.ObjectInputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.IOException;


class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField inputT;	
	private JButton sendB;
	
	private ObjectInputStream ois; 
	private ObjectOutputStream oos; 
	private Socket socket;
	private InfoDTO dto = new InfoDTO();

	public ChatClientObject(){	
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
					oos.writeObject(Info.EXIT);
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
			dto.setNickname(nickName);			//dto.setCommand(Info.JOIN);			
			
		//3. 소켓 생성	
		try{
			socket = new Socket(serverIP, 9500);
			oos = new ObjectOutputStream(socket.getOutputStream()); // 객체는 outputStream이 무조건 먼저 !! 
			ois = new ObjectInputStream(socket.getInputStream());		

		//4. 닉네임 서버에 보내기
			oos.writeUTF(nickName);
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
	
		//메세지 보내기 :command is... JOIN, EXIT, SEND, SECRET
		
		String message = inputT.getText();
		String nickName = dto.getNickname();
		System.out.println(nickName);

		try{
			oos.writeObject(new InfoDTO(dto.getNickname(), message, Info.SEND));
			oos.flush();
			inputT.setText("");
		
		}catch(IOException ioe){
			ioe.printStackTrace();
		}		
		
		
	}

	@Override 
	public void run(){
		String nickName=null; 
		//닉네임 읽어오기
		try{
			nickName = ois.readUTF();
			output.append(nickName);
			while(true){		
				System.out.println("client while후");
				
					//채팅내용 읽어오ㄴ기 
					int count = ois.readInt();
					System.out.println("client while후" + count);
					
					for(int i = 0; i < count; i++){
						dto = (InfoDTO) ois.readObject();
						output.append(dto.toString());
					}

				if(dto == null || dto.getCommand().equals(Info.EXIT)){
					oos.close();
					ois.close();
					socket.close();
					System.exit(0);
				}
			//스크롤바 자동 따라가기
				int pos = output.getText().length();
				output.setCaretPosition(pos);
			}// while

			

			}catch(IOException ioe){
				ioe.printStackTrace();
			}catch(ClassNotFoundException cnfe){
				cnfe.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("CcCCCCCCC");
			}
		

		}

//=================================================================================================================================================
	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}
