package Questions;

//N! 팩토리얼

import java.util.Scanner;

public class Q10872 {
	
	public static int factorial(int n) {
		if(n == 0) return 1;
		else return n*factorial(n-1);

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();	
		System.out.println(factorial(n));
		 
	}
}
