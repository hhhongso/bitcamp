package kr.co.bit;

public class PrivateVar {
	private int var1; //����� ����������
	
	public PrivateVar() { // �Լ��� ���� ���� �����ϴ�. 
		var1 = 10;		
	}
	public static void main(String[] args) { //���� Ŭ���� �ȿ��� �� private�� ������ �� ������ 
		PrivateVar pv = new PrivateVar();
		pv.var1 = 100;
	
	}
}
