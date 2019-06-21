package kr.co.bit.obj2;
// 배열선언 

public class Array_Test1 {

	public static void main(String[] args) {
		//배열 선언
		int arrayNumber[];
		String names[];
		
		//배열 객체 생성: new 연산자
		arrayNumber = new int[3]; 
		names = new String[3];
		
		//초기화 
		arrayNumber[0] = 1; 
		arrayNumber[1] = 2; 
		arrayNumber[2] = 3; 
		
		names[0] = "홍길동";
		names[1] = "전우치";
		names[2] = "김철수";
		
		//값 출력
		for(int i = 0; i < 3; i++) { // 왜 length 로 안하고 3이라고 직접 입력 ? 
			System.out.println("arrayNumber[" + i + "]= " +arrayNumber[i]);
			System.out.println("names[" + i + "]= " +names[i]);
		}

	}

}
