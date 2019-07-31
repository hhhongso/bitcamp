import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;

import java.io.IOException;

class ChatServer {
	private ServerSocket ss;
	private ArrayList<ChatHandler> list; // chatHandler의 갯수 = Client 의 갯수  

	public ChatServer(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("서버 준비완료...");
			
			list = new ArrayList<ChatHandler>();
			//클라이언트가 들어올 때마다 accept하여 소켓을 만든다. 
			while(true){
				Socket socket = ss.accept();
				if(socket != null) System.out.println("접속되었습니다 !");

				//스레드 생성, 시작
				ChatHandler handler = new ChatHandler(socket, list); // 소켓, 클라이언트의 갯수를 모두 알아야 몇 개의 클라이언트왕 연결되었는지 알 수 있다. 
				

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
