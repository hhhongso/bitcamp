package kr.co.bit;

public class ExceptionTest2 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10/num;
			System.out.println(result);
		} catch (Exception e) { // ����ó�� �ֻ��� Ŭ���� Exception 
			System.out.println("0���� ������ ���ÿ�");
			//e.printStackTrace(); // ȸ�簡 ������ �����޼����� �ڵ����� ������: java.lang.~~by zero~~ 
		}
		System.out.println("���α׷��� ��� �����Ѵ�. "); // *catch �Ŀ��� �ߴܵ��� ����* 

	}

}
