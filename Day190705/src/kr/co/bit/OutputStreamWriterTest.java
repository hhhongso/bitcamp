package kr.co.bit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OutputStreamWriterTest {

	public static void main(String[] args) {
		FileOutputStream fos = null;  //stream: 1byte씩
		OutputStreamWriter osw = null;  //writer: 2byte씩
		BufferedWriter bw = null; //buffer(임시공간) 
		
//		Scanner scan = new Scan(System.in);
//		BufferedReader br = new BufferedReader(System.in);
//		bufferedreader br2 = new bufferedReader(new InputStreamReader(System.in))
		
		// 				Buffer
		// ram(느림) - cache(완충장치) - CPU(빠름)
		
		try {
			fos = new FileOutputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190705\\src\\kr\\co\\bit\\outputStream.txt");
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			
			bw.write("outputStreamWriter 테스트");
			bw.newLine();
			bw.write("test test test test test");
			bw.newLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//fos.close();
			//osw.close(); bw만 닫아주면 나머지는 다 닫힘
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
