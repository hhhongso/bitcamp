package kr.co.bit;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class Example03 {
	public static void main(String[] args) throws IOException {
		FileSystem fileSystem = FileSystems.getDefault();
		for (FileStore store : fileSystem.getFileStores()) {
			System.out.println("드라이버 명: " + store.name());
			System.out.println("파일 시스템:" + store.type());
			System.out.println("전체 공간: "+ store.getTotalSpace()); // byte 단위
			System.out.println("사용 가능 공간: " + store.getUsableSpace());
			System.out.println("사용 중인 공간:" + (store.getTotalSpace() - store.getUsableSpace()) );
		}
		System.out.println("파일 구분자: " + fileSystem.getSeparator());
	}
}


//도커 
//클러스트에 넣어 관리하는 정보들을 자동으로 처리 ??