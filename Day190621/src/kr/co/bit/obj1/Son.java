package kr.co.bit.obj1;


	 //class 자식  extends 부모: 상속 
public class Son extends Parent {

	protected int number1; 
	
	public Son() {
		
	}
	
	public void sonMethod1() {
		System.out.println("자식함수");
	}
	
	
	public static void main(String[] args) {
		Son son = new Son();
		son.age = 10;
		son.parentMethod1(); 
		System.out.println("부모의 나이: " + son.age);
		
		son.number1 = 100;
		son.sonMethod1();
		System.out.println("자식숫자: " + son.number1);
	}
}
