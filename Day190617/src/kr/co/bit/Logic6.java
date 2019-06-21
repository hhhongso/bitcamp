package kr.co.bit;

public class Logic6 {
	// 두 개의 숫자를 읽어들여 사칙연산자 만들기 
	
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
			result = num1 * num2;   // args 값으로 * 는 사용불가?
		} else if (operation.equals("/")) {
			result = num1 / num2;
		}
		if (result != 0) {
			System.out.println(num1 + operation + num2 + "=" + result);
		} else { // result = 0 ;
			System.out.println("연산자가 잘못되었습니다. ");
		}

	}

}
