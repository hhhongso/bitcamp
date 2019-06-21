package kr.co.bit;
/*반복문 for 문
 * 1~10의 합을 구하라
 */
public class For_test {

	public static void main(String[] args) {
		int number1 = 0;
		int sum = 0;
		//     초기값         조건식         증감식
		for (int i = 0; i < 100; i++) { // true일 시 코드블록 실행
			// i= 0 초기값 => ; 0< 10 이 True 면 코드블록을 실행{하고,}다시 코드블록 위로 올라와  => i++ 한다. 
			number1++; //number1 = number1 + 1 [증가]
			sum += number1; // sum = sum+ number1 [누적]		
		}
		System.out.println("증가: " +number1 + " 합계: " + sum);

	}

}
