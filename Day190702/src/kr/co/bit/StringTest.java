package kr.co.bit;

public class StringTest {

	public static void main(String[] args) {
		String originString = new String("Java");
		String lastString = originString.concat("Fighting!");
		System.out.println(originString);
		System.out.println(lastString);
		System.out.println(originString == lastString);
	}

}
