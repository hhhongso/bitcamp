package kr.co.bit;

public class Car {
	public Engine engine; //����
	public Door[] door; //����: Door Ŭ������ �ƴ϶� ���ʿ��� �����. 
	
	public Car() {
		engine = new Engine(); // ���� - �ҷ�����
		door = new Door[4]; // ���� - �ҷ�����
		for(int i = 0; i< door.length; i++) {
			door[i] = new Door(); 				// �ʱ�ȭ
		}
	}
	

}
