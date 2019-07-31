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
			//1. 닉네임 읽어오기 
			String nickName = br.readLine();
			broadcast(nickName + "님이 입장하였습니다. "); // 연결된 모든 클라이언트에게 보내기 

			//2. 채팅내용 읽어오기
			String line;
			while(true){
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("exit")){ // 닫은 클라이언트에 해당하는 핸들러만 close하고, 나머지는 exit msg  
					break;
					
				}
				broadcast("[" + nickName + "] " + line);


			} //while

			//exit를 클라이언트에게 보내고, 핸들러 끊고, list.remove();
			pw.println("exit");
			pw.flush();
			list.remove(this);
			broadcast(nickName + "님이 퇴장하였습니다." );

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
