package kr.co.bit.obj;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null; 
		try {
			fis = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190703\\src\\kr\\co\\bit\\obj\\test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int var_read = -1; //¸¶Áö¸·
		try {
			while((var_read = fis.read()) != -1) {
				System.out.print((char)var_read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
