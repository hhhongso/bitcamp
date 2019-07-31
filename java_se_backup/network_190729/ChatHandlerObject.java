
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
			String nickName = ois.readUTF();
			oos.writeUTF(nickName + "���� �����Ͽ����ϴ�. ");
			oos.flush();

			while(true){	
				System.out.println("handler while��");
				
				int count = ois.readInt();
				System.out.println("handler while��" + count);
				
				for(int i = 0; i < count; i++){
					dto = (InfoDTO)ois.readObject();	
					broadcast(dto.toString());
				}
				
				if(dto == null || dto.getCommand().equals(Info.EXIT)){ 	break;	}				
				
			} //while

			//exit�� Ŭ���̾�Ʈ���� ������, �ڵ鷯 ����, list.remove();
			oos.writeObject(Info.EXIT);
			oos.flush();

			list.remove(this);
			broadcast(dto.getNickname() + "���� �����Ͽ����ϴ�." );
			
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
				handler.oos.writeObject(dto);
				handler.oos.flush();
			}
		}catch(IOException ioe){ 
			ioe.printStackTrace();
		}
 
	} 
}
