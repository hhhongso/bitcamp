package kr.co.bit;
//������ ���� �Է¹޾Ƽ� 1������ ���� ���϶�. 
public class For_test3 {

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		int sum = 0; 
		String exp = "";
		    // i �� �ܺμ��ڿ��� ����(�ʱⰪ) ; 
		for (int i = number; i >= 1; i--) {
			sum += i; 
			exp += (i == number)? ""+ i : "+" +i;
		}
		System.out.println(exp + "=" + sum);

	}

}
