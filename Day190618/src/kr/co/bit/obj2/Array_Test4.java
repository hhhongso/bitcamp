package kr.co.bit.obj2;

import java.util.Scanner;

// �̸� ã�� �׽�Ʈ: Ư�� �迭���� Scanner�� �о���� �̸��� �� �� �ε����� ����Ǿ� �ִ��� ã�� 
public class Array_Test4 {
public static void main(String[] args) {
	String[] names = new String[] {"������", "�󸶹�", "�����", "��īŸ", "Ÿ����"};
	Scanner input = new Scanner(System.in);
	int index = -1; //? ã�Ҵ��� ���θ� Ȯ���ϱ� ���� �ǵ������� ����. -1�̸� ��ã�� ��, �̿� 0 1 2~~ ok
	
	do {
		System.out.println("�˻��� �̸��� �Է��ϼ���.");
		System.out.println("�̸�: ");		
		String name = input.next();
		
		for(int i = 0; i < names.length; i++) {
			if(name.equals(names[i])) { // if(names[i].equals(name)) �̶�� �ص� ���� �����.
				index = i;
			}
		}
			if (index != -1) {
				System.out.println(name +"�� �迭��" + index + "�� �濡�� ã�ҽ��ϴ�. ");
			break;
			}
			System.out.println("�ش� �̸��� �������� �ʽ��ϴ�. ");
		
		
	} while(true);
	
}
}
