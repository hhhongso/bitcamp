package kr.co.bit;

public class typeConvertTest {

	public static void main(String[] args) {
		int num1 = 3; 
		String num2 = "4";
		System.out.println(num1+num2);
		
		int intNum = Integer.parseInt(num2); //parseint >> String 객체에서 int형 값을 뽑아내는  함수
		System.out.println(num1+ intNum);
		
		String numStr = "3.14";
		System.out.println(num1 + numStr);
		
		double numDouble = Double.parseDouble(numStr);
		System.out.println(num1 + numDouble);
	}

}
