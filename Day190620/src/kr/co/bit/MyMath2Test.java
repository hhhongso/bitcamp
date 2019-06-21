package kr.co.bit;

public class MyMath2Test {

	public static void main(String[] args) {
		System.out.println(MyMath2.add(100L, 200L)); // static 함수 . 파라미터값 가져감 
		
		MyMath2 math = new MyMath2(); // 인스턴스 생성자 
		math.a = 100L; // Long 
		math.b = 100L;
		long result = math.add();
		System.out.println(result);

		
	
	}

}
