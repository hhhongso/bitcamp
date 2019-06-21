package kr.co.bit;

public class Test3 {

	int iv;  // instance 변수 ==> 스택영역으로
 	public static int cv; // static ==> static 영역으로 
 

 	public void test1() { // 인스턴스 메소드 ==>힙 영역으로 
 		System.out.println(iv);
 		System.out.println(cv); // 인스턴스 메소드/변수에서는 클래스 메소드/변수 가용 가능
 	}
 	public static void test2() { //클래스 메소드 ==> static 영억으로 
 		//System.out.println(iv);
 		System.out.println(cv);
 		
 	}

	public void instanceMethod1() { // 인스턴스 메소드
		test1(); 
		test2(); // 인스턴스 메소드/변수에서는 클래스 메소드/변수 가용 가능
	}
	
	public static void staticMehod() { //클래스 메소드
		//test1(); // 클래스 메소드/변수에서 인스턴스 메소드/변수를 사용할 수 없음. 
		test2();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
