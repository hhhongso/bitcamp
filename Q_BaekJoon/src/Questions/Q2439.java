package Questions;

import java.util.Scanner;

public class Q2439 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j >= i; j++) {
				System.out.print("*");
			}
			
		}
		System.out.println();
	}

}
