package Questions;

import java.util.Scanner;

public class Q2562 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int num = 0;
		int num2 = 0;
		int arr[] = new int[9];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
//			max = arr[i];	
		}
	
		for (int j : arr) {
			num++;			
			if(j > max) {
				max = j;
				num2 = num;
			}

		}
		System.out.println(max);
		System.out.println(num2);

	}
}
