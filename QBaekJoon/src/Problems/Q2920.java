package Problems;

import java.util.Scanner;

public class Q2920 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[8];
		int note = 1;		int count = 0;  
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
			if(i<8 &&(arr[i] < arr[i++])) count++; 
		}			
		
	
			if(count == 7) {
				System.out.println("ascending");
			} else if(count == 0) {
				System.out.println("descending");
			} else {
				System.out.println("mixed");
			}
		

		
		
	}
}
