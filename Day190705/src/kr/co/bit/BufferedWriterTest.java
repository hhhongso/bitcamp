package kr.co.bit;
/*BufferedWriter 클래스에서 flush()메소드를 호출하지 않을 경우의 결과 테스트 하기
*/

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest {

	public static void main(String[] args) {
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		
		try {
			fw = new FileWriter("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\bufferedWriter.txt");
			bw = new BufferedWriter(fw, 4); 
			bw.write('A');//한 문자씩 입력  >>> ''
			bw.write('B');
			bw.write('C');		
			bw.write('D');	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
