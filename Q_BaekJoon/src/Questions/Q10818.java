package Questions;

import java.util.Scanner;

public class Q10818 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int max = 0; 
		int min = 0; 
		
		int[] arr = new int[N];
		
		for(int i = 0; i < arr.length ; i++) {
			arr[i] = scan.nextInt();
			max = arr[i];
			min = arr[i];
		}
		
		for (int j : arr) {
			if(j > max) max = j;
			if(j < min) min = j;
		}
		System.out.println(min +" " + max);

	}
}
