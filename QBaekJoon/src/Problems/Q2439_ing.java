package Problems;

import java.util.Scanner;

public class Q2439_ing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		for (int i = 0; i < N-1; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i >= N; i++) {
			System.out.print("*");
		}
		System.out.println();
	}

}
