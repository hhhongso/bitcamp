import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class DataStream {
	public static void main(String[] args) throws IOException {
								//생성순서 2				생성순서 1
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		/* 아래와 동일
		FileOutputStream fos = new FileOutputStream("result.txt");
		DataOutputStream dos = new DataOutputStream(fos); */

//		dos.writeUTF("홍길동"); // 글자를 byte단위로 쪼갰기 때문에 한글이 쪼개짐 
		dos.write(25);
		dos.writeDouble(185.3);
		dos.close();

	}
}
