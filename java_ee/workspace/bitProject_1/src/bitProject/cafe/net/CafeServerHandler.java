package bitProject.cafe.net;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


import bitProject.cafe.dto.MemberDTO;
import bitProject.cafe.dto.OrderDTO;
import bitProject.cafe.dto.RoomDTO;
import bitProject.cafe.view.Message;

public class CafeServerHandler extends Thread {
//	public static ArrayList<RoomDTO> roomList = new ArrayList<RoomDTO>();

	private Socket socket;
	private ArrayList<CafeServerHandler> list;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public CafeServerHandler(Socket socket, ArrayList<CafeServerHandler> list) {
		this.socket = socket;
		this.list = list;

		try {
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		try {
			while (true) {
				Object temp = null;

				try {
					temp = ois.readObject();
				} catch (EOFException eofe) {
					temp = null;
				}

				if (temp instanceof MemberDTO) {
					MemberDTO member = (MemberDTO) temp;
					System.out.println(member.getName() + " 님이 접속하셨습니다.");
					System.out.println("현재 접속한 사용자 수 : " + list.size());
				} else if (temp instanceof RoomDTO) {
					RoomDTO room = (RoomDTO) temp;
					oos.writeObject(room);
					oos.flush();
					
// OrderDTO 로 캐스팅 할 수 있으면~ 					
				} else if(temp instanceof OrderDTO) {
					OrderDTO order = (OrderDTO) temp;
					
					//https://codeday.me/ko/qa/20190712/1032304.html
					ArrayList<String> address = null;
					if(socket.getInetAddress().toString().contains(getName())) {
						// ip주소를 포함하고 있으면 => 메세지를 출력한다. 					
						//해당 dto를 보낸 사용자 계정에게는 '주문완료' 를 보내주고
						if(order.getStatus() == Message.ORDER) {
							System.out.println("주문 완료");
							order.setStatus(Message.ORDERSELL);
							oos.writeObject(order);
							oos.flush();
							// 주문완료에 해당하는 enum을 보냄 => enum 받으면 클라이언트 쪽에서 인포메세지 띄움. 
						} else if(order.getStatus() == Message.ORDERSELL) { // else if(order.getMemberType()) getMemberType >> member.isStaff();
							//스태프 계정에게는 내용을 보내주고
//							oos.writeObject(order);
//							oos.flush();
							
						}												
					}		
					//관계없는 사용자 계정에게는 아무것도 보내지 않는다. 
							
						
						
				}
					
					

				}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void broadcast() {
		
		
	}

}


