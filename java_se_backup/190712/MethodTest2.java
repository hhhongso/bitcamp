/* 스캐너로 10진수 입력: 13; 
2진수 = 
8진수 =
16진수 = 

Integer 클래스에서 2 / 8 / 16 진수로 변환하는 메소드 사용 
*/

import java.util.Scanner;

class MethodTest2{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("10진수 입력: ");
		int dec = scan.nextInt();

		String binary = Integer.toBinaryString(dec);
		String octor = Integer.toOctalString(dec);
		String hexa = Integer.toHexString(dec);
	
		System.out.println("2진수: " + binary);
		System.out.println("8진수: " + octor);
		System.out.println("16진수: " + hexa);
	}
}
