package kr.co.bit;

public class First1 {
	/*
	 * 정수형 데이터 타입: byte, short, int, long
	 * 문자형			: char
	 * 실수형			: float, double
	 * 논리형			: boolean (T / F)
	 */
	public static void main(String[] args) {
		byte number1 = -128;
		System.out.println(number1);
		short number2 = 32767;
		System.out.println(number2);
		int number3 = 300000;
		System.out.println(number3);
		long number4 = 40000000;
		System.out.println(number4);
		char alpha = 'A';
		System.out.println(alpha);
		String str = "안녕하세요";
		System.out.println(str);
		float sil = 1.5f; //실수는 double형(8byte)을 디폴트로 하기 때문에, float(4byte)형을 사용 시 f를 붙여 명시화 하여야 한다. 
		System.out.println(sil);
		double sil1 = 1.5;
		System.out.println(sil1);
		boolean logic = true;
		System.out.println(logic);
		logic = false;
		System.out.println(logic);
	
	
	
	}

}
