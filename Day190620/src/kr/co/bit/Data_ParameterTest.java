package kr.co.bit;

public class Data_ParameterTest {
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10; // read only ==> 1000 ���� �������� ���� 
		System.out.println("main():x = " + data.x); // ���θ޼ҵ�

		change(data.x); //data.x = 10 �� ���ԵǾ� ���ư� (�Լ��� ����)
		System.out.println("main():x = " + data.x); // data.x�� ____ ���� ������ �Ұ�. �״�� 10������ ���� 
		
	}
	
	public static void change(int x) { // data.x = int x= 10���� ���ƿ���  (�Ķ���Ͱ� �⺻������ �ҷ���)
		x = 1000; //
		System.out.println("change():x = " + x); // change �Լ� �ȿ��� x = 1000; 
	}
}
