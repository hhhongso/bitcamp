package kr.co.bit;
//Test test = new Test();
//throw Anonymous anonymous = new NullPointerException(); 이라고 익명 클래스를 자동 컴파일. 이름이 없을 때에만 스스로 익명 클래스를 돌림  
//throw new NullPointerException(); //excepthionMethod 에서 nullpointerException을 강제함 
//객체를 직접 던져라 (throw)

public class ExceptionTest5 {

	public void exceptionMethod() {
		try {
			throw new ClassNotFoundException();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExceptionTest5 et5 = new ExceptionTest5();
		et5.exceptionMethod();
		
	}

	
	
	
	
	
}
