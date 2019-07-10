package kr.co.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerEx02 {
	
	List<SocketThread> list = new ArrayList<SocketThread>();
	
	public ServerEx02() {
		try {
			ServerSocket server = new ServerSocket(10002);
			
			while(true) {
				Socket sock = server.accept();
				InetAddress inetAddr = sock.getInetAddress();
				System.out.println(inetAddr.getHostAddress() +"로부터 접속했습니다. ");
				SocketThread st = new SocketThread(sock);
				list.add(st);
				st.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new ServerEx02(); 
	}
}
