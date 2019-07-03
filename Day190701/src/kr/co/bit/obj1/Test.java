package kr.co.bit.obj1;

public class Test {

	public static void main(String[] args) {
					  //0123456789 의 배열방으로 컨트롤됨 => index[0] = t
		String test1 = "testString";
		String test2 = "testString";
		System.out.println(test1 == test2);
		System.out.println(test1.equals(test2));
		// => 동일한 문자열배열일 시 메모리 공간을 하나만 만들어서 test1, test2가 같이 사용한다. 

		//new로 객체생성 시, 각기 다른 메모리 공간을 만들어줌 ===> 아래와 같이 여부 체크할 수 있다. 
		String test3 = new String("testString");
		String test4 = new String("testString");
									//== : 직접비교.  // .equals(): 클래스 주소로 비교
		System.out.println(test3 == test4);
		System.out.println(test3.equals(test4));
	
	
	
	}

}
