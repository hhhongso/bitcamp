package kr.co.bit;
//윤년 구하기 
/*조건
 * 1. 4년 주기로 돌아온다. 
 * 2. 100으로 나누었을 때 나머지가 0이 아니다 
 * 3. or 400년으로 나누었을 때 나머지가 0이다 (400년 주기로 돌아온다) 
 */
public class Logic3 {
	public static void main(String[] args) { // args 에 값 넣기: run configuration -> arguements 
		int year = Integer.parseInt(args[0]); // 문자열을 숫자로 바꾸는 함수 parseInt
		boolean result = false; 
		result = (year % 4 == 0 && year %100 !=0 || year % 400 == 0);
		if(result) {
			System.out.println("윤년입니다.");
		} else {
			System.out.println("윤년이 아닙니다. ");
		}
		

	}

}
