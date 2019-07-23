

class ConstructorMain {
	private String name; 
	private int age; 

	public ConstructorMain(){
		System.out.println("기본 생성자(default): 파라미터값이 없음");
	}

	public ConstructorMain(String name){ //생성자 Overload
		this();
		System.out.println("this= " + this);
		this.name = name;		// this. 자기자신 클래스의 참조값을 가지고 있음. 
	}

	public ConstructorMain(int age){
		this("코난"); //this();: 오버로드 된 다른 생성자를 호출 **this(), super() 로 생성자를 호출 시, 반드시 첫번째 줄에 위치하여야 한다. **
		System.out.println("this= " + this);
		this.age = age;
			//생성자는 강제호출할 수 없다(new 할 시 호출). ***단, 오버로드 된 생성자끼리는 강제 호출이 가능하다.  ***
	}

	public static void main(String[] args) { //[1] 프로그램 돌리면 main점부터 시작

		ConstructorMain cm = new ConstructorMain();
		System.out.println("cm= " + cm);
		System.out.println("이름: " + cm.name + "	나이: " + cm.age);
		System.out.println();

		ConstructorMain cm2 = new ConstructorMain("홍길동");
		System.out.println("cm2= " + cm2);
		System.out.println("이름: " + cm2.name + "	나이: " + cm2.age);
		System.out.println();

		ConstructorMain cm3 = new ConstructorMain(28);
		System.out.println("cm3= " + cm3);
		System.out.println("이름: " + cm3.name + "	나이: " + cm3.age);
	}
}





/*
클래스 = 가상화. 
생성자의 목적? 객체 초기화 (Garbage 값을 없앤다)
1. 클래스명과 동일하다 
2. 리턴타입이 없다 
3. 생성자가 하나도 없을 시, 자동으로 default 생성자 호출 
*/