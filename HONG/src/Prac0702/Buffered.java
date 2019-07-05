package Prac0702;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Buffered {
	public static void main(String[] args) {
		BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("indexOf로 구분하기");
		try {
			String tc = bfr.readLine();
			int idxI = tc.indexOf("");
			String title = tc.substring(0,idxI);
			String content = tc.substring(idxI+1);
			
			System.out.println("Tokenizer로 구분하기");
			StringTokenizer st = new StringTokenizer(tc, "");
			System.out.println(st.nextToken());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
}
}
