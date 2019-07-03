package kr.co.bit;

public class StringTest1 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Java");
		StringBuffer sb2 = sb.append("Fighting!" );
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb == sb2);
				//.equals가 아니라 == 으로 비교해도, 같은 공간을 가리키고 있으니 == / .equals 모두 true 
		System.out.println(sb.equals(sb2));
	}

}
