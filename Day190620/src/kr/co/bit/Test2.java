package kr.co.bit;

public class Test2 {

public int max(int a, int b) {
	int result = 0; 
	if (a > b) 
		result = a;  
	else 
		result = b;
		return b;
		// ��ɾ �ϳ��� ���� {} �����Ͽ��� �ȴ� 
		// return ��ɾ�� �ϳ��� �ִ� �� ����. 
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
				// 10, 20 �� ������ ���� �޾� �� => ���� ���� �־�� ���� �ʿ� 
		// �޾ƿ� ���� result�� ���� 
		System.out.println(result);
	}

}
