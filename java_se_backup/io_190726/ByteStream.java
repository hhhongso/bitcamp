import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;		// Scanner�� IOException�� ��� �־� ���� ���� ������ �ʾƵ� ��. 

class ByteStream {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data; 
		while((data = bis.read()) != -1) { //��Ʈ���� �������� ���� -1�� ����ϱ� ���� 
			System.out.print((char)data);
		}
		bis.close();

	}
}
