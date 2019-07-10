package kr.co.bit2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
 * I/O Stream: 단방향 
		Channel: 양방향, 1번만 선언하면 계속 사용 가능. 
		파일 채널: ****동기화 처리가 되어있어, 멀티 스레드 환경에서도 안전하게 사용 ****
 */
public class Example01 {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/file/aaa.txt");
		Files.createDirectories(path.getParent());
		
		FileChannel fileChannel = FileChannel.open(path,
				StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		String data = "안녕하세요";
		Charset charset = Charset.defaultCharset();
		ByteBuffer byteBuffer = charset.encode(data);
		
		int byteCount = fileChannel.write(byteBuffer);
		System.out.println("aaa.txt : " + byteCount);
		fileChannel.close(); //반드시 닫아주자. 
	}
}
