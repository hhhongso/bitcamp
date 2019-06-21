package kr.co.bit;
//0~10까지의 짝수의 합을 구하라. 
public class For_test4 {

	public static void main(String[] args) {
		int sum = 0;
		String exp = "";
		
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				sum += i; 
				exp += (i == 2)? "" +i : "+" +i ;
			}
		}
		System.out.println(exp + "=" + sum);

	}

}
