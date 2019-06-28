package kr.co.bit.obj;

public class Son extends Father {
	protected double shoes; //변수를 상속받아 사용하고 
	public Son() {
		System.out.println(super.shoes); // 부모클래스의 값을 가져오기 위해서는 >>> super.로 부모클래스의 변수를 가져와야 부모의 변수를 사용할 수 있다. 
		shoes = 250.55; //변수의 값이 부모와 자식이 다르다. => 자식클래스에서 값을 초기화하였기 때문에 

	}

	public static void main(String[] args) {
		Son son = new Son();
		System.out.println(son.shoes); // 자식 클래스의 변수값이 출력이 됨 
	}
}
