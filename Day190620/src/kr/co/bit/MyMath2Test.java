package kr.co.bit;

public class MyMath2Test {

	public static void main(String[] args) {
		System.out.println(MyMath2.add(100L, 200L)); // static �Լ� . �Ķ���Ͱ� ������ 
		
		MyMath2 math = new MyMath2(); // �ν��Ͻ� ������ 
		math.a = 100L; // Long 
		math.b = 100L;
		long result = math.add();
		System.out.println(result);

		
	
	}

}
