package kr.co.bit;

public class Test {

	int number1; 
	int number2; 
	
	/* [1]
	 * 생성자함수를 지정해주지 않는다면, 컴파일러가 자동으로 파라미터 변수가 없는 생성자 함수를 생성하지만, 
	 * 개발자가 매개변수가 있는 생성자 함수를 직접 만들었다면, 컴파일러는 매개변수가 없는 생성자 함수를 생성하지 않는다.  
	 */
	
	public Test() {
	}
	
	public Test(int number1, int number2) {
		this.number1 = number1; 
		this.number2 = number2;
	}
	
	public static void main(String[] args) {
		/* [1]
		 * 즉, 파라미터가 없는 Test test1 = new Test();와 
		 * 			    있는						(50, 100) 을 같이 쓰고 싶으면 
		 * 매개변수가 없는 생성자 함수도 별도로 만들어 주어야 한다. 
		 */
		Test test1 = new Test();
		Test test2 = new Test(10, 100);
		
	}
}
