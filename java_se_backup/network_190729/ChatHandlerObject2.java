
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.io.IOException;

class ChatHandlerObject2 extends Thread implements java.io.Serializable {
	private ServerSocket ss; 
	private Socket socket;
	private ArrayList<ChatHandlerObject2> list;
	private ObjectInputStream ois; 
	private ObjectOutputStream oos;


	public ChatHandlerObject2(Socket socket, ArrayList<ChatHandlerObject2> list) throws IOException{
		this.socket = socket; 
		this.list = list; 		

		oos = new ObjectOutputStream(socket.getOutputStream());		
		ois = new ObjectInputStream(socket.getInputStream());
		
	}

	@Override
	public void run(){
		
		try{			
			while(true){
				InfoDTO dto = null; // 받는 쪽 
				String nickName =null;
				dto = (InfoDTO) ois.readObject();

				if(dto.getCommand() == Info.JOIN){
					nickName = dto.getNickname();
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND); //JOIN을 받고, SEND를 보낸다.
					sendDTO.setMessage(nickName + "님 입장하였습니다. ");
					broadcast(sendDTO);
					 
				} else if(dto.getCommand() == Info.SEND) {
					nickName = dto.getNickname();
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND); //JOIN을 받고, SEND를 보낸다.
					sendDTO.setMessage(dto.getNickname() + ":" + dto.getMessage());
					broadcast(sendDTO);

				} else if(dto.getCommand() == Info.EXIT) {
					//나를 제외하고 나머지 클라이언트에게 메세지 보내기
					list.remove(this);

					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName + "님 퇴장하였습니다. ");
					broadcast(sendDTO);


					//나에게는 EXIT 보내기 
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();
					
					oos.close();
					ois.close();
					socket.close();

					break;
				}
		}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("CcCCCCCCC");
		}
	}
							//보내는 쪽		받는 쪽(run()에서) 두 개가 필요하다.
	public void broadcast(InfoDTO sendDTO){ 
		try{
			for(ChatHandlerObject2 handler : list){
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			}
		}catch(IOException ioe){ 
			ioe.printStackTrace();
		}
 
	} 
}
