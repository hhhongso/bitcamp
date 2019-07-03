package kr.co.bit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorTest {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("�౸1");
		al.add("�߱�2");
		al.add("��3");
		al.add("�豸4");
		al.add("Ź��5");

		//for���� �̿��Ͽ� ������ �� �ֱ�� �ϳ�, 
		//�� ��� [0]->[1]
		//		[0]->[1]->[2]
		//		[0]->[1]->[2]->[3] ... ���� ����Ǿ� �ӵ��� �������� �� ==> Iterator / ListIterator ��� [ArrayList �迭�濡���� ����Ѵ�]
																//[0]����� �� �ڸ��� ����ϱ� ������ �ѹ��� [0]->[1]->[2]->[3]->[4]�� �� �� ���� 

		// Iterator �� �̿��Ͽ� ���: ���������� ���, ������ only
		Iterator<String> it = al.iterator();
		while(it.hasNext()) { // ������
			System.out.println(it.next());
		}
		System.out.println();
		
		// ListIterator �� �̿��Ͽ� ���: ������ ���, ��/�Ĺ���
		ListIterator<String> lit = al.listIterator(); 
		while(lit.hasNext()) { // ������
			System.out.println(lit.next());
		}
		System.out.println();
		
		while(lit.hasPrevious()) { // �Ĺ���
			System.out.println(lit.previous());
		}
	}

}
