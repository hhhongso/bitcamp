package kr.co.bit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public static void main(String[] args) {
		FileInputStream fin =  null;
		InputStreamReader isr = null; //2byte
		BufferedReader bfr = null; //버퍼 메모리(임시기억공간)에서 가져옴 >> better than inputStream
		// BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in)); 와 동일
		
		try {
			fin = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\test4.txt");
			isr = new InputStreamReader(fin);
			bfr = new BufferedReader(isr);
			String str = null; 
			while((str = bfr.readLine()) != null) {
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fin.close();
				isr.close();
				bfr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}

}
