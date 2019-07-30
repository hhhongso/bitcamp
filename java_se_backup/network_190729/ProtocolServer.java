import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

import java.net.Socket;
import java.net.ServerSocket;
//import java.net.UnknownHostException; ������ �����ϱ� ȣ��Ʈ ������ �ɸ��� ����.

class ProtocolServer {
	private ServerSocket ss;
	private BufferedReader br; 
	private BufferedWriter bw; 
	private Socket socket;

	public ProtocolServer(){
		try{
			ss = new ServerSocket(9500); // ������ ��Ʈ��ȣ���� ��ٸ���. 
			System.out.println("���� �غ� �Ϸ�. �����");

	//		while(): ���� Ŭ���̾�Ʈ�� �� ==> ������ 
			socket = ss.accept(); // Ŭ���̾�Ʈ�� ������ ����ä��, ������ �����Ѵ�. 
			if(socket != null) System.out.println("����!");
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch(IOException e){
			System.out.println("Ŭ���̾�Ʈ�� ������ ���� ���� ��");
			e.printStackTrace();
			System.exit(0);
		}

//��ȭ�Ŀ���, Ŭ���̾�Ʈ�� �ֵ����� ����. 
		String line, msg;
		while(true){
			try{
				//���������� ������ ������ �޴� ��
				line = br.readLine();

				//����(������) �� 
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) {
					msg = ar[1] + "�� ����..." + "\n"; //���͸� �� ����� ��!
					bw.write(msg);
					bw.flush();

				} else if(ar[0].equals(Protocol.EXIT)){
					msg = ar[1] + "�� ����..."+ "\n";
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


	}//������
	public static void main(String[] args) {
		new ProtocolServer();

	}
}


/*
���� ���� 
1. ���� ���� 
2. ServerSocket:1) Ŭ���̾�Ʈ�� �����ϱ⸦ ��ٸ���. 
				2) Ŭ���̾�Ʈ�� �����ϸ�, Ŭ���̾�Ʈ�� ����ä�� Ŭ���̾�Ʈ�� ������ ������ �����Ѵ�. (accept) 

*/