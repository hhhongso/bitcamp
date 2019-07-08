package kr.co.bit;

public class Example05 {
	public static void main(String[] args) {
		Box<String> box1 = new Box<String>(); //Box<T> 의 T 타입 규정 >> type에 대한 책임을 개발자가 지도록 함  
		box1.set("AbC");
		System.out.println(box1.get());
		
		Box<Double> box2 = new Box<Double>(); //제네릭 타입은 기본형을 제공하지 않는다. !*참조형만 사용*! >> Wrapper 클래스를 입력
		box2.set(3.14);
		System.out.println(box2.get());
	}
}
