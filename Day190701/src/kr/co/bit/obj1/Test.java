package kr.co.bit.obj1;

public class Test {

	public static void main(String[] args) {
					  //0123456789 �� �迭������ ��Ʈ�ѵ� => index[0] = t
		String test1 = "testString";
		String test2 = "testString";
		System.out.println(test1 == test2);
		System.out.println(test1.equals(test2));
		// => ������ ���ڿ��迭�� �� �޸� ������ �ϳ��� ���� test1, test2�� ���� ����Ѵ�. 

		//new�� ��ü���� ��, ���� �ٸ� �޸� ������ ������� ===> �Ʒ��� ���� ���� üũ�� �� �ִ�. 
		String test3 = new String("testString");
		String test4 = new String("testString");
									//== : ������.  // .equals(): Ŭ���� �ּҷ� ��
		System.out.println(test3 == test4);
		System.out.println(test3.equals(test4));
	
	
	
	}

}
