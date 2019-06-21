package kr.co.bit.obj2;
// 문자열 (배열)초기화 = {} 
// 초기값을 {} 안에 넣는다. 

public class Array_Test3 {

	public static void main(String[] args) {
		 				//	0		1		2	  3		 4
		String[] cities = {"서울", "대구", "춘천", "광주", "천안"};
		String[] nations = new String[] {"미국", "영국", "일본", "프랑스"};
		/*new 연산자 가 없다면 ?
		 * 메모리 영역의 한 쪽 구역(Stack)에서만 작업이 이루어 진다. 
		 * => new를 이용하여 메모리 공간을 이중으로 분리, Heap(동적영역, 메모리공간)으로 들어가 배열을 세팅함 => 보다 넓게 공간을 활용.  
		 */
		
		//배열값 출력
		for(int i = 0; i < cities.length; i++) {
			System.out.println(cities[i]);
		}
		for(int i = 0; i < nations.length; i++) {
			System.out.println(nations[i]);
		}
	}

}
