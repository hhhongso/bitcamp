package kr.co.bit;
//ctrl+shift+f : �ڵ� �ٸ��� 

import java.util.Scanner;

public class JuExecuter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("�ֹ��ϼ���. yes/no");
			String ju = scan.next();
			if(ju.equals("yes") || ju.equals("YES")) { // ���ڿ��� ���ϱ� .equals() ==> Ŭ�������� ���ϴ� �� 
				System.out.println("�ֹ�����");
				System.out.println("1.����� 2.«�� 3.������");
				int menu = scan.nextInt();
				
				if(menu == 1) {
					System.out.println("��");
					System.out.println("����� yes/no");
					String gob = scan.next();
					if(gob.equals("yes") || gob.equals("YES")) {
						System.out.println("�� ����");
					} else {
						System.out.println("���� ����");
					}
					
				} else if (menu ==2) {
					System.out.println("«");
					System.out.println("����� yes/no");
					String gob = scan.next();
					if(gob.equals("yes") || gob.equals("YES")) {
						System.out.println("�� ����");
					} else {
						System.out.println("���� ����");
					}
					
				} else if (menu == 3) {
					System.out.println("��");
					System.out.println("1.�� 2.�� 3.��");
					int tang = scan.nextInt();
					if (tang == 1) {
						System.out.println("�� ����");
					} else if (tang == 2) {
						System.out.println("�� ����");
					} else if (tang == 3) {
						System.out.println("�� ����");
					}
					
				}
			} else {
				System.out.println("�ֹ����");
				break;
			}
			
		} // while�� ��

	}

}
