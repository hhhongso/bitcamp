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
		JPanel p = new JPanel(new BorderLayout()); // ���ʿ� ���� �г��� �ٽ� �������̾ƿ� ��
//		GridBagLayout gbl = new GridBagLayout();
//		GridBagConstraints gbc = new GridBagConstraints();
//		p.setLayout(gbl);
		
		output = new JTextArea(); 
		output.setEditable(false); // �����Ұ�

		inputT = new JTextField(15); // p		
//		gbc.weightx = 1.0; // ���� ����
//		gbc.fill = GridBagConstraints.BOTH;
//		p.add(inputT, gbc);		
 		
		sendB = new JButton("������"); // p
//		gbc.weightx = 0.0; // ���� �������� ����
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
		//���� IP ��ƿ��� 
//		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���", "���� IP", JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this, "���� IP�� �Է��ϼ���", "192.168.0.60");

		if(serverIP == null || serverIP.length() == 0){	
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�.");
			System.exit(0);
		}

		//�г��� ��������
		String nickName = JOptionPane.showInputDialog(this, "�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0){
			nickName = "guest";
		}

		//���� �����ϱ�
		try{
			socket = new Socket(serverIP, 9500);			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

		//������ [�г���] ������ 
			pw.println(nickName); //���Ͱ����� ����
			pw.flush();

		}catch(UnknownHostException uhe){ 
			System.out.println("������ ã�� �� �����ϴ�..");
			uhe.printStackTrace();

		}catch(IOException ioe){
			System.out.println("������ ������� �ʾҽ��ϴ�..");
			ioe.printStackTrace();
		}

		sendB.addActionListener(this);
		inputT.addActionListener(this);
		Thread t = new Thread(this);
		t.start();	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e){		
// sendB�� ������, inputT���� enter�� ���� �� ������ �׼��� ���� => if�� ������ �ʿ� ����

		//������ [ä�ó���] ������
		pw.println(inputT.getText());
		pw.flush(); // ���۸� ����־�� �� ���� �����Ͱ� �� �� �ִ�! 
		inputT.setText("");
		
	}
	
	@Override
	public void run(){
		//�����κ��� �ޱ�
		String line; 
		while(true){ // ������� �ý����� ������ ������ ���ѹݺ�
			try{
				line = br.readLine();
										
			//���� ���� ��					//�ҹ��ڷ� �ٲ۴�.(protocol exit / EXIT / Exit ==> exit�� ������ �Ѵ�.) cf)Oracle: lower()
				if(line == null || line.toLowerCase().equals("exit")) { //null�� �� ��: exit�� ������ ����, Ŭ���̾�Ʈ�� null�� �Ǵµ�, ������� ���� �ش� Ŭ���̾�Ʈ�� �� �� 
					br.close();
					pw.close();
					socket.close();
					System.exit(0);
				}
				output.append(line + "\n"); // readLine�� ���Ͱ� �������� �о�� => �������� �Ѿ�� ���Ͱ� �Է����־��. 	
				
				//��ũ�ѹ� �ڵ� ���󰡱�
				int pos = output.getText().length();
				output.setCaretPosition(pos); // output �ȿ� �ִ� ���ڼ��� ����Ͽ� scrollbar�� position
	
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}//������ while
	}

	public static void main(String[] args) {
		new ChatClient().service();
	}
}
