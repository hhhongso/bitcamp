package kr.co.bit2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
 * 
transferTO() / transferFrom()
높은 호환성. non-blocking방식 파일 처리. 서버 to 서버 파일 복사 
 */
public class Example04 {
	public static void main(String[] args) throws IOException {
			FileChannel from = FileChannel.open(Paths.get("C:/file/aaa.txt"),StandardOpenOption.READ); 
			FileChannel to = FileChannel.open(Paths.get("C:/file/ddd.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
			from.transferTo(0, from.size(), to);
			to.transferFrom(from, 0, from.size());
			
			from.close();
			to.close();
		
	}
}
