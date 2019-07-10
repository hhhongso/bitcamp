package kr.co.bit;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example05 {
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("C:/file/dir");
		Path path2 = Paths.get("C:/file/bbb.txt");
		
		if(Files.notExists(path1)) Files.createDirectories(path1); 
			// 해당 path에 디렉토리가 없으면 -> 디렉토리를 생성한다. 
		if(Files.notExists(path2)) Files.createFile(path2);
			// 해당 path에 파일이 없으면 -> 파일을 생성한다.
		
		//파일, 디렉토리에 순차적 접근하기 
		Path path3 = Paths.get("C:/file");
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3);
		for (Path path : directoryStream) {
			if(Files.isDirectory(path)) {
				System.out.println("디렉토리: " + path.getFileName());
			} else {
				System.out.println("파일: " + path.getFileName());
			}
		}
	}
}
