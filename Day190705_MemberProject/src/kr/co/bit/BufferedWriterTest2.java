package kr.co.bit;
/*
 * 설정한 값보다 적게 입력할 경우 > close()를 반드시 해주어야 함. 
 * 		값과 같거나 크게 입력할 경우 > 자동 flush가 되기 때문에 close()를 해주지 않아도 실행 된다. 
 */
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
			bw.newLine();	//flush 기능 동원: 버퍼메모리에 남아있는 것을 newLine으로 지우고(flush) 다음 줄으로 들어감  
			bw.write("여러줄 입력 B34");
			bw.newLine();		
			bw.write("여러줄 입력 C56");
			bw.newLine();		
			bw.write("여러줄 입력 D78");
			bw.newLine();		
			bw.write("여러줄 입력 D90"); // 설정한 값 이상이면 자동 flush
			bw.newLine();
			bw.write("a");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}
