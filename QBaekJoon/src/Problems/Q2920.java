package Problems;

import java.util.Scanner;

public class Q2920 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[8];
		int note = 1;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt(); 
		}
		
			if(arr[i] > note) System.out.println("ascending");
			else if (arr[i] < note) System.out.println("descending");
			else System.out.println("mixed");
		}
	}

