package kr.co.bit;

public class JuExecuter {

	public static void main(String[] args) {
		System.out.println("�ֹ��ϼ��� Y/N");
		char ju = 'y';
		if (ju == 'y' || ju == 'Y') {
			System.out.println("�ֹ�����");
			System.out.println("�޴� 1.����� 2.«�� 3.������");
			int menu = 1; 
			switch(menu) { //����ġ �ڵ�� ��ø���� �ʴ� ���� ����. 
			case 1: 
				System.out.println("����� ����");
				System.out.println("����� ����� Y/N");
				char gob = 'y';
				if (gob =='y' || gob == 'Y') {
					System.out.println("����� ����� ����");
				} else {
					System.out.println("����� ���� ����");
				}
				break;
			case 2:
				System.out.println("«�� ����");
				System.out.println("«�� ����� Y/N");
				gob = 'y';
				if (gob =='y' || gob == 'Y') {
					System.out.println("«�� ����� ����");
				} else {
					System.out.println("«�� ���� ����");
				}
				break;
			case 3:
				System.out.println("������ ����");
				System.out.println("1. �� 2. �� 3. ��");
				int tang = 1; 
				switch(tang) { //case �ȿ��� switch�� �ٽ� ����ϴ� ���� ����.
				case 1:
					System.out.println("������ �� ");
					break;
				case 2: 
					System.out.println("������ ��");
					break;
				case 3:
					System.out.println("������ ��");
					break; 
				}
				break;
			default: 
				System.out.println("1,2,3�� �߿� �ٽ� �����ϼ���.");
			}
		} else {
			System.out.println("�ֹ����");
		}

	}

}
