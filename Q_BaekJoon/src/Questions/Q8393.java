package Questions;

import java.util.Scanner;

public class Q8393 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int sum=0; 
		for(int i = 1; i <=n ; i++) {
			sum =+ sum+i;
		}
		System.out.print(sum);
		
	}

}
