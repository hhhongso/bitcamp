package kr.co.bit;

public class Person {

	public int age; 
	public String name; 
	public int height; 
	public int weight; 
	
	//toString() 함수: 클래스가 가지고 있는 모든 멤버변수의 값을 가져오도록 한다.
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", height=" + height + ", weight=" + weight + "]";
	}
	
	public Person() { // 파라미터 값이 없는 생성자 함수 초기화 ==> 아래 내용을 안써줘도 컴퓨터가 알아서 컴파일러 함
		this.age = 0; 
		this.name = null; 
		this.height = 0;
		this.weight = 0;
		
	}

	public Person(int age) { // 파라미터 변수를 가진 생성자 함수
		this.age = age; // this.age ==> Person 클래스의 멤버변수 
						// age ==> Person(int age) 생성자 함수의 파라미터 값
	}
	
	public Person(String name) {
		this.name = name; 
	}
}
