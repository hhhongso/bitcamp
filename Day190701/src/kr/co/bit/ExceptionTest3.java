package kr.co.bit;

public class ExceptionTest3 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10/num; 
			System.out.println(result);
		} catch(ArrayIndexOutOfBoundsException e1) { //�ƹ��͵� �Է����� �ʾ��� ��
			e1.printStackTrace();			
		} catch(NumberFormatException e2) { //���ڰ� �ƴ� ���� �ԷµǾ��� ���� ����
			e2.printStackTrace();
		} catch(ArithmeticException e3) { //0���� �������� ����
			e3.printStackTrace();
		}

	}

}
