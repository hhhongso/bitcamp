package kr.co.bit;

import java.util.function.ToIntBiFunction;

public class Example08 {
	public static void main(String[] args) {
		ToIntBiFunction<String, String> func;
			
		func = (a, b) -> a.compareToIgnoreCase(b);
		print(func.applyAsInt("java8", "JAVA8"));
		
		//매개변수에 대한 메소드 참조: 해당 타입(String)으로 호출 
		func = String :: compareToIgnoreCase;
		print(func.applyAsInt("java8", "JAVA8"));
	}
	
	public static void print(int order) {
		if(order < 0) {
			System.out.println("사전 순으로 먼저 옵니다. ");
		} else if(order == 0) {
			System.out.println("동일한 문자열입니다. ");
		} else {
			System.out.println("사전 순으로 나중에 옵니다. ");
		}
	}
}


/*쓰레드 
 * (실행 가능 파일) -> 실행 -> (실행 중인 프로그램)
 * 	프로그램 			-> 		프로세스
 * 
 * 대용량 인터페이스 처리 == !자바의 강점! *스레드 (동시다발적 실행)
 * 
 * 
 */
