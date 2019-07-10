package kr.co.bit2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Example03 {
	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:/file/aaa.txt");  
		Path to = Paths.get("C:/file/ccc.txt"); //파일 복사하기
		
		FileChannel fromchannel = FileChannel.open(from, StandardOpenOption.READ); 
		FileChannel tochannel = FileChannel.open(to, StandardOpenOption.CREATE, StandardOpenOption.WRITE); 
		
		ByteBuffer buffer = ByteBuffer.allocateDirect(100);
		int byteCount; 
		
		while(true) {
			buffer.clear();
			byteCount = fromchannel.read(buffer);
			if(byteCount == -1) break; 
			buffer.flip();
			
			tochannel.write(buffer);
		}
		fromchannel.close();
		tochannel.close();
		System.out.println("파일 복사 성공 ");
	}
}

