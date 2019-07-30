import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.net.Socket;
import java.net.ServerSocket;
//import java.net.UnknownHostException; 이쪽이 서버니까 호스트 에러는 걸리지 않음.

class ProtocolServer {
	private ServerSocket ss;
	private BufferedReader br; 
	private BufferedWriter bw; 
	private Socket socket;

	public ProtocolServer(){
		try{
			ss = new ServerSocket(9500); // 접근할 포트번호에서 기다린다. 
			System.out.println("서버 준비 완료. 대기중");

	//		while(): 다중 클라이언트일 때 ==> 스레드 
			socket = ss.accept(); // 클라이언트가 들어오면 낚아채어, 소켓을 생성한다. 
			if(socket != null) System.out.println("접속!");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch(IOException e){
			System.out.println("클라이언트와 연결이 되지 않을 때");
			e.printStackTrace();
			System.exit(0);
		}

//대화식에서, 클라이언트가 주도권을 가짐. 
		String line, msg;
		while(true){
			try{
				//서버측에서 보내는 내용을 받는 쪽
				line = br.readLine();

				//응답(보내는) 쪽 
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) {
					msg = ar[1] + "님 입장..." + "\n"; //엔터를 꼭 해줘야 해!
					bw.write(msg);
					bw.flush();

				} else if(ar[0].equals(Protocol.EXIT)){
					msg = ar[1] + "님 퇴장..."+ "\n";
					bw.write(msg);
					bw.close();
					br.close();
					socket.close();
					System.exit(0);

				} else if(ar[0].equals(Protocol.SEND_MESSAGE)){
					msg = "[" + ar[1] + "]" + ar[2] + "\n";					
					bw.write(msg);
					bw.flush();

				}
			} catch(IOException e){
				e.printStackTrace();
				System.exit(0);
			}
		}//while


	}//생성자
	public static void main(String[] args) {
		new ProtocolServer();

	}
}


/*
실행 순서 
1. 서버 실행 
2. ServerSocket:1) 클라이언트가 접근하기를 기다린다. 
				2) 클라이언트가 접근하면, 클라이언트를 낚아채서 클라이언트와 연결할 소켓을 생성한다. (accept) 

*/