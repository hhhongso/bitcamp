package kr.co.bit;

public class Test4 { // �ʱ�ȭ�Ͽ� �������� �� 

	private int number1; 
	private int number2; 
	
	
	
	public int getNumber1() { // ����(���)
		return number1;
	}
	public void setNumber1(int number1) { //����
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	
	
	public Test4() { //������ �Լ�: public ___(Ŭ����)__ { : �̰� �����ϸ� �ʱ�ȭ (0), ����ϸ� �Է��ص� ���� �ʱ�ȭ��
		number1 = 100; 
		number2 = 200;
	}
	public static void main(String[] args) {
		Test4 test4 = new Test4(); // ������ ȣ��	==> �ʱ�ȭ (0) 
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		
		test4.setNumber1(300);
		test4.setNumber2(400);
		
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		
		System.out.println(test4.getNumber1());
		System.out.println(test4.getNumber2());

		test4.setNumber1(30); 
		test4.setNumber2(40);
		
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		
	}
}
