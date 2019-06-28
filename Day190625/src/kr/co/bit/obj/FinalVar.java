package kr.co.bit.obj;

class VarClass {
/*
 * 같은 클래스에서 만들어진 x, y 객체 
 * static > 공유가능 
 * 
 * final(마지막, 최종, 종단, 종결)
 * 변수에 final이 붙으면 >> 상수화 
 * class에 final이 붙으면>> 클래스 자체를 상속불가  
 * 메소드에 final이 붙으면>> 클래스가 상속이 되어있더라도 함수는 상속불가 
 *   
 * 
 * final 상수는 대문자를 주력으로 사용한다. 
 * 
 */
	final int x; 
	static final int y;  // 공유형 (static)
	
	final double PI; // 파이값은 초기값으로 
	static {
		y = 100; // 처음 값만 인정한다. (처음값이 final로 지정, 다른 값으로 변경되지 않는다. ) ==> 상수 
	}
	
	public VarClass(int x) {
		this.x = x; 
		PI = 3.141592; // 값을 저장하고 종결(final). 변수의 값으로 사용할 수 없다. (숫자로 적혀져 있는 문자상수의 개념)  
	}
}

public class FinalVar {

	public static void main(String[] args) {
		//VarClass.y = 5;
		
		VarClass vc1 = new VarClass(10); // 첫번째 대입된 처음 값은 인정 ===> 상수
		//vc1.y = 50; // 상수가 되었으니 값을 바꿀 수 없다. (변수의 기능 상실)
		//vc1.x = 100;
		
		VarClass vc2 = new VarClass(500);
		//vc2.y = 70;
		//vc2.x = 90;

		System.out.println(vc1.x + 5);
		System.out.println(vc2.x + vc2.y);
	}

}
