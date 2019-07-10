package kr.co.bit;
/*
 * 파일 클래스 
 */
import java.io.File;
import java.io.IOException;

public class Example01 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:\\file\\aaa.txt");
		
		if(f.exists()) {
			System.out.println("해당 경로에 파일이 존재합니다. ");
		} else {
			System.out.println("파일이 존재하지 않습니다. ");
		}
		if(!f.exists()) {
			f.createNewFile(); //파일 생성
		}
		System.out.println(f.isFile()); //파일인지 아닌지 확인 / isDirectory() 
		System.out.println(f.getAbsolutePath()); //절대경로
		System.out.println(f.getCanonicalPath()); //상대경로 
		System.out.println(f.getPath()); //상대경로 
		System.out.println(f.getName()); //파일이름 
		System.out.println(f.getParent()); //상위경로
		System.out.println(f.length()); //파일크기 (byte)
		
//		f.mkdir(); // 디렉토리 없을 시, 디렉토리 생성
//		f.setExecutable(); // 소유자의 실행 권한 부여  !!!다소 위험할 수 있음!!!
		f.delete(); //파일 삭제
				
	}
}
