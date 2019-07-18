package kr.co.bit;

public class RoundTest {
	public static void main(String[] args) {
		double a = 12.456789;
		double b = a*1000; //12456.789
									//12457 / 1000 = 12.457
		System.out.print(Math.round(b)/1000.0);
		System.out.printf("%.3f", a);

	}

}
