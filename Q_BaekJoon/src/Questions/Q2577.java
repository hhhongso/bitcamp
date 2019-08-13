package Questions;

import java.util.Scanner;

public class Q2577 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();		int B = scan.nextInt();		int C = scan.nextInt();
		char[] num = new char[10]; // 0 1 2 3 4 5 6 7 8 9
		String result = A*B*C + "";
		
		for (int i = 0; i < result.length(); i++) {
			// 곱셈 결과의 i번째 값 = 0~9
			num[result.charAt(i) - 48]++;	// num[0]++;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print((int)num[i]);
		}	
	
		
	}
}
