package Questions;

import java.util.Arrays;
import java.util.Scanner;
/*
 * Scanner scan = new Scanner(System.in);
		int N = scan.nextInt(); 
		int num[] = new int[N];		
		int minNum = 10000000;
		int maxNum =-10000000; 
		
		for(int i = 0; i < num.length ; i++) {
			num[i] = scan.nextInt();
		}
		for(int j : num) {// [확장 for문] num의 모든 값을 순회하여, int j 에 대입한다. 
			if(j > maxNum) {
				j = maxNum;
			}
			if(j < minNum) { 
				j = minNum;
			}
		}
		System.out.println(minNum + "" + maxNum);
	}
*/	

public class Q10817 {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int A = scan.nextInt();
		int B = scan.nextInt();
		int C = scan.nextInt();
		int[] intArr = new int[] { A, B, C };

		Arrays.sort(intArr);
		System.out.print(intArr[1]);


	}
}






