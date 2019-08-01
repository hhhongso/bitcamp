package W0729;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.EOFException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import java.io.IOException;

class ChatHandlerObject extends Thread implements java.io.Serializable {
	private ServerSocket ss; 
	private Socket socket;
	private ArrayList<ChatHandlerObject> list;
	private ObjectInputStream ois; 
	private ObjectOutputStream oos;
	private InfoDTO dto;

	public ChatHandlerObject(Socket socket, ArrayList<ChatHandlerObject> list) throws IOException{
		this.socket = socket; 
		this.list = list; 		

		oos = new ObjectOutputStream(socket.getOutputStream());		
		ois = new ObjectInputStream(socket.getInputStream());
		
	}

	@Override
	public void run(){
		try{
			while(true){	
			String nickName = ois.readUTF();
			oos.writeUTF(nickName + "님이 입장하였습니다. ");
			oos.flush();

				System.out.println("handler while후");
				
				//int count = ois.readInt();
				
				while((dto = (InfoDTO)ois.readObject()) != null){
					System.out.println("handler while후~");
		//		for(int i = 0; i < count; i++){
					dto = (InfoDTO)ois.readObject();	
					broadcast(dto.toString());
				}
				
				if(dto == null || dto.getCommand().equals(Info.EXIT)){ 	break;	}				
				
			} //while

			//exit를 클라이언트에게 보내고, 핸들러 끊고, list.remove();
			oos.writeObject(Info.EXIT);
			oos.flush();

			list.remove(this);
			broadcast(dto.getNickname() + "님이 퇴장하였습니다." );
			
			oos.close();
			ois.close();
			socket.close();

	
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("CcCCCCCCC");
		}
	}

	public void broadcast(String msg){ 
		try{
			for(ChatHandlerObject handler : list){
				handler.oos.writeObject(dto.toString());
				handler.oos.flush();
			}
		}catch(IOException ioe){ 
			ioe.printStackTrace();
		}
 
	} 
}
