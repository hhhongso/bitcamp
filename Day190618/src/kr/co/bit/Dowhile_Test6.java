package kr.co.bit;

import java.util.Scanner;

public class Dowhile_Test6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String answer = "����";
		
		do {
			System.out.println("���ѹα��� ������? ");
			String inputAnswer = input.next();
			if(inputAnswer.equals(answer)) { // ���ڿ� �� �ÿ��� == �Ұ� (�ϳ��� ���ڸ� �� �� ���), .equals �� �� 
				System.out.println("���ѹα��� ������ " + answer + "�Դϴ�. ");
				break; 
			} 
			System.out.println("�ٽ� �Է����ּ���. ");
			
		} while(true);

	}

}
