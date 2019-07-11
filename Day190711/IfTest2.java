/*Scanner 를 이용하여 정수값 a, b, c를 입력받아 순서대로 출력하시오. 
(if문만 이용) 

[실행결과]
a값: 24
b값: 10
c값: 33
10 24 33
*/

import java.util.Scanner;

class IfTest2{
	public static void main(String[] args) 	{
		Scanner scan = new Scanner(System.in); 
		int a = scan.nextInt();		int b = scan.nextInt();		int c = scan.nextInt(); 
		
		if(a > b && a > c) 
			if(b > c) System.out.println(c +", "+ b + ", "+a);
			else if (b < c) System.out.println(b +", "+ c + ", "+a);
		
		if(b > a && b > c)
			if(a > c) System.out.println(c +", "+ a + ", "+a);
			else if (a < c) System.out.println(a +", "+ c + ", "+b);
		
		if(c > a && c > b)
			if(b > a) System.out.println(a +", "+ b + ", "+c);
			else if (b < a) System.out.println(b +", "+ a + ", "+c);
		


	}
}
