import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.net.UnknownHostException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.InetAddress;

class ProtocolClient {
	private Socket socket; 
	private BufferedReader br; 
	private BufferedWriter bw; 
	private BufferedReader keyboard; 

	public ProtocolClient(){
		try{
		InetAddress local = InetAddress.getLocalHost();
		socket = new Socket("192.168.0.60", 9500); // IP는 내IP, port번호는 9500 으로 지정해보자.
		
		//IO											//시작점:socket
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		}catch(UnknownHostException e){
			System.out.println("서버를 찾을 수 없을 때");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("서버와 연결이 되지 않을 때");
			e.printStackTrace();
			System.exit(0);
		}

		String msg, line;
		while(true){
			try{
				//서버에게 보내는 쪽
				msg = keyboard.readLine();
				bw.write(msg + "\n"); // 서버로 보내기
				bw.flush(); //버퍼 비우기 => 다음 데이터가 들어올 수 있도록 함. 

				//서버로부터 받는 쪽
				line = br.readLine(); // readLine()은 엔터를 친 곳 까지를 한 문장으로 본다.
				System.out.println(line);


	//			문자열을 일정 기준으로 쪼갤 때: split(), StringTokenizer
				//나갈 때는 IO와 소켓을 끊어주어야 한다.
				String[] ar = msg.split(":");
				if(ar[0].equals(Protocol.EXIT)) {
					br.close();
					bw.close();
					keyboard.close();
					socket.close();
					System.exit(0);
				}
			}catch(IOException e){
				e.printStackTrace();
			}

		}//while

		
	} //생성자


	public static void main(String[] args) {
		new ProtocolClient();

	}
}
