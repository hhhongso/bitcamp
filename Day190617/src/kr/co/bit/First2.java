package kr.co.bit;

public class First2 {

	public static void main(String[] args) {
		byte number1 = 10;
		int number2 = number1; 
		// (묵시적 형변환) 4byte 변수에 1byte 를 대입 => 컴파일러가 자동으로 int 으로 형변환하기 때문에, int를 명시하여 주지 않아도 된다.
		
		int number3 = 150;
		byte number4 = (byte)number3;
		// (명시적 형변환) 1byte 변수에 4byte 를 대입할 수 없음 => 개발자가 형을 명시적으로 적어주어야 된다. (이 경우, 개발자가 모든 책임을 진다)
		// 단, 형변환 시 대입할 수 있는 범위의 숫자여야만 가능하다. 
		System.out.println(number4);
	
		byte number5 = 50;
		byte number6 = 40;
		int sum = number5 + number6; // 1byte + 1byte == 4byte;
		System.out.println(sum);
		
		//ASCII 문자 코드표: A를 숫자(비트수)로 변환하도록 지원 
		char c1 = 'A';
		int sum1 = c1 + 1;
		System.out.println(sum1);
		
		int d1 = 65;
		System.out.println((char)d1);
		
		char e1 = 'a';
		int sum2 = e1 + 1;
		System.out.println(sum2);
	}

}
