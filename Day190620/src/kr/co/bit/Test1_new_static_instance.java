package kr.co.bit;

import java.util.Scanner;

public class Test1_new_static_instance {
	public int display() { // case = 1 2 3 4 �� �ҷ��;� �� //�ν��Ͻ� �޼ҵ� 
		Scanner scan = new Scanner(System.in);
		System.out.println("1. ��� 2. ���� 3. ���� 4. ����");
		int number = scan.nextInt();
		return number; 
	}
	
	public static void inputRecord() {
		System.out.println("���");
		
	}
	
	public static void deleteRecord() {
		System.out.println("����");
	}
	
	public static void sortRecord() {
		System.out.println("����");
	}
	
	public static void exitRecord() {
		System.out.println("�����մϴ�. ");
		System.exit(0);
	}


}

