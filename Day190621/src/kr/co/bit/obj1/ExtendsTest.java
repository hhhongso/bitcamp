package kr.co.bit.obj1;
/*
 * �ϳ��� ���Ͽ��� 
 * �θ� Ŭ����, �ڽ�Ŭ����, ���� �������� ��� �ۼ� & ������ �� �ִ�. 
 */

// �θ��Լ�
class Parent1 {
	protected int number1; 
	
	public Parent1() {	// �������Լ��� ����� �Ұ��ϴ�.	
	}
	
	public Parent1(int a) { 
		number1 = a; 
	}
	
	public void parent1Method() {
		System.out.println("�θ��Լ�");
	}
}

//�ڽ� Ŭ���� (��ӹ���)
class Son1 extends Parent1 {
	protected int number2; 
	
	public Son1() {
		super(); 
		// ��Ӱ��� ������ ������, ��ӵ� �� ó�� �������� ��. super()�Լ��� �θ� Ŭ������ ȣ���� �� �ִ�. 
	}
	
	public Son1(int n) { // ������ �ȿ��� ������ �Լ��� �ҷ��� �� �ֵ��� super �� �����Ͽ�, ������ �Լ��� ����ϰ� �� �� �ִ�. 
		super(10);
	}
	
	public void son1Method() {
		super.number1 = 10000000;
		super.parent1Method();
		System.out.println("�ڽ��Լ�");
	}

/*
 * super. ==> �θ� Ŭ������ �Լ�, ������ ���� 
 * super() ==> �θ� Ŭ������ �������Լ��� ������ ���������� �� 
 * 
 * this. 
 * this()
 */
}


public class ExtendsTest {
	public static void main(String[] args) {
		Son1 son1 = new Son1();
		son1.number1 = 100;
		son1.parent1Method();
		
		son1.number2 = 1000;
		son1.son1Method();

	}

}
