package kr.co.bit;
/*
 * throw ?
 * throw: ������ ������ �߻� ��ų������ ���������,
 * 		[���ܹ߻�] �޼ҵ� ������ ���� ������ ���ܸ� ������ ��. ==> �ڱ� �ڽ��� ���� ó��  
 * 		 ���� �޼ҵ��� ������ ó���� �Ŀ� -> ���� �޼ҵ忡 ���� ������ �����ν�, ���� �޼ҵ忡���� ������ �߻��� ���� �������� 
 * throws: [��������] ���� �޼ҵ忡�� -> �ڽ��� ȣ���ϴ� ���� �޼ҵ�� ���ܸ� ������ ��. ==> ���� �޼ҵ忡 å�� ����
 * 		�޼ҵ峪 �����ڸ� ������ �� �߻��ϴ� exception�� ������ �� ��� 
 */

/*
 * ����� ���� ���� ���� 
 * ����Ŭ���� �ֻ��� Ŭ������ java.lang.Exception Ŭ������ ��ӹ޾� Ŭ������ �����Ѵ�. (�׷��� RuntimeException�� ��ӹ޾� ���� �� �ڵ����� try/catch�� ������ �� �� �����ϱ� 
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
			System.out.println("ĳġĳġ");
		}


	}
	
	
	
	
	
	
	public void method() throws Exception {
		throw new Exception();
	}
	
	
	
	
	
	
	
	
	

}
