package kr.co.bit;

public class Test2 {

public int max(int a, int b) {
	int result = 0; 
	if (a > b) 
		result = a;  
	else 
		result = b;
		return b;
		// 명령어가 하나일 때는 {} 제외하여도 된다 
		// return 명령어는 하나만 있는 게 좋다. 
		/* if (a>b)
		 * return a';
		 * else
		 * return b';
		 * 
		 */
	
}
	public static void main(String[] args) {
		Test2 test2 = new Test2();
		int result = test2.max(10, 20);
				// 10, 20 을 던져서 값을 받아 옴 => 받을 값을 넣어둘 곳이 필요 
		// 받아온 값을 result에 넣음 
		System.out.println(result);
	}

}
