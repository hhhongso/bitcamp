/*Scanner 를 이용하여 정수값 a, b, c를 입력받아 순서대로 출력하시오. 
(if문만 이용) 

[실행결과]
a값: 24
b값: 10
c값: 33
10 24 33
*/

import java.util.Scanner;
import java.util.Arrays;

class IfTest2{
	public static void main(String[] args) 	{
		Scanner scan = new Scanner(System.in); 

		//1. if문
		System.out.print("세 수를 입력하세요: ");
		int a = scan.nextInt();		int b = scan.nextInt();		int c = scan.nextInt(); 

		if(a > b && a > c) //a가 가장 큼
			if(b > c) System.out.println(c +", "+ b + ", "+a);
			else if (b < c) System.out.println(b +", "+ c + ", "+a);
		
		if(b > a && b > c) //b가 가장 큼
			if(a > c) System.out.println(c +", "+ a + ", "+a);
			else if (a < c) System.out.println(a +", "+ c + ", "+b);
		
		if(c > a && c > b) //c가 가장 큼
			if(b > a) System.out.println(a +", "+ b + ", "+c);
			else if (b < a) System.out.println(b +", "+ a + ", "+c);
		
		//2. for문 + sort
		int N = 3; 
		System.out.print("세 수를 입력하세요: ");
		int[] arr = new int[N];
		for(int i = 0; i < arr.length; i++){
			arr[i] = scan.nextInt();
		}
		
		for(int i : arr) {
			Arrays.sort(arr);
			System.out.print(i + " ");
		}

	}
}
