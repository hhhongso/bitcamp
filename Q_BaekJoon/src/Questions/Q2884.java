package Questions;

import java.util.Scanner;

public class Q2884 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int H = scan.nextInt();		int M = scan.nextInt();
		if(H >= 0 && M >= 45) {
			System.out.println(H + " "+ (M-45));
		} else if (H > 0 && M < 45){
			System.out.println(H-1 + " " + (M+15));
		} else if (H == 0 && M < 45) {
			System.out.println(23 + " " + (M+15));
		}
	}

}
