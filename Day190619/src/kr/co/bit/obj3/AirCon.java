package kr.co.bit.obj3;
/*
 *  static�� ����, �޼ҵ忡 �پ��ִٸ� 
 *  new �����ڷ� �ҷ����� �ʰ� class �� �ٷ� �ҷ��� �� �ִ�. 
 *   
 */
public class AirCon {
	// ���� ���� 
	static String company; 
	static String color; 
	static int price; 
	static int size; 
	static int temp; 
	
	
	// �޼ҵ� ����
	public static void powerOn() {
		System.out.println("������ �״�.");
	}
	public static void powerOff() {
		System.out.println("������ ����.");
	}
	public static void tempUp() {
		temp++;
	}
	public static void tempDown() {
		temp--;
	}

}
