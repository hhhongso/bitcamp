package kr.co.bit;

import java.util.ArrayList;

public class ArrayTest1 {

	public static void main(String[] args) {
		ArrayList<String> array1 = new ArrayList<String>();		//ArrayList�� �� �� �ִ� Ŭ���� Ÿ���� ���������ִ� ��: ���׸� <>
		array1.add("X");
		
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		array2.add(123);
		
		ArrayList<Double> array3 = new ArrayList<Double>();
		array3.add(3.14);
	}
 
}

		/*
		ArrayList array1 = new ArrayList(); // <> <<< ���׸�?
		array1.add("A"); //[0]��° �迭
		array1.add("B");
		array1.add("C");
		array1.add("D");
		array1.add("E");
		System.out.println(array1);
		
		//�߰� ��򰡿� �ִ� ���� ���� ��, ���� ������ �� ĭ�� ��ܿ���, ������ ĭ�� ����ִ� null�迭��
		array1.remove(2);
		System.out.println(array1);
	
		//�߰��� ���ο� ���� ���� ���, ���� ������ �� ĭ�� �з�����. 
		array1.add(2, "C");
		System.out.println(array1);
		
		array1.add(2, "F");
		System.out.println(array1);
		 */
