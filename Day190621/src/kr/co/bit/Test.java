package kr.co.bit;

public class Test {

	int number1; 
	int number2; 
	
	/* [1]
	 * �������Լ��� ���������� �ʴ´ٸ�, �����Ϸ��� �ڵ����� �Ķ���� ������ ���� ������ �Լ��� ����������, 
	 * �����ڰ� �Ű������� �ִ� ������ �Լ��� ���� ������ٸ�, �����Ϸ��� �Ű������� ���� ������ �Լ��� �������� �ʴ´�.  
	 */
	
	public Test() {
	}
	
	public Test(int number1, int number2) {
		this.number1 = number1; 
		this.number2 = number2;
	}
	
	public static void main(String[] args) {
		/* [1]
		 * ��, �Ķ���Ͱ� ���� Test test1 = new Test();�� 
		 * 			    �ִ�						(50, 100) �� ���� ���� ������ 
		 * �Ű������� ���� ������ �Լ��� ������ ����� �־�� �Ѵ�. 
		 */
		Test test1 = new Test();
		Test test2 = new Test(10, 100);
		
	}
}
