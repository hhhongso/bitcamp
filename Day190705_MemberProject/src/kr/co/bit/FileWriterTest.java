package kr.co.bit;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public static void main(String[] args) {
		FileWriter fw = null; 
		String msg = "메세지 입력 fileWriter TEst \r\n";
		try {
			fw = new FileWriter("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\filewriter.txt", true);
			fw.write(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close(); //종료를 해야 filewriter에 기록을 마칠 수 있따. 실행을 반복하면 msg가 계속 쓰여진다.  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
