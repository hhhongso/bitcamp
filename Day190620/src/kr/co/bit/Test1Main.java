package kr.co.bit;

public class Test1Main {

	public static void main(String[] args) {
		Test1_new_static_instance test1 = new Test1_new_static_instance();
		while (true) {
			switch(test1.display()) {  // instance method �ϱ� new �����ڷ� Ŭ������ �ҷ��� �� ����� �� ���� 
			case 1: // return number = 1 �̸� 
				Test1_new_static_instance.inputRecord();  // static method�ϱ� new ������ ���� �׷��� Ŭ������ �ҷ��� �� ���� 
				break;
			case 2:
				Test1_new_static_instance.deleteRecord();
				break;
			case 3:
				Test1_new_static_instance.sortRecord();
				break;
			case 4:
				Test1_new_static_instance.exitRecord();
				break;
			}
		} // while 

	}

}
