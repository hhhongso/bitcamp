/*Scanner �� �̿��Ͽ� ������ a, b, c�� �Է¹޾� ������� ����Ͻÿ�. 
(if���� �̿�) 

[������]
a��: 24
b��: 10
c��: 33
10 24 33
*/

import java.util.Scanner;
import java.util.Arrays;

class IfTest2{
	public static void main(String[] args) 	{
		Scanner scan = new Scanner(System.in); 

		//1. if��
		System.out.print("�� ���� �Է��ϼ���: ");
		int a = scan.nextInt();		int b = scan.nextInt();		int c = scan.nextInt(); 

		if(a > b && a > c) //a�� ���� ŭ
			if(b > c) System.out.println(c +", "+ b + ", "+a);
			else if (b < c) System.out.println(b +", "+ c + ", "+a);
		
		if(b > a && b > c) //b�� ���� ŭ
			if(a > c) System.out.println(c +", "+ a + ", "+a);
			else if (a < c) System.out.println(a +", "+ c + ", "+b);
		
		if(c > a && c > b) //c�� ���� ŭ
			if(b > a) System.out.println(a +", "+ b + ", "+c);
			else if (b < a) System.out.println(b +", "+ a + ", "+c);
		
		//2. for�� + sort
		int N = 3; 
		System.out.print("�� ���� �Է��ϼ���: ");
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
