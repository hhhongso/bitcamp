package kr.co.bit;

import java.util.ArrayList;

public class ArrayTest2 {

	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		array.add("��");
		array.add("��");
		array.add("��");	
		for(int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i));
		}
		
		System.out.println();
		
		array.remove(0);
		array.remove("��"); // �ε��� ��ȣ�� ����ų�, ���ڿ��� ���� ����ų�
		for(int i = 0; i < array.size(); i++) {
		System.out.println(array.get(i));
		}
	}

}
