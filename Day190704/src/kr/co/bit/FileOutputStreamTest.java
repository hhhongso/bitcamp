package kr.co.bit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		FileOutputStream fout = null;
		String msg = "fileOutputStream_test_bitcamp";
		byte[] byteArray = msg.getBytes(); //input/outputStream�� �⺻������ byte�� ����. -> msg�� byte������ �� ���ھ� �߶�(.getBytes()) byte�迭�濡 �ִ´�. 
		
		try {
			fout = new FileOutputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\fileoutput.txt", true); // ��� �̸��� ���İ� ������ ������ !
			fout.write(byteArray);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		

	}

}
