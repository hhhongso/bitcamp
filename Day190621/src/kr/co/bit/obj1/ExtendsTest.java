package kr.co.bit.obj1;
/*
 * 하나의 파일에서 
 * 부모 클래스, 자식클래스, 메인 진입점을 모두 작성 & 실행할 수 있다. 
 */

// 부모함수
class Parent1 {
	protected int number1; 
	
	public Parent1() {	// 생성자함수는 상속이 불가하다.	
	}
	
	public Parent1(int a) { 
		number1 = a; 
	}
	
	public void parent1Method() {
		System.out.println("부모함수");
	}
}

//자식 클래스 (상속받음)
class Son1 extends Parent1 {
	protected int number2; 
	
	public Son1() {
		super(); 
		// 상속과는 관련이 없으나, 상속된 것 처럼 보여지게 함. super()함수로 부모 클래스를 호출할 수 있다. 
	}
	
	public Son1(int n) { // 생성자 안에서 생성자 함수를 불러올 수 있도록 super 로 강제하여, 생성자 함수를 사용하게 할 수 있다. 
		super(10);
	}
	
	public void son1Method() {
		super.number1 = 10000000;
		super.parent1Method();
		System.out.println("자식함수");
	}

/*
 * super. ==> 부모 클래스의 함수, 변수를 재사용 
 * super() ==> 부모 클래스의 생성자함수를 강제로 가져오도록 함 
 * 
 * this. 
 * this()
 */
}


public class ExtendsTest {
	public static void main(String[] args) {
		Son1 son1 = new Son1();
		son1.number1 = 100;
		son1.parent1Method();
		
		son1.number2 = 1000;
		son1.son1Method();

	}

}
