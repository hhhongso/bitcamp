package kr.co.bit.obj3;
/*
 * 카드로 비유했을 때, 
 * 무늬, 숫자 등 카드 마다 각기 다른 값을 가진 것 ==> 인스턴스 변수
 * 폭, 높이 등 모든 카드가 동일한 값을 가진 것 ==> 스태틱 변수(클래스 변수)
 * 
 * 인스턴스 변수: New 연산자를 통하여 계속 메모리 공간을 생성한다. ==> 각기 다른 값을 메모리에 저장 
 * 클래스 변수: 메모리 공간을 1번만 만들어 저장하고, 더이상 만들지 않음 
==> 객체의 특성을 파악하여 어떤 변수에 인스턴스 / 스태틱을 붙여야 할 지 결정한다. 

 * 로컬 변수(지역 변수): 메소드나 초기화 블록 안에 정의되는 변수. 메소드 실행이 종료되면 자동으로 메모리에서 소멸된다. 
 */
public class StaticTest {
	static int number1; // static 변수 (클래스 변수)
	public int number2; // static 없음 (인스턴스 변수)
	static { // static 구조 안에서 초기화된다.
		number1 = 0; 
	}
	public StaticTest() {// 인스턴스 변수는 생성자 함수 안에서 초기화된다. (클래스 이름으로 된 함수를 이용하여 초기화)
		number2 = 0; 
	}
	public static void main(String[] args) { //main 진입접 static과 동일한 공간에 있음 
	StaticTest staticTest = new StaticTest(); // 인스턴스 변수는 new 연산자 
	
}
}
