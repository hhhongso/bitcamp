package kr.co.bit;

public class Test3 {

	int iv;  // instance ���� ==> ���ÿ�������
 	public static int cv; // static ==> static �������� 
 

 	public void test1() { // �ν��Ͻ� �޼ҵ� ==>�� �������� 
 		System.out.println(iv);
 		System.out.println(cv); // �ν��Ͻ� �޼ҵ�/���������� Ŭ���� �޼ҵ�/���� ���� ����
 	}
 	public static void test2() { //Ŭ���� �޼ҵ� ==> static �������� 
 		//System.out.println(iv);
 		System.out.println(cv);
 		
 	}

	public void instanceMethod1() { // �ν��Ͻ� �޼ҵ�
		test1(); 
		test2(); // �ν��Ͻ� �޼ҵ�/���������� Ŭ���� �޼ҵ�/���� ���� ����
	}
	
	public static void staticMehod() { //Ŭ���� �޼ҵ�
		//test1(); // Ŭ���� �޼ҵ�/�������� �ν��Ͻ� �޼ҵ�/������ ����� �� ����. 
		test2();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
