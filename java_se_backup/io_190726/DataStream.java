import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class DataStream {
	public static void main(String[] args) throws IOException {
								//�������� 2				�������� 1
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		/* �Ʒ��� ����
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos); */

//		dos.writeUTF("ȫ�浿"); // ���ڸ� byte������ �ɰ��� ������ �ѱ��� �ɰ��� 
		dos.write(25);
		dos.writeDouble(185.3);
		dos.close();

	}
}
