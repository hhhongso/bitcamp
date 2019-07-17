package Problems;

import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Q10817Ram {
	
	public static int gugudan(int x) {
		x = 1; 		int m = 1; 		int result = 1;
		for (int i = 1; i <= 9; i++) {
			x++;
			for(int j = 1; j <= 9 ; j++) {
				result = x*m;
				m++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		int result = gugudan((x) -> x = scan.nextInt()	
				return result);
		 
		 
		
	}
}
