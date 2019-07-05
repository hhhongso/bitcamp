package kr.co.bit;
//input/outputStream 은 1byte
//reader/writer 2byte

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null; 
		
		try {
			fr = new FileReader("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\filereader.txt");
			int readChar = -1;
			while((readChar = fr.read()) != -1) {
				System.out.print((char)readChar);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
