package kr.co.bit;

public class StringTest1 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("Java");
		StringBuffer sb2 = sb.append("Fighting!" );
		System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb == sb2);
				//.equals�� �ƴ϶� == ���� ���ص�, ���� ������ ����Ű�� ������ == / .equals ��� true 
		System.out.println(sb.equals(sb2));
	}

}
