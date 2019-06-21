package kr.co.bit.obj1;
/*
 * 단계별 상속
 */

class Super { //extends Object(최상위 객체)
	protected int number1; 
	public Super() {
		number1 = 500;
	}
	public void superMethod1() {
		System.out.println("할아부지");
	}
}

class Sub extends Super {
	protected int number1;
	public Sub() {
		number1 = 4000; 
	}
	
	public void subMethod1() {
		System.out.println("아부지");
	}
}

class Subsub extends Sub {
	protected int number3; 
	public Subsub() {
		
	}
	public void subsubMethod1() {
		System.out.println("자식");
	}
}

public class ExtendsTest2 { // [1] 메인을 먼저 만들고 시작 ==> 메인 단 밖에서 상속할 클래스 생성 

	public static void main(String[] args) {
		Subsub subsub = new Subsub();
		System.out.println(subsub.number1);
		subsub.number1 = 200; 
		subsub.number3 = 300; 
		System.out.println(subsub.number1 +","+ subsub.number1 +","+ subsub.number3);
		
		subsub.superMethod1();
		subsub.subMethod1();
		subsub.subsubMethod1();
		

	}

}
