package kr.co.bit;

public class Example07 { //클래스 안에
	class InnerClass1 { // 인스턴스 클래스 선언
		int field1; 
		public InnerClass1() {} // 생성자 함수 선언 [가능]
		void method1() {} // 일반 메소드 선언 [가능]
//		static int field2; // 인스턴스 클래스에서 스태틱 필드 선언 [불가]
//		static void method2() {} // 		스태틱 메소드 선언 [불가]
	}
	
	static class InnerClass2 { // 스태틱 클래스 선언
		int field1; 
		public InnerClass2() {} // 생성자 함수 선언 [가능]
		void method1() {} // 일반 메소드 선언 [가능]
		static int field2; // 스태틱 클래스에서 스태틱 필드 선언 [가능]
		static void method2() {} // 		스태틱 메소드 선언 [가능]
	}
	
	
	/*로컬클래스와 인스턴스 클래스의 차이점: 로컬 클래스는 자신이 선언되어 있는 메소드 안에서만 구현이 가능. */
	public void method1() {
		class InnerClass3 { // 지역 클래스 선언 (메소드 안에서 로컬 클래스로 선언) 
			int field1; 
			public InnerClass3() {} // 생성자 함수 선언 [가능]
			void method1() {} // 일반 메소드 선언 [가능]
//			static int field2; // 로컬 클래스에서 스태틱 필드 선언 [불가]
//			static void method2() {} // 		스태틱 메소드 선언 [불가]
//		}
		InnerClass3 ic = new InnerClass3(); // [가능]
	}
}
//	InnerClass3 ic = new InnerClass3(); // [불가] 로컬 영역을 벗어남
	
	
	public static void main(String[] args) {
		Example07 ex = new Example07();
		new Example07(); //어차피 1번 선언하고 사용한 뒤에는 끝이니까,
		
		
		
		Interface1 inter1 = new Interface1() {  //익명클래스로 선언
 			@Override
			public void method1() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void method2() {
				// TODO Auto-generated method stub
				
			}
			
		};//익명클래스로 선언
		
	}
}
