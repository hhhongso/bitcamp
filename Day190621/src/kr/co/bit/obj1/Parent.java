package kr.co.bit.obj1;
/*
 * 클래스 상속 == 유지 보수를 위한 기술 
 * 
부모 클래스도 
자식 클래스도 
부모 클래스의 것을 사용할 수 있다 (재사용)

자식 클래스는
자식 클래스에 
부모 클래스 것을 더할 수 잇다 (확장)

/*
 * super(부모)
 * 기본적으로 suplerClass(부모 클래스)는 최상위 클래스인 java.lang.Object 이나,
 * 상속 시키고자 할 경우 superClass 입력 + ctrl+space ==> 부모클래스를 조정할 수 있다. 
 */

/*
 * 다른 패키지에서 끌어오고 싶은 거 => import
 * 같은 패키지에 있는 클래스를 상속하여 재사용하고 싶다면 => superClass
 */

public class Parent {
	
	protected int age; 
	
	public Parent() { // 생성자 함수
		
	}
	
	public void parentMethod1() { // 함 수 
		System.out.println("부모함수");
	}

}
