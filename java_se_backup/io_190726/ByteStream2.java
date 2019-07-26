import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class ByteStream2 {
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt"); // 파일을 직접 생성 > 파일의 세부정보(파일 길이 등)을 알 수 있다.
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)); // 에서 "data.txt"생성 시 파일명만 알고 세부정보는 알 수 없음.
		int size = (int)file.length();

		byte[] b = new byte[size]; //byte 배열 생성 
		bis.read(b, 0, size);
		System.out.println(new String(b)); // 배열 전체를 문자열로 변환
		bis.close();
	}
}
