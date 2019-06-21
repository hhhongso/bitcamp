package kr.co.bit;

public class For_test2 {

	public static void main(String[] args) {
		int sum = 0; 
		String exp = "";
		
		for (int i = 0; i <=5; i++) {
			sum += i; // sum = sum + i. 0~50의 합을 구한다. 
			exp += (i == 0) ? "" + i: "+" +i; // 삼항연산자 
		}        // i == 0 이면 ""i를 출력하고: 그렇지 않으면 "+"i
		         // i == 1 이면 False 이므로, 누적된 0 +1 을 출력. 
		System.out.println(exp + "=" + sum);

	}

}
