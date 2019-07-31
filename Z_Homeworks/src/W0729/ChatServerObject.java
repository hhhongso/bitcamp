package W0729;

import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

import java.io.IOException;

class ChatServerObject {
	private ServerSocket ss; 
	private Socket socket;
	private ArrayList<ChatHandlerObject> list;

	public ChatServerObject(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("접속 대기 중입니다..");
			list = new ArrayList<ChatHandlerObject>();

			while(true){
				socket = ss.accept();
				if(socket != null) System.out.println("접속되었습니다!");

				ChatHandlerObject handler = new ChatHandlerObject(socket, list);

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
		new ChatServerObject();
	}
}
