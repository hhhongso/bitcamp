import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

class NumberTest {
	public NumberTest(){
		//3자리마다, 소수 이하 3째 자리까지
		NumberFormat nf = new DecimalFormat(); // 자식클래스인 DecimalFormat으로 생성자 호출 
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		//3자리마다, 소수 이하 1째 자리까지. 유효숫자만 #이 표시해둔 자릿수에 들어온다 (반올림됨)
		NumberFormat nf2 = new DecimalFormat("#,###.#원"); 
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();

		//3자리마다, 소수 이하 2째 자리까지. .00 이라고 설정 시, 유효숫자가 아니더라도 0을 찍어준다. 
		NumberFormat nf3 = new DecimalFormat("#,###.00원"); 
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();

		//static 메소드로 생성자 함수 호출하기. 
//		NumberFormat nf4 = NumberFormat.getInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		nf4.setMaximumFractionDigits(1); // 소숫점 이하 1자리까지만 표현하라
		nf4.setMinimumFractionDigits(1); // 유효 숫자가 없더라도 최소한 소숫점 1자리는 표현하라 
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();

		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(5); // 소숫점 이하 1자리까지만 표현하라
		nf5.setMinimumFractionDigits(2); // 유효 숫자가 없더라도 최소한 소숫점 1자리는 표현하라 
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
	}

	public static void main(String[] args) {
		// 생성자를 단발성으로 사용한다면 객체명(nt) 없이 new 할 수 있음. 사용 후 버려진 것은 GC에 축적된다. GC가 가동되는 동안 프로그램은 일시 중지된다. 
		new NumberTest(); 
		
	}
}
