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
			
		//3. ���� ����	
		try{
			socket = new Socket(serverIP, 9500);
			// ��ü �ۼ��� �ÿ��� outputStream�� ������ ���� !! 
			oos = new ObjectOutputStream(socket.getOutputStream()); 
			ois = new ObjectInputStream(socket.getInputStream());		

		//4. �г��� ������ ������ : ���������� ��ƾ� ��� ���� �����ų �� �ִ�. 
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickname(nickName);
			oos.writeObject(dto);
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
	
		//�޼��� ������ ������ :command is... JOIN, EXIT, SEND, SECRET
		
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
		//�о����
		InfoDTO dto = null; // new�� �ʿ� ����: handelr�κ��� �޴� ������ dto �ϱ� 

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
				//��ũ�ѹ� �ڵ� ���󰡱�
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
