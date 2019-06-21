package kr.co.bit;

public class Test5 {

	private int number1; // 멤버변수 = 필드 
	private int number2;

	public Test5(int number1, int number2) {
		this.number1 = number1;
		this.number2 = number2;
	}

	public Test5() { // 생성자함수 생성: 우 > source >
		number1 = 0;
		number2 = 0;
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "Test5 [number1=" + number1 + ", number2=" + number2 + "]";
	}

	public static void main(String[] args) {
		Test5 test5 = new Test5(); // 매개변수가 없음 => 초기값 0, 0 
		Test5 test6 = new Test5(100,200); // 매개변수가 있음 ==> int number1 = 100, int number2 = 200
	}
}
