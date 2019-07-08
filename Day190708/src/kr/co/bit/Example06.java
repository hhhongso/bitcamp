package kr.co.bit;

public class Example06 {
	// <T extends Number> << 이렇게 타입 제한할 수도 잇음 
	
		// return type*(void 앞에 타입을 선언해줌으로써, 외부 클래스에서 메소드를 사용할 때, 메소드 사용 시 사용하고자 하는 타입을 넣어줌 >> T타입 제네릭 적용  
	public static <T> Box<T> boxing(T t) { 
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}

	public static void main(String[] args) {
		Example06 ex = new Example06();
		// ex.boxing("String");
		
		Box<Integer> box1 = Example06.<Integer>boxing(50); //명시적 선언 
		System.out.println(box1.get());
		
		Box<String> box2 = boxing("가나다"); // 생략하거나 (암묵적 선언)
		System.out.println(box2.get());
	}

}
