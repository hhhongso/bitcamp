package kr.co.bit;

public class Test4 { // 초기화하여 이쪽으로 옴 

	private int number1; 
	private int number2; 
	
	
	
	public int getNumber1() { // 전송(출력)
		return number1;
	}
	public void setNumber1(int number1) { //대입
		this.number1 = number1;
	}
	public int getNumber2() {
		return number2;
	}
	public void setNumber2(int number2) {
		this.number2 = number2;
	}
	
	
	
	public Test4() { //생성자 함수: public ___(클래스)__ { : 이걸 생략하면 초기화 (0), 명시하면 입력해둔 값이 초기화값
		number1 = 100; 
		number2 = 200;
	}
	public static void main(String[] args) {
		Test4 test4 = new Test4(); // 생성자 호출	==> 초기화 (0) 
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		
		test4.setNumber1(300);
		test4.setNumber2(400);
		
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		
		System.out.println(test4.getNumber1());
		System.out.println(test4.getNumber2());

		test4.setNumber1(30); 
		test4.setNumber2(40);
		
		System.out.println(test4.number1);
		System.out.println(test4.number2);
		
	}
}
