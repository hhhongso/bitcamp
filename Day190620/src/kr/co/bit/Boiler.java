package kr.co.bit;

public class Boiler {

	static int heihgt;
	private String maker; 
	public int temp; 
	private String color; 
	/* private: ���� ��Ű�� �ȿ���, �ش� Ŭ���� �ȿ����� ��� ����, �ܺ� Ŭ������ �ҷ��� �� ���� . // ��Ű���� �ٸ��� import �ؾ߿� ��
	 * public: ����. �ܺ� Ŭ�������� ������� �ҷ��� �� ���� 
	 */
	
	public void set() { // private ������ �״�� �� ���� ������, �Լ��� ���� �ҷ��� �� �ִ�. 
		maker = "A";
		System.out.println(maker);
	}
	public void tempUp() { // 1���� �ø��� �Լ�
		temp++;		
	}
	public void tempUp(int amount) { // �ܺο��� �Է¹��� amount ��ŭ �ø��� �Լ� (�����ε�) 
		temp = temp + amount; 
	}
	public static void main(String[] args) {
		Boiler boiler = new Boiler ();
		boiler.tempUp();
		System.out.println(boiler.temp);
		
		boiler.tempUp(10);
		System.out.println(boiler.temp);
		
	}
}
