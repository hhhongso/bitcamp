package kr.co.bit;

public class For_test2 {

	public static void main(String[] args) {
		int sum = 0; 
		String exp = "";
		
		for (int i = 0; i <=5; i++) {
			sum += i; // sum = sum + i. 0~50�� ���� ���Ѵ�. 
			exp += (i == 0) ? "" + i: "+" +i; // ���׿����� 
		}        // i == 0 �̸� ""i�� ����ϰ�: �׷��� ������ "+"i
		         // i == 1 �̸� False �̹Ƿ�, ������ 0 +1 �� ���. 
		System.out.println(exp + "=" + sum);

	}

}
