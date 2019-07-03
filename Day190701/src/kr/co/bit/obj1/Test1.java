package kr.co.bit.obj1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {

	public static void main(String[] args) {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {				//  0 1 2 34: 문자열 > 입력과 동시에 배열로 초기화"
			System.out.println("제목 | 내용");
			String titleContent= br.readLine();
			int indexI = titleContent.indexOf("|"); // ==> int indexI = 2;
			String title = titleContent.substring(0,indexI); // 문자열을 자를 때 사용하는 함수 substring
			String content = titleContent.substring(indexI+1);
			System.out.println(title);
			System.out.println(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
