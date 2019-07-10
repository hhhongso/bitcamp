package kr.co.bit2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Example05 {
	public static void main(String[] args) throws IOException {
		Path from = Paths.get("C:/file/aaa.txt");
		Path to = Paths.get("C:/file/eee.txt");
		
		//빠른 방식으로 처리하기 
		Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING); //해당 파일이 존재하면 교체한다. 
		System.out.println("끝");
	}
}
