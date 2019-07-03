package Prac0701;
/*
 * throw ?
 * throw: [1개]
 * 1) 강제로 예외를 발생시킨다.  
 *  - RuntimeExp: 실행 시 에러 발생. 코드 내에서는 빨간 줄이 그어지지 않음. (ex)Nullpointer, Numberformat ==> 호출된 곳[메인메소드]에서 예외처리 
 *  - CompileExp: 컴파일 시 에러 발생. 코드 내에서 빨간 줄이 그어짐.  ==> 선언된 곳[자기자신]에서 예외처리
 *  
 *  
 * throws: [2개 이상]
 * [예외전가] 현재 메소드에서 -> 자신을 호출하는 상위 메소드로 예외를 던지는 것. ==> 상위 메소드에 책임 전가
 * 메소드나 생성자를 수행할 때 발생하는 exception을 선언할 때 사용 
 * 메소드 선언부에 사용하여 해당 메소드를 사용할 때 발생할 수 있는 예외를 미리 명시한다. 
 * -> 사용자가 예외를 인지할 수 있으며, 그에 대한 처리까지 강제할 수 있다. 
 *
 */


public class ExpTest {
	
	public void expMethod1() {
		try {
			throw new ClassNotFoundException();
		} catch (ClassNotFoundException e) {
			System.out.println("컴파일>> 선언된 곳[자기자신 메소드]에서 예외 처리");
		}
	}

	public static void main(String[] args) {
		 ExpTest test1 = new ExpTest();
		 test1.expMethod1();
		 
	
}
}
