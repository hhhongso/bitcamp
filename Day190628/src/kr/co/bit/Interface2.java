package kr.co.bit;

class Vehicle1 {
	public void move() { // �����޼ҵ�
		System.out.println("�����δ�. ");
	}
}

interface Flyable {
	public abstract void fly(); //�߻�޼ҵ� 
	
	//����, �Լ��� ���߻�� �� ȥ���� �Ͼ�� ������ 
	//����, �����޼ҵ�� �Է����� ����, �߻��� �͸� �Է��Ͽ� �������̵�� ������ �� �ֵ��� �Ѵ�. 
}

class IMP2 extends Vehicle1 implements Flyable {

	@Override
	public void fly() {
		System.out.println("�����Ѵ�. ");
	}
	
}

public class Interface2 {

	public static void main(String[] args) {
		IMP2 imp2 = new IMP2();
		imp2.move();
		imp2.fly(); //�ڽ�Ŭ������ ��ü�� ����� �������̽��� ȣ��
		
		Flyable fable = (Flyable) new IMP2(); // UPcasting
		fable.fly(); //�θ�Ŭ������ ��ü�� ����� �������̽��� ȣ��

		/*
		 * �������̽��� �߿� �ٽ� 
		 * 
		 */
		
	}

}
