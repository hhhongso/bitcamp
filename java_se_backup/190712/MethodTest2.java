/* ��ĳ�ʷ� 10���� �Է�: 13; 
2���� = 
8���� =
16���� = 

Integer Ŭ�������� 2 / 8 / 16 ������ ��ȯ�ϴ� �޼ҵ� ��� 
*/

import java.util.Scanner;

class MethodTest2{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("10���� �Է�: ");
		int dec = scan.nextInt();

		String binary = Integer.toBinaryString(dec);
		String octor = Integer.toOctalString(dec);
		String hexa = Integer.toHexString(dec);
	
		System.out.println("2����: " + binary);
		System.out.println("8����: " + octor);
		System.out.println("16����: " + hexa);
	}
}
