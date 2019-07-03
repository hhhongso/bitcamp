package kr.co.bit;
/*
 * throw ?
 * throw: 억지로 에러를 발생 시킬때에도 사용하지만,
 * 		[예외발생] 메소드 내에서 상위 블럭으로 예외를 던지는 것. ==> 자기 자신이 예외 처리  
 * 		 현재 메소드의 에러를 처리한 후에 -> 상위 메소드에 에러 정보를 줌으로써, 상위 메소드에서도 에러가 발생한 것을 감지가능 
 * throws: [예외전가] 현재 메소드에서 -> 자신을 호출하는 상위 메소드로 예외를 던지는 것. ==> 상위 메소드에 책임 전가
 * 		메소드나 생성자를 수행할 때 발생하는 exception을 선언할 때 사용 
 */

/*
 * 사용자 정의 예외 생성 
 * 예외클래스 최상위 클래스인 java.lang.Exception 클래스를 상속받아 클래스를 정의한다. (그래야 RuntimeException도 상속받아 실행 시 자동으로 try/catch가 컴파일 될 수 잇으니까 
 * 
 */
public class ExceptionTest6 {

	public void exceptionMethod() throws Exception { 
		throw new ClassNotFoundException();
	}
	
	
	public static void main(String[] args) {
		ExceptionTest6 et6 = new ExceptionTest6();
		try {
			et6.exceptionMethod();
		} catch (Exception e) {
			System.out.println("캐치캐치");
		}


	}
	
	
	
	
	
	
	public void method() throws Exception {
		throw new Exception();
	}
	
	
	
	
	
	
	
	
	

}
