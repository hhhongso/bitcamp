package kr.co.bit.obj2;
/*
 * 1. �迭����
* ������ Ÿ��[] �迭 ������; �Ǵ� ������ Ÿ�� �迭 ������[];
* int[] args; // java ù��° ���ڸ� 0���� ��. Ÿ��[] �������� ������ Ȯ��.  
* int args[]; // C ���
 */
import java.util.ArrayList;

public class Array_Test {

	public static void main(String[] args) {
		int[] number; // number��� �̸����� �������� ���� []�� ������ Ȯ��
		number= new int[3]; // new �����ڷ� 3���� �������� ������ �����. 
		number[0] = 10;
		number[1] = 20;
		number[2] = 30;
		for(int i = 0; i < number.length; i++) { //length�� �迭[]���� ������ ���� 0,1,2
			System.out.println(number[i]); // ���ȣ�� �����´� 
		}
		
		System.out.println();
		/*
		* ArrayList list = new ArrayList();
		* list.add("���ڿ�");
		* list.add(1);
		* list.add(3.14); // ���׸� Ÿ�� ���� ���̴� ���� ���� ����, ����, �Ǽ� �� ���о��� ��� add�� ����. 
		
		* ArrayList<Integer> list1 = new ArrayList<Integer>();
		* list1.add("���ڿ�"); IntegerŸ���� �ƴ� ���� ���� �� ������ ���׸����� �����س���. 
		* list1.add(1);
		*/
		
		//��� �迭�� �Ʒ� ��̸���Ʈ(�÷��� Ŭ����) �� ���� ���� 
		// <���׸� Ÿ��> = integer Ŭ����
		// ���׸�? ������ Ÿ�� �ܿ��� ������ �� ������ �� 
		
		ArrayList<Integer> numberList = new ArrayList<Integer>(); //[]���� ����/���ҿ� ���� �ڵ� ��Ʈ�� ����� ����. 
		numberList.add(10);
		numberList.add(20);
		numberList.add(30);
		for(int i = 0; i < numberList.size(); i++) { //size�� �÷��� Ŭ�������� ������ ������ 0,1,2
			System.out.println(numberList.get(i)); // get�Լ��� �����´� 
		}
		
		System.out.println();
		
		String[] ar = new String[3];
		ar[0] = "�ȳ��ϼ���. ";
		ar[1] = "�����մϴ�. ";
		ar[2] = "�п��Դϴ�. ";
		for (int i = 0; i<ar.length; i++) {
			System.out.println(ar[i]);		
		}

	}

}
