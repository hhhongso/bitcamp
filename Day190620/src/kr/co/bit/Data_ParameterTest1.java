package kr.co.bit;

public class Data_ParameterTest1 {
	
	
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 10; // read and write
		System.out.println("main():x = " + data.x); 

		change(data); //�ν��Ͻ�(��ü)�� ���� 
		System.out.println("main():x = " + data.x);

	}
	public static void change(Data data) { // Ŭ������ �Ķ���� ���� (�Լ��� �Ķ���Ϳ� Ŭ���� ��ü�� �����) 
		data.x = 1000; //�Լ� �ȿ��� ���ο� �ִ� Data Ŭ������ ��ü�� ����  
		System.out.println("change():x = " + data.x); //
	}

}
