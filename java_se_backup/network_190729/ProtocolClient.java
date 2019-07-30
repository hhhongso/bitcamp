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
		socket = new Socket("192.168.0.60", 9500); // IP�� ��IP, port��ȣ�� 9500 ���� �����غ���.
		
		//IO											//������:socket
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		keyboard = new BufferedReader(new InputStreamReader(System.in));
		
		}catch(UnknownHostException e){
			System.out.println("������ ã�� �� ���� ��");
			e.printStackTrace();
			System.exit(0);
		}catch(IOException e){
			System.out.println("������ ������ ���� ���� ��");
			e.printStackTrace();
			System.exit(0);
		}

		String msg, line;
		while(true){
			try{
				//�������� ������ ��
				msg = keyboard.readLine();
				bw.write(msg + "\n"); // ������ ������
				bw.flush(); //���� ���� => ���� �����Ͱ� ���� �� �ֵ��� ��. 

				//�����κ��� �޴� ��
				line = br.readLine(); // readLine()�� ���͸� ģ �� ������ �� �������� ����.
				System.out.println(line);


	//			���ڿ��� ���� �������� �ɰ� ��: split(), StringTokenizer
				//���� ���� IO�� ������ �����־�� �Ѵ�.
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

		
	} //������


	public static void main(String[] args) {
		new ProtocolClient();

	}
}
