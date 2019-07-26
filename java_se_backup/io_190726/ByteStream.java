import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;		// Scanner는 IOException을 잡고 있어 따로 설정 해주지 않아도 됨. 

class ByteStream {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data; 
		while((data = bis.read()) != -1) { //스트림의 마지막에 오면 -1을 출력하기 때문 
			System.out.print((char)data);
		}
		bis.close();

	}
}
