package kr.co.bit;
//Test test = new Test();
//throw Anonymous anonymous = new NullPointerException(); �̶�� �͸� Ŭ������ �ڵ� ������. �̸��� ���� ������ ������ �͸� Ŭ������ ����  
//throw new NullPointerException(); //excepthionMethod ���� nullpointerException�� ������ 
//��ü�� ���� ������ (throw)

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
