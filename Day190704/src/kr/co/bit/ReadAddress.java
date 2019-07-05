package kr.co.bit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadAddress {
	public static void main(String[] args) {
		FileInputStream fin = null;
		InputStreamReader isr = null; 
		BufferedReader bfr = null; 
		StringTokenizer st = null; 
		
		try {
			fin = new FileInputStream("C:\\Users\\bitcamp\\Documents\\GitHub\\bitcamp\\Day190704\\src\\kr\\co\\bit\\address.txt");
			isr = new InputStreamReader(fin);
			bfr = new BufferedReader(isr);
			String string = null;
			while((string = bfr.readLine()) != null) {
				st = new StringTokenizer(string, ",");
				System.out.println("이름:" + st.nextToken() + "	주소:"+ st.nextToken() + "	이메일:" + st.nextToken() + "	전화번호:" + st.nextToken()); // "," 을 기준으로 토큰 자르기
				
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
