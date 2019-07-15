package Problems;

import java.util.Scanner;

public class Q2920 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		/*
		int[] arr = new int[8];
		int count = 0; 
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
				if(arr[i] < i+2) {
					count++;
				}
			}		
			if(count == 8) {
				System.out.println("ascending");
			} else if(count == 0) {
				System.out.println("descending");
			} else {
				System.out.println("mixed");
			}
			*/
			
			
			String asc = "1 2 3 4 5 6 7 8";
			String desc = "8 7 6 5 4 3 2 1";
			String input = scan.nextLine();
			if(input.equals(asc))  System.out.println("ascending");
			else if(input.equals(desc))  System.out.println("descending");
			else  System.out.println("mixed");
			
		}
			
	}

