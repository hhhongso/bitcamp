package kr.co.bit;

import java.util.Scanner;

public class Dowhile_Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int randomNumber = (int)(Math.random()*100)+1; 
		//Math 클래스에서 무작위로 숫자 뽑아내기 
		//Math.random()*100)+1 : 1부터 100까지의 숫자 중 무작위로 뽑아낸다 (+1 없으면 0부터 99까지가 됨)
		//(int) 형변환 (없을 시 실수도 랜덤으로 뽑아낸다) 
				
		do {
			System.out.println("숫자를 입력하세요. ");
			int inputNumber = input.nextInt();
			if (inputNumber == randomNumber) {
				System.out.println("맞혔습니다 !");
				break;
			} else if (inputNumber > randomNumber) {
				System.out.println("숫자가 너무 큽니다. ");
			} else if (inputNumber < randomNumber) {
				System.out.println("숫자가 너무 작습니다. ");
			}
		}
		while(true);
	
	}

}
