package kr.co.bit.obj3;

public class AirConUser {
	// ���� ���� 
		String company; //���� ����
		String color; 
		int price; 
		int size; 
		int temp; 
		
		/*
		 * public AirCon() { //�����Ϸ��� �����ϴ� �κ� => �ʱⰪ�� �ִ´� (�ʱ�ȭ)
		 * 	company = null; 
		 *  color = null; 
		 *  price = 0; 
		 *  0
		 *  0
		 *  
		 * }
		 * 
		 * ===> ������ ���� & �ٷ� ���� �ִ� �� == �ʱ�ȭ  ===> ������ �Լ��� �ϴ� �� Constructor
		 * ===> ������ ���� // ���� �� ������ �ִ� �� == ����.
		 */
		// �޼ҵ� ����
		public void powerOn() {
			System.out.println("������ �״�.");
		}
		public void powerOff() {
			System.out.println("������ ����.");
		}
		public void tempUp() {
			temp++;
		}
		public void tempDown() {
			temp--;
		}

}
