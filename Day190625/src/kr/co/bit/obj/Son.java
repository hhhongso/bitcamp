package kr.co.bit.obj;

public class Son extends Father {
	protected double shoes; //������ ��ӹ޾� ����ϰ� 
	public Son() {
		System.out.println(super.shoes); // �θ�Ŭ������ ���� �������� ���ؼ��� >>> super.�� �θ�Ŭ������ ������ �����;� �θ��� ������ ����� �� �ִ�. 
		shoes = 250.55; //������ ���� �θ�� �ڽ��� �ٸ���. => �ڽ�Ŭ�������� ���� �ʱ�ȭ�Ͽ��� ������ 

	}

	public static void main(String[] args) {
		Son son = new Son();
		System.out.println(son.shoes); // �ڽ� Ŭ������ �������� ����� �� 
	}
}
