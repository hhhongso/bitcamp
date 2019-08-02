
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
				InfoDTO dto = null; // �޴� �� 
				String nickName =null;
				dto = (InfoDTO) ois.readObject();

				if(dto.getCommand() == Info.JOIN){
					nickName = dto.getNickname();
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND); //JOIN�� �ް�, SEND�� ������.
					sendDTO.setMessage(nickName + "�� �����Ͽ����ϴ�. ");
					broadcast(sendDTO);
					 
				} else if(dto.getCommand() == Info.SEND) {
					nickName = dto.getNickname();
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND); //JOIN�� �ް�, SEND�� ������.
					sendDTO.setMessage(dto.getNickname() + ":" + dto.getMessage());
					broadcast(sendDTO);

				} else if(dto.getCommand() == Info.EXIT) {
					//���� �����ϰ� ������ Ŭ���̾�Ʈ���� �޼��� ������
					list.remove(this);

					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName + "�� �����Ͽ����ϴ�. ");
					broadcast(sendDTO);


					//�����Դ� EXIT ������ 
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
							//������ ��		�޴� ��(run()����) �� ���� �ʿ��ϴ�.
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
