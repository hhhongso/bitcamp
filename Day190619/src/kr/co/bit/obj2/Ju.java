package kr.co.bit.obj2;
/*Class: 
���Ǽ����� ������ 
��ǻ���� �������� ���������� �ϴ� ���赵, ���� Ʋ

������ (��ü) Ŭ�������� 
Ư��(����/���)
���(�޼ҵ�/����)
 * 
 */
import java.util.Scanner;

public class Ju {
	//��������
	static Scanner scan; // static ���� �޸� ���� ���� ��, ���� scan ����  ==> ���� �Ķ���Ϳ� �Է��Ͽ��� �Ű������� ���̻� �ʿ����� �ʰ� ��
	static String ju; 
	static int select;
	static int menu;
	static String gob;
	static int tang; 
	
	//�޼ҵ�����
	public static String juSelect() { // void (X) ==> return�� ���� ������ Ÿ��
		System.out.println("�ֹ��ϼ���. yes/no");
		ju = scan.next();
		return ju; // return type ��ġ�Ǿ��. ���� return ���� "�ƹ��ų� ���Ƿ� ������" ��� �ڵ�� ������� return ���� ����ȴ�.
	}

	public static void juDisp() { //��� 
	 if (select == 1) {
		 System.out.println("�ֹ�����");		 
	 	} else {
		 System.out.println("�ֹ����"); 
	 	}
	} 
	public static int menuSelect() {  //�Է� (��ȭ�Ǵ� �κ�)
		System.out.println("1.����� 2.«�� 3.������");
		menu = scan.nextInt();
		return menu;
	}
	public static void menuDisp() { //��� 
		if (select == 1) {
			System.out.println("���� ����");
		} else if (select == 2) {
			System.out.println("«�� ����");
		} else if (select == 3) {
			System.out.println("������ ����");
		}	
	}
	public static String gobSelect() { //�Է�
		System.out.println("����� yes/no");
		gob = scan.next();
		return gob; 
	}
	public static void gobDisp() { //��� 
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
	public static int tangSelect() { //�Է�
		System.out.println("1.�� 2.�� 3.��");
		tang = scan.nextInt();
		return tang;
	}
	
	public static void tangDisp() {
		if (select == 1) {
			System.out.println("�� ����");
		} else if (select == 2) {
			System.out.println("�� ����");
		} else if (select == 3) {
			System.out.println("�� ����");
		}
	}
	 
}
