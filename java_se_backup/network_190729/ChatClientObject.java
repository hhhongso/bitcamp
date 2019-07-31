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
		sendB = new JButton("������"); // p			

		output.setEditable(false); // �����Ұ�
		JPanel p = new JPanel(new BorderLayout()); // ���ʿ� ���� �г��� �ٽ� �������̾ƿ� ��

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
		

		
	}//������
//==========================================================================================================================================
	public void service(){
		//1. ���� IP �Է� 
		
			String serverIP = JOptionPane.showInputDialog(this, "IP�� �Է��ϼ���", "192.168.0.60");		

			if(serverIP == null || serverIP.length() == 0) {
				System.out.println("������ ������ �Է����ּ���. ");
				System.exit(0);
			}

		//2. �г��� �Է�	
			String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���");
			if(nickName == null || nickName.length() == 0) {nickName = "guest";}
			dto.setNickname(nickName);			//dto.setCommand(Info.JOIN);			
			
		//3. ���� ����	
		try{
			socket = new Socket(serverIP, 9500);
			oos = new ObjectOutputStream(socket.getOutputStream()); // ��ü�� outputStream�� ������ ���� !! 
			ois = new ObjectInputStream(socket.getInputStream());		

		//4. �г��� ������ ������
			oos.writeUTF(nickName);
			oos.flush();		



		sendB.addActionListener(this);
		inputT.addActionListener(this);

		}catch(UnknownHostException uhe){ 
			System.out.println("������ ã�� �� �����ϴ�..");
			uhe.printStackTrace();

		}catch(IOException ioe){
			System.out.println("������ ������� �ʾҽ��ϴ�..");
			ioe.printStackTrace();
		}	

		Thread t = new Thread(this);
		t.start();

	} // service

	@Override
	public void actionPerformed(ActionEvent e) {
	
		//�޼��� ������ :command is... JOIN, EXIT, SEND, SECRET
		
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
		//�г��� �о����
		try{
			nickName = ois.readUTF();
			output.append(nickName);
			while(true){		
				System.out.println("client while��");
				
					//ä�ó��� �о������ 
					int count = ois.readInt();
					System.out.println("client while��" + count);
					
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
			//��ũ�ѹ� �ڵ� ���󰡱�
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
