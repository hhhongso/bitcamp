package kr.co.bit;
//임의의 정수 입력받아서 1까지의 합을 구하라. 
public class For_test3 {

	public static void main(String[] args) {
		int number = Integer.parseInt(args[0]);
		int sum = 0; 
		String exp = "";
		    // i 는 외부숫자에서 시작(초기값) ; 
		for (int i = number; i >= 1; i--) {
			sum += i; 
			exp += (i == number)? ""+ i : "+" +i;
		}
		System.out.println(exp + "=" + sum);

	}

}
