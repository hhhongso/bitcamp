package kr.co.bit.obj1;


	 //class �ڽ�  extends �θ�: ��� 
public class Son extends Parent {

	protected int number1; 
	
	public Son() {
		
	}
	
	public void sonMethod1() {
		System.out.println("�ڽ��Լ�");
	}
	
	
	public static void main(String[] args) {
		Son son = new Son();
		son.age = 10;
		son.parentMethod1(); 
		System.out.println("�θ��� ����: " + son.age);
		
		son.number1 = 100;
		son.sonMethod1();
		System.out.println("�ڽļ���: " + son.number1);
	}
}
