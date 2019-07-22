package kr.co.bit;

import java.util.ArrayList;

public class RoundTest {
	public static void main(String[] args) {
		double a = 12.456789;
		double b = a*1000; //12456.789
									//12457 / 1000 = 12.457
		System.out.println(Math.round(b)/1000.0);
		System.out.printf("%.3f", a);
		System.out.println();
		
		String abc ="abcde";
		if(abc.charAt(0) == 'a' ||abc.charAt(1) == 'b' ) 
			System.out.println("ab");		
		
	ArrayList list = new ArrayList();

	}

}
