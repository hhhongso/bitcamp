package kr.co.bit;

public class Person {

	public int age; 
	public String name; 
	public int height; 
	public int weight; 
	
	//toString() �Լ�: Ŭ������ ������ �ִ� ��� ��������� ���� ���������� �Ѵ�.
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
	
	public Person() { // �Ķ���� ���� ���� ������ �Լ� �ʱ�ȭ ==> �Ʒ� ������ �Ƚ��൵ ��ǻ�Ͱ� �˾Ƽ� �����Ϸ� ��
		this.age = 0; 
		this.name = null; 
		this.height = 0;
		this.weight = 0;
		
	}

	public Person(int age) { // �Ķ���� ������ ���� ������ �Լ�
		this.age = age; // this.age ==> Person Ŭ������ ������� 
						// age ==> Person(int age) ������ �Լ��� �Ķ���� ��
	}
	
	public Person(String name) {
		this.name = name; 
	}
}
