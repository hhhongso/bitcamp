package Questions;

import java.util.Scanner;

public class Q10950 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for (int i = 0; i < T; i++) {
			int A = scan.nextInt();	
			int B = scan.nextInt();	
			System.out.println(A+B);
		}
	}	

}
