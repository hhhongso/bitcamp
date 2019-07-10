package kr.co.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		try {
			//1. 서버 소켓 생성 
			ServerSocket server = new ServerSocket(10002);
			System.out.println("Waiting Connect....");
			
			//2. 서버 소켓의 accept() 메소드를 통해 클라이언트 접속을 대기 
			//	클라이언트가 접속할 경우, accept() 메소드는 소켓을 리턴함. 
			Socket sock = server.accept();
			InetAddress inetAddr = sock.getInetAddress();
			System.out.println(inetAddr.getHostAddress() + "로부터 접속했습니다. ");
			
			//3. 반환받은 소켓으로부터 inputStream, outputStream 을 구현 
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null; 
			
			//4. readLine() 메소드를 이용하여 클라이언트가 보내는 문자열을 한 줄 읽어들여 출력 
			while((line = br.readLine()) != null) {
				System.out.println("클라이언트로부터 전달받은 문자열: " + line);
				
				//5. 클라이언트 쪽으로 문자열 전송 
				pw.println("여기는 홍소연 서버입니다. ");
				pw.flush();
			}
			pw.close();
			br.close();
			sock.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
