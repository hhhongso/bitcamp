package kr.co.bit.obj;

class Vehicle1 {
	public void move() { // 완전메소드
		System.out.println("움직인다. ");
	}
}

interface Flyable {
	public abstract void fly(); //추상메소드 
	
	//변수, 함수는 다중상속 시 혼동이 일어나기 때문에 
	//변수, 완전메소드는 입력하지 말고, 추상의 것만 입력하여 오버라이드로 구현할 수 있도록 한다. 
}

class IMP2 extends Vehicle1 implements Flyable {

	@Override
	public void fly() {
		System.out.println("비행한다. ");
	}
	
}

public class Interface2 {

	public static void main(String[] args) {
		IMP2 imp2 = new IMP2();
		imp2.move();
		imp2.fly(); //자식클래스의 객체로 만들어 인터페이스를 호출
		
		Flyable fable = (Flyable) new IMP2(); // UPcasting
		fable.fly(); //부모클래스의 객체로 만들어 인터페이스를 호출

		/*
		 * 인터페이스의 중요 핵심 
		 * 
		 */
		
	}

}
