package kr.co.bit.obj3;

public class AirConExecute {

	public static void main(String[] args) {
		AirCon.company = "�Ｚ������"; // AirCon class�� �Լ��� static Ű���带 �������μ� execute ���� �ٷ� �ҷ��� �� �ֵ��� �Ѵ�. 
		AirCon.color = "���";
		AirCon.price = 10000;
		AirCon.size = 7; 
		AirCon.temp = 0;
		
		System.out.println("���� " + AirCon.company +"�� ���. ������ " + AirCon.color + "�̰�, " 
		+ "������ " + AirCon.price + "�� �̰�, " + AirCon.size + "���̴�. " + "�µ��� " + AirCon.temp + "�� �̴�.");

		AirCon.powerOn();
		AirCon.powerOff();
		AirCon.tempUp();
		System.out.println(AirCon.temp + "���� �ö���!");
		AirCon.tempDown();
		System.out.println(AirCon.temp + "���� ��������.");
	}

}
