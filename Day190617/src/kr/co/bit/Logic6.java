package kr.co.bit;

public class Logic6 {
	// �� ���� ���ڸ� �о�鿩 ��Ģ������ ����� 
	
	public static void main(String[] args) {
		int num1 = Integer.parseInt(args [0]);
		int num2 = Integer.parseInt(args [1]); 
		String operation = args[2];
		int result = 0; 
		
		if (operation.equals("+")) {
			result = num1 + num2; 
		} else if (operation.equals("-")) {
			result = num1 - num2;
		} else if (operation.equals("X") || operation.equals("x")) {
			result = num1 * num2;   // args ������ * �� ���Ұ�?
		} else if (operation.equals("/")) {
			result = num1 / num2;
		}
		if (result != 0) {
			System.out.println(num1 + operation + num2 + "=" + result);
		} else { // result = 0 ;
			System.out.println("�����ڰ� �߸��Ǿ����ϴ�. ");
		}

	}

}
