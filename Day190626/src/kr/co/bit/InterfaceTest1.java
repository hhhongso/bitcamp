package kr.co.bit;
 /*
  * 인터페이스는 불완전한 타입, 클래스가 아니며, 객체를 생성할 수 없다. 변수, 함수 사용은 가능.
  * ** 다향성의 극대화 **
  * 
  */
interface Interface1 {
	public int interVar =10; 
		//인터페이스는 static을 안쓰더라도 자동으로 컴파일러
		//확실 변수/함수는 그대로 상속되며
	public abstract void interfaceMethod(); 
		//불확실함수는 implements > override 
}
				
				/* 다중상속처럼 사용하고 싶으나, java는 원천적으로 불가함 (부모는 1개뿐)
				 *  ==>  Interface를 만들어 붙이면 기존 부분을 유지하며 Interface를 상속받는 것 처럼 구현이 가능하다. 
				 *  인터페이스는 하나의 약속. 인터페이스를 상속 받으면 override implements(구현) 이 가능하다. 
				 *  ex) 
				 *  메뉴판 == 인터페이스; 
				 *  메뉴 & 가격 
				 *  
				 */

interface Interface2{
	public abstract void interfaceMethod2();
}

				//extend 추상클래스 라면 ? >> 
			//extends Object 가 생략되어 있음 >>> 다중상속(Object, Interface1) 
class InterfaceIMP1 implements Interface1, Interface2 {
				
	@Override
	public void interfaceMethod() {
		System.out.println("interfaceMehod 구현");
	}

	@Override
	public void interfaceMethod2() {
		System.out.println("interfaceMathod2 구현");
		
	}
	
}

public class InterfaceTest1 {

	public static void main(String[] args) {
		InterfaceIMP1 inIMP1 = new InterfaceIMP1();
							// static 함수/변수는 클래스 타입으로 호출하니까 
		System.out.println(InterfaceIMP1.interVar);
		inIMP1.interfaceMethod();
		inIMP1.interfaceMethod2();

		Interface1 inTMP1 = new InterfaceIMP1(); // 인터페이스 타입 Interface1에 클래스 타입 InterfaceIMP1 을 
		inTMP1.interfaceMethod();
		
		Interface2 in = new InterfaceIMP1();
		in.interfaceMethod2();
	}

}
