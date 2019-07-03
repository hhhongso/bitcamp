package kr.co.bit;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println("1~100까지의 난수 발생");
		int num = (int)(Math.random()*100) +1; // random()*100 까지 하면 0<= x < 100 이므로 +1 필요 
		System.out.println("1~100 사이의 정수: " + num);
		
		System.out.println("1~50까지의 난수 발생");
		num = (int)(Math.random()*50) + 1;
		System.out.println("1~50 사이의 정수: " + num);

		System.out.println("1~20까지의 난수 발생");
		num = (int)(Math.random()*20) +1;
		System.out.println("1~20 사이의 정수: " + num);

	}

}
