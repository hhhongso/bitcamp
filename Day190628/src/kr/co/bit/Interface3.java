package kr.co.bit;

interface In1 {
	int x = 10; // public static int �� �����Ϸ��� �ڵ����� �ڵ� 
	void in1Method(); // public abstract void�� �ڵ����� �ڵ�
}

interface In2 {
	public static int x = 20; 
	public abstract void in1Method(); // In1�� �Լ��� ���� ==> �ϳ��� �޼ҵ�� ����� 
	public abstract void in2Method();
}

interface In3 extends In1, In2 {
	//�������̽��� ����� �� ���� 
	//but �������̽������� �Լ��� ���Ǵ� �����ϳ� �������� ���ϱ� ������, ������ ����Ŭ������ implements �޾Ƽ� �����Ͽ��� ��. 
}

class ExtendsTest extends Object implements In3 {

	@Override
	public void in1Method() {
		System.out.println("method1 ����");
		
	}

	@Override
	public void in2Method() {
		System.out.println("method2 ����");
		
	}
	
}


public class Interface3 {

	public static void main(String[] args) {
		ExtendsTest ext = new ExtendsTest();
		ext.in1Method();
		ext.in2Method();
		
		System.out.println(In1.x); //������ �������̽� Ÿ�Ը����� �ٷ� �ҷ��� 
		System.out.println(In2.x);

	}

}
