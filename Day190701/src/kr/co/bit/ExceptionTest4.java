package kr.co.bit;

public class ExceptionTest4 {

	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		try {
			int result = 10/num; 
			System.out.println(result);
		} catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();
		} catch (NumberFormatException e2) {
			e2.printStackTrace();
		} catch (ArithmeticException e3) {
			e3.printStackTrace();
		} finally {
			System.out.println("예외 여부와 관계없이 무조건 수행."); //  Connection - 연결 - <close>할 때 주로 사용
		}
		
		//finally 안쓰고 그냥 } 마지막에 문장 쓰는거랑 차이가 무엇? 

	}

}
