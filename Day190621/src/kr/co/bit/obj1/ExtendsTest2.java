package kr.co.bit.obj1;
/*
 * �ܰ躰 ���
 */

class Super { //extends Object(�ֻ��� ��ü)
	protected int number1; 
	public Super() {
		number1 = 500;
	}
	public void superMethod1() {
		System.out.println("�Ҿƺ���");
	}
}

class Sub extends Super {
	protected int number1;
	public Sub() {
		number1 = 4000; 
	}
	
	public void subMethod1() {
		System.out.println("�ƺ���");
	}
}

class Subsub extends Sub {
	protected int number3; 
	public Subsub() {
		
	}
	public void subsubMethod1() {
		System.out.println("�ڽ�");
	}
}

public class ExtendsTest2 { // [1] ������ ���� ����� ���� ==> ���� �� �ۿ��� ����� Ŭ���� ���� 

	public static void main(String[] args) {
		Subsub subsub = new Subsub();
		System.out.println(subsub.number1);
		subsub.number1 = 200; 
		subsub.number3 = 300; 
		System.out.println(subsub.number1 +","+ subsub.number1 +","+ subsub.number3);
		
		subsub.superMethod1();
		subsub.subMethod1();
		subsub.subsubMethod1();
		

	}

}
