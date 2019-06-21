package kr.co.bit;

import java.util.Scanner;

public class Dowhile_Test6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String answer = "서울";
		
		do {
			System.out.println("대한민국의 수도는? ");
			String inputAnswer = input.next();
			if(inputAnswer.equals(answer)) { // 문자열 비교 시에는 == 불가 (하나의 문자를 비교 시 사용), .equals 로 비교 
				System.out.println("대한민국의 수도는 " + answer + "입니다. ");
				break; 
			} 
			System.out.println("다시 입력해주세요. ");
			
		} while(true);

	}

}
