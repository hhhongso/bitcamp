package kr.co.bit;

import java.util.Scanner;

public class Dowhile_Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int randomNumber = (int)(Math.random()*100)+1; 
		//Math Ŭ�������� �������� ���� �̾Ƴ��� 
		//Math.random()*100)+1 : 1���� 100������ ���� �� �������� �̾Ƴ��� (+1 ������ 0���� 99������ ��)
		//(int) ����ȯ (���� �� �Ǽ��� �������� �̾Ƴ���) 
				
		do {
			System.out.println("���ڸ� �Է��ϼ���. ");
			int inputNumber = input.nextInt();
			if (inputNumber == randomNumber) {
				System.out.println("�������ϴ� !");
				break;
			} else if (inputNumber > randomNumber) {
				System.out.println("���ڰ� �ʹ� Ů�ϴ�. ");
			} else if (inputNumber < randomNumber) {
				System.out.println("���ڰ� �ʹ� �۽��ϴ�. ");
			}
		}
		while(true);
	
	}

}
