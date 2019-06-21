package kr.co.bit;
// 식별자란 자바  코드에서 사용되는 변수,메소드,클레스,배열 등의 이름을 말한다.
// 이름을 구분짓기 위하여 사용하는 것

public class First { //클래스 first == 식별자

	public static void main(String[] args) { //main 메소드 == 식별자
		//System.out.println("비트학원");
		/*
		 * System.out.println("주석처리"); 
		 * System.out.println("실행과는 관련이 없다.");
		 */ //ctrl + shift + / = 여러줄 주석처리
/*
 * 작성자: 홍소연 
 * 개발날짜: 2019-06-17
 * 
 * 선언: 공간을 제작하는 과정 (=변수의 생성) 
 * 데이터 = 타입 = 변수 == 공간 ==> 선언 = 공간을 생성하는 과정
 * 선언 -> 입력 -> 처리 -> 출력
 */
		/*
		 * int number1 = 10; int sum = 0; number1 = number1 + 1; sum = sum+ number1; //
		 * number1 이라는 공간에 10이라는 숫자를 복사하여 number1이라는 공간에 대입한 것 // number1 변수 == 식별자 // 위
		 * 코드에서 number1 == 변수, 10 == 상수 System.out.println("넘버1의 값은 " + number1 + "합계는 "
		 * + sum);
		 */
	int number1 = 10; int sum = 0;
	number1 = 10 + 1; 	
	sum = sum + 11; 
	System.out.println("넘버1의 값은 " + number1 + "합계는 " + sum);
	
/* 초기화와 대입은 다르다. 
 * int a = 10; 공간을 만들면서 값을 바로 입력한다. (초기화)
 * int b;
 * b = 10; 공간을 만든 후 값을 나중에 입력한다. (대입)
 */
	int age;
	age = 10;
	System.out.println("나이는" + age + "세");
	
	
	}

}
