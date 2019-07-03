package Prac0701;

public class ExpTest2 {

	public void method2() {
		throw new NullPointerException();
	}
	
	
	public static void main(String[] args) {
		ExpTest2 test2 = new ExpTest2();
		try {
			test2.method2();
		} catch (Exception e) {
			System.out.println("런타임 >> 호출된 곳[메인메소드]에서 예외처리");
		}

	}

}
