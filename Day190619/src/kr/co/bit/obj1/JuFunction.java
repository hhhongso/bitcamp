package kr.co.bit.obj1;

import java.util.Scanner;

/*
 * �޼ҵ�(�Լ�) ����� 
 * 	 // �Է�   (static)     �Լ��̸�(�űԻ���)
	 // void: default�� ���� ����. "ȣ���ϴ� ��, ��Ҹ� �ǵ��� ���� ����" => return; �� ���� ���� 
	 // �Լ����� return ��ɾ �ʿ� 
	// �Ķ����(�Ű�����, �μ�, arguement value) => �޼ҵ�()<< ()�κп� �ش� 
	 
 */
public class JuFunction {
	public static String juSelect(Scanner scan) { // void (X) ==> return�� ���� ������ Ÿ��

		System.out.println("�ֹ��ϼ���. yes/no");
		String ju = scan.next();
		return ju; // return type ��ġ�Ǿ��. ���� return ���� "�ƹ��ų� ���Ƿ� ������" ��� �ڵ�� ������� return ���� ����ȴ�.
	}

	public static void juDisp(int select) { //��� 
	 if (select == 1) {
		 System.out.println("�ֹ�����");		 
	 	} else {
		 System.out.println("�ֹ����"); 
	 	}
	} 
	public static int menuSelect(Scanner scan) {  //�Է� (��ȭ�Ǵ� �κ�)
		System.out.println("1.����� 2.«�� 3.������");
		int menu = scan.nextInt();
		return menu;
	}
	public static void menuDisp(int select) { //��� 
		if (select == 1) {
			System.out.println("���� ����");
		} else if (select == 2) {
			System.out.println("«�� ����");
		} else if (select == 3) {
			System.out.println("������ ����");
		}	
	}
	public static String gobSelect(Scanner scan) { //�Է�
		System.out.println("����� yes/no");
		String gob = scan.next();
		return gob; 
	}
	public static void gobDisp(int select) { //��� 
		if(select == 1) {
			System.out.println("���� �� ����");
		} else if (select == 2) {
			System.out.println("���� ���� ����");
		} else if (select == 3) {
			System.out.println("«�� �� ����");
		} else if (select == 4) {
			System.out.println("«�� ���� ����");
		}
	}
	public static int tangSelect(Scanner scan) { //�Է�
		System.out.println("1.�� 2.�� 3.��");
		int tang = scan.nextInt();
		return tang;
	}
	
	public static void tangDisp(int select) {
		if (select == 1) {
			System.out.println("�� ����");
		} else if (select == 2) {
			System.out.println("�� ����");
		} else if (select == 3) {
			System.out.println("�� ����");
		}
	}
	 
	
}
