package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringTest2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("제목|내용 입력: ");
		String tc;
		try {
			tc = br.readLine(); // IOException (Input/Output)입출력예외 
			int indexI = tc.indexOf("|"); // indexI = 2;
			String title = tc.substring(0, indexI);
			String content = tc.substring(indexI+1);
			
			System.out.println(title);
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
}
}
