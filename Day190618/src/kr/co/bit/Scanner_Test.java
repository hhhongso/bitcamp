package kr.co.bit;
// 스캐너 클래스를 가져오기 
import java.util.Scanner;

public class Scanner_Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("숫자를 입력해주세요.: ");
		int number1 = input.nextInt();
		System.out.println(number1);
		System.out.print("문자를 입력해주세요: ");
		String str = input.next();
		System.out.println(str);
		
		System.out.print("실수를 입력: ");
		double sil = input.nextDouble(); // 실수입력
		System.out.println(sil);
		

	}

}
