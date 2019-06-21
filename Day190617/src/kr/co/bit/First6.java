package kr.co.bit;
//1부터 10까지의 합계 구하기
public class First6 {

	public static void main(String[] args) {
		int number1 = 0;
		int sum = 0;
		number1++; // number1 = number1 + 1
		sum+= number1; // sum = sum + number1 // 누적연산자 += : 좌항의 값에 우항의 연산결과를 좌항에 누적 
		System.out.println(number1 + ":" + sum);
 
		number1++; // number1 = number1 + 1
		sum+= number1; // sum = sum + number1
		System.out.println(number1 + ":" + sum);
		
		number1++; // number1 = number1 + 1
		sum+= number1; // sum = sum + number1
		System.out.println(number1 + ":" + sum);
		
	}

}
