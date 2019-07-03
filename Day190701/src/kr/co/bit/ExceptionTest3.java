package kr.co.bit;

public class ExceptionTest3 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10/num; 
			System.out.println(result);
		} catch(ArrayIndexOutOfBoundsException e1) { //아무것도 입력하지 않았을 때
			e1.printStackTrace();			
		} catch(NumberFormatException e2) { //숫자가 아닌 값이 입력되었을 때의 오류
			e2.printStackTrace();
		} catch(ArithmeticException e3) { //0으로 나눌때의 오류
			e3.printStackTrace();
		}

	}

}
