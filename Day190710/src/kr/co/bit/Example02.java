package kr.co.bit;
/*
 * path
 */
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example02 {
	public static void main(String[] args) {
		Path path = Paths.get("C:/file/aaa.txt");
		System.out.println("파일명: " + path.getFileName());
		System.out.println("부모 디렉토리명: " + path.getParent());
		System.out.println("중첩 경로 수: " + path.getNameCount());
		//new를 통해 객체 생성>메모리를 거치지 않고, 다이렉트로 액서스 & 정보를 가져옴 >> 메모리의 부하가 생기지 않음 !  

		System.out.println();
		for (int i = 0; i < path.getNameCount() ; i++) {
			System.out.println(path.getName(i));
			
		//Iterator로도 가능 >> 해보자 ! 
			
		}
	}
}
