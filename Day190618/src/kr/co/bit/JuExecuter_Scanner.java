package kr.co.bit;

import java.util.Scanner;

public class JuExecuter_Scanner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("�ֹ��ϼ��� Y/N");
			char ju = input.next().charAt(0); // ���ڿ� nexT() ���� �ѱ��ڸ� ������ charAt()
			if(ju == 'y' || ju == 'Y') {
				System.out.println("�ֹ�����");
				System.out.println("�޴� 1.����� 2.«�� 3.������");
				int menu = input.nextInt();
				if(menu == 1) {
					System.out.println("����� ����");
					System.out.println("����� ���� ���� Y/N");
					char gob = input.next().charAt(0);
					if(gob == 'y' || gob == 'Y') {
						System.out.println("����� ����");
					} else {
						System.out.println("���� ����");
					}
				} else if (menu == 2) {
					System.out.println("«�� ����");
					System.out.println("����� ���� ���� Y/N");
					char gob = input.next().charAt(0);
					if(gob == 'y' || gob == 'Y') {
						System.out.println("����� ����");
					} else {
						System.out.println("���� ����");
					}
				} else if (menu == 3) {
					System.out.println("������ ����");
					System.out.println("1. �� 2. �� 3. ��");
					int tang = input.nextInt();
					if (tang == 1) {
						System.out.println("������ ��");
					} else if (tang == 2) {
						System.out.println("������ ��");
					} else if (tang == 3) {
						System.out.println("������ ��");
					}
				}
			} else {
				System.out.println("�ֹ����");
				break;
			}
			
		}


	}

}
