import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

import java.io.IOException;

class ChatServerObject2 {
	private ServerSocket ss; 
	private Socket socket;
	private ArrayList<ChatHandlerObject2> list;

	public ChatServerObject2(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("���� ��� ���Դϴ�..");
			list = new ArrayList<ChatHandlerObject2>();

			while(true){
				socket = ss.accept();
				if(socket != null) System.out.println("���ӵǾ����ϴ�!");

				ChatHandlerObject2 handler = new ChatHandlerObject2(socket, list);

				list.add(handler);
				System.out.println(list.size());
				handler.start();
			}

			
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
//=============================================================================================
	public static void main(String[] args) {
		new ChatServerObject2();
	}
}
