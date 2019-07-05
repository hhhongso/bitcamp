package kr.co.bit;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterTest2 {

	public static void main(String[] args) {
		FileWriter fw = null; 
		BufferedWriter bw = null; 
		
		try {
			fw = new FileWriter("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\bufferedWriter2.txt");
			bw = new BufferedWriter(fw, 4); //여러 줄 입력 >>> "". 왜 한글자 입력이랑 같이는 못하지 ?
			bw.write("여러줄 입력 A12");
			bw.newLine();	//flush 기능 동원: 버퍼메모리에 남아있는 것을 newLine으로 지우고 다음 줄으로 들어감  
			bw.write("여러줄 입력 B34");
			bw.newLine();		
			bw.write("여러줄 입력 C56");
			bw.newLine();		
			bw.write("여러줄 입력 D78");
			bw.newLine();
			
			
			bw.write("여러줄 입력 D90");
			bw.newLine();
			//bw.write("a" or 'a');
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
