package kr.co.bit;

import java.util.Random;

public class MathTest {

	public static void main(String[] args) {
		System.out.println("1~100������ ���� �߻�");
		int num = (int)(Math.random()*100) +1; // random()*100 ���� �ϸ� 0<= x < 100 �̹Ƿ� +1 �ʿ� 
		System.out.println("1~100 ������ ����: " + num);
		
		System.out.println("1~50������ ���� �߻�");
		num = (int)(Math.random()*50) + 1;
		System.out.println("1~50 ������ ����: " + num);

		System.out.println("1~20������ ���� �߻�");
		num = (int)(Math.random()*20) +1;
		System.out.println("1~20 ������ ����: " + num);

	}

}
