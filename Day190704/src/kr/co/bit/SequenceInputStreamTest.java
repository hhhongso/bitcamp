package kr.co.bit;
// sequenceInputStream : 입력 스트림 여러 개를 하나의 입력스트림으로  연결해서 데이터를 읽어들일수 있는 입력 스트림
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fin1 = null; 
		FileInputStream fin2 = null; 
		FileInputStream fin3 = null; 
		
		SequenceInputStream si1 = null; 
		SequenceInputStream si2 = null; 
		
		try {
			fin1 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test1.txt");
			fin2 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test2.txt");
			fin3 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test3.TXT");
			
			//VECTOR == ARRAYLIST 동일한 개념이며, 함수도 동일. [구]vector - enumeration / [신]arrayList - Iterator 로 정방향 읽기 가능. 
			Vector v1 = new Vector();
			v1.add(fin1);
			v1.add(fin2);
			v1.add(fin3);
			
			Enumeration e = v1.elements();
			si1 = new SequenceInputStream(e); //파일을 한꺼번에 넣기
			int var_readbyte = -1; 
			while((var_readbyte = si1.read()) != -1) {
				System.out.print((char)var_readbyte);
			}
			System.out.println();
			
			
			
			fin1 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test1.txt");
			fin2 = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test2.txt");
			si2 = new SequenceInputStream(fin1, fin2); //파일을 하나씩 넣기
			var_readbyte = -1;
			while((var_readbyte = si2.read()) != -1) { // si2.read로 한글자씩 읽어 var_readbyte로 넘기기 
				System.out.print((char)var_readbyte);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
