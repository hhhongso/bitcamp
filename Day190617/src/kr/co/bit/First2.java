package kr.co.bit;

public class First2 {

	public static void main(String[] args) {
		byte number1 = 10;
		int number2 = number1; 
		// (������ ����ȯ) 4byte ������ 1byte �� ���� => �����Ϸ��� �ڵ����� int ���� ����ȯ�ϱ� ������, int�� ����Ͽ� ���� �ʾƵ� �ȴ�.
		
		int number3 = 150;
		byte number4 = (byte)number3;
		// (����� ����ȯ) 1byte ������ 4byte �� ������ �� ���� => �����ڰ� ���� ��������� �����־�� �ȴ�. (�� ���, �����ڰ� ��� å���� ����)
		// ��, ����ȯ �� ������ �� �ִ� ������ ���ڿ��߸� �����ϴ�. 
		System.out.println(number4);
	
		byte number5 = 50;
		byte number6 = 40;
		int sum = number5 + number6; // 1byte + 1byte == 4byte;
		System.out.println(sum);
		
		//ASCII ���� �ڵ�ǥ: A�� ����(��Ʈ��)�� ��ȯ�ϵ��� ���� 
		char c1 = 'A';
		int sum1 = c1 + 1;
		System.out.println(sum1);
		
		int d1 = 65;
		System.out.println((char)d1);
		
		char e1 = 'a';
		int sum2 = e1 + 1;
		System.out.println(sum2);
	}

}
