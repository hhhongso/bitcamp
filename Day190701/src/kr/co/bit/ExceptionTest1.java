package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest1 {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //Scanner보다 고성능의 입력기
		System.out.println("문자열 입력: ");
		try {	//컴파일 시 에러[readLine]을 예외처리로 잡아준다. 
			String str = bf.readLine(); // 한 줄 전체를 읽어 들여오는 함수 
		} catch (IOException e) { //
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		/*
		 * 실행할 때 에러가 나는 경우 > 컴퓨터가 실행 시 try/catch 를 자동으로 진행 
		 * 컴파일 할 때 에러가 나는 경우 >> Runtime 상속관계 X > 개발자가 직접 try/catch 처리해주어야
		 * if-else 의 발전 = try/catch 
		 * 예외처리 후에도 프로그램은 계속 진행된다 
		 */
		
		
		
//		int num = Integer.parseInt(args[0]);
//		int result = 10 / num; // num = 0 일 때 값 오류 > 컴파일 후, 실행할 때 에러 발생
//		System.out.println(result);
	
	
	
	}

}
