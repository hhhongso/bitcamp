package kr.co.bit;

/* 연산자
 * 산술연산자
 * 비교연산자
 * 논리연산자: and &&, or ||, not ! 
 * 단항연산자(증감연산자): ++, --
 * 
 */
public class First3 {

	public static void main(String[] args) {
		int number1 = 10; 
		number1++;
		System.out.println(number1);
		
		int number2 = 10; int sum = 0;  
		sum = number2++; //후 증가 : number2가 sum에 대입된 후, 나중에 number2 + 1 
		System.out.println(sum + ":" + number2);
		sum = ++number2; //선 증가: nubmer2 + 1 먼저 증가 후, sum1에 대입 
		System.out.println(sum + ":" + number2);
	}

}
