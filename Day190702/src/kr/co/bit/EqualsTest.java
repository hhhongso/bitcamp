package kr.co.bit;

class Student3 {
	private String name; 
	private int number; 
	
	public Student3(String name, int number) {
		super();
		this.name = name;
		this.number = number;
	}
}

public class EqualsTest {

	public static void main(String[] args) {
		Student3 st1 = new Student3("학생김", 1);
		Student3 st2 = new Student3("학생김", 1);
		System.out.println(st1 == st2); // == : extends Object 의 equals를 부른 것. 주소값을 비교 >> false
		System.out.println(st1.equals(st2)); // equals는 문자열만을 비교함. 즉, 위의 (문자열, 숫자) 의 비교가 불가하다. >> 오버라이드하여 재정의 필요 
		System.out.println(st1);
		System.out.println(st2);
	}

}
