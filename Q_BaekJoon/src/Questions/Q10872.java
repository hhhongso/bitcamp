package Questions;

//N! 팩토리얼

import java.util.Scanner;

public class Q10872 {
	private int result;
	
	public int factorial(int n) {
		int[] facArr = new int[n-1];
		for (int i = 0; i < facArr.length; i++) {
			facArr[i] = n-i;
			while(i !=4) {
				result = facArr[i] * facArr[i+1];
				System.out.println(result);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수 입력: ");
		int n = scan.nextInt();	
		System.out.println(new Q10872().factorial(n));
		
	}
}
