package kr.co.bit.obj2;
/*객체형 반복문
 * 배열 객체에 저장되어 있는 값을 출력. 
 */


public class Array_Test5 {

	public static void main(String[] args) {
		String[] str = new String[] {"홍", "김", "이", "박", "최"};
		for(String name:str) { // name(1개씩):(=) str 배열방의 값을 하나씩 가져온다. 
			/* 숫자가 아닌 문자열 객체(클래스타입) 을 둔다. name: 배열방 str
			 * 배열 객체와 객체일 때만 실행 가능하다. 
			 */
			System.out.println(name);
		}
// str 배열객체 
// name 문자열객체 
	}

}
