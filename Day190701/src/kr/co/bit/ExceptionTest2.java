package kr.co.bit;

public class ExceptionTest2 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10/num;
			System.out.println(result);
		} catch (Exception e) { // 예외처리 최상위 클래스 Exception 
			System.out.println("0으로 나누지 마시오");
			//e.printStackTrace(); // 회사가 만들어둔 에러메세지를 자동으로 가져옴: java.lang.~~by zero~~ 
		}
		System.out.println("프로그램은 계속 실행한다. "); // *catch 후에도 중단되지 않음* 

	}

}
