package Problems;

import java.util.Scanner;

public class Q10817 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();		int B = scan.nextInt();		int C = scan.nextInt();
		
		int mid = A;
		
		if(A >= B && B >= C || C>=B && B >=A) { 
			mid = B;
				
		} else if (B >= A && A >= C || C>=A && A>=B) {
			mid = A;
		} else if (A >= C && C >= B || B>=C && C>=B) {
			mid = C; 			
		}
		System.out.println(mid);		
	}

}
