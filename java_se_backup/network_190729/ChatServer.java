import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

import java.io.IOException;

class ChatServer {
	private ServerSocket ss;
	private ArrayList<ChatHandler> list; // chatHandler�� ���� = Client �� ����  

	public ChatServer(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("���� �غ�Ϸ�...");
			
			list = new ArrayList<ChatHandler>();
			//Ŭ���̾�Ʈ�� ���� ������ accept�Ͽ� ������ �����. 
			while(true){
				Socket socket = ss.accept();
				if(socket != null) System.out.println("���ӵǾ����ϴ� !");

				//������ ����, ����
				ChatHandler handler = new ChatHandler(socket, list); // ����, Ŭ���̾�Ʈ�� ������ ��� �˾ƾ� �� ���� Ŭ���̾�Ʈ�� ����Ǿ����� �� �� �ִ�. 
				

				list.add(handler);
				handler.start();
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new ChatServer();
	}
}
