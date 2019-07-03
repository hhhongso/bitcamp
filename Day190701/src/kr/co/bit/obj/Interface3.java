package kr.co.bit.obj;

interface In1 {
	int x = 10; // public static int 로 컴파일러가 자동으로 코딩 
	void in1Method(); // public abstract void로 자동으로 코딩
}

interface In2 {
	public static int x = 20; 
	public abstract void in1Method(); // In1의 함수와 동일 ==> 하나의 메소드로 취급함 
	public abstract void in2Method();
}

interface In3 extends In1, In2 {
	//인터페이스를 상속할 수 있음 
	//but 인터페이스에서는 함수를 정의는 가능하나 구현하지 못하기 때문에, 구현은 완전클래스에 implements 받아서 진행하여야 함. 
}

class ExtendsTest extends Object implements In3 {

	@Override
	public void in1Method() {
		System.out.println("method1 구현");
		
	}

	@Override
	public void in2Method() {
		System.out.println("method2 구현");
		
	}
	
}


public class Interface3 {

	public static void main(String[] args) {
		ExtendsTest ext = new ExtendsTest();
		ext.in1Method();
		ext.in2Method();
		
		System.out.println(In1.x); //변수는 인터페이스 타입명으로 바로 불러옴 
		System.out.println(In2.x);

	}

}
