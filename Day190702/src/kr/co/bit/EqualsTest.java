package kr.co.bit;

class Student3 {
	private String name; 
	private int number; 
	
	public Student3(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
}

public class EqualsTest {

	public static void main(String[] args) {
		Student3 st1 = new Student3("�л���", 1);
		Student3 st2 = new Student3("�л���", 1);
		System.out.println(st1 == st2); // == : extends Object �� equals�� �θ� ��. �ּҰ��� �� >> false
		System.out.println(st1.equals(st2)); // equals�� ���ڿ����� ����. ��, ���� (���ڿ�, ����) �� �񱳰� �Ұ��ϴ�. >> �������̵��Ͽ� ������ �ʿ� 
		System.out.println(st1);
		System.out.println(st2);
	}

}
