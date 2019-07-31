import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.net.Socket;
import java.util.ArrayList;


class ChatHandler extends Thread {
	private BufferedReader br; 
	private PrintWriter pw; 
	private Socket socket;
	private ArrayList<ChatHandler> list;

	public ChatHandler(Socket socket, ArrayList<ChatHandler> list) throws IOException {
		this.socket = socket; 
		this.list = list; 		
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		
	}

	@Override
	public void run(){
		try{
			//1. �г��� �о���� 
			String nickName = br.readLine();
			broadcast(nickName + "���� �����Ͽ����ϴ�. "); // ����� ��� Ŭ���̾�Ʈ���� ������ 

			//2. ä�ó��� �о����
			String line;
			while(true){
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("exit")){ // ���� Ŭ���̾�Ʈ�� �ش��ϴ� �ڵ鷯�� close�ϰ�, �������� exit msg  
					break;
					
				}
				broadcast("[" + nickName + "] " + line);


			} //while

			//exit�� Ŭ���̾�Ʈ���� ������, �ڵ鷯 ����, list.remove();
			pw.println("exit");
			pw.flush();
			list.remove(this);
			broadcast(nickName + "���� �����Ͽ����ϴ�." );

			br.close();
			pw.close();
			socket.close();

		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}

	public void broadcast(String msg){
		for(ChatHandler handler : list){
			handler.pw.println(msg);
			handler.pw.flush();
		}
	}
}
