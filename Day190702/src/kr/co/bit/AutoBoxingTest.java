package kr.co.bit;
/*
 * �⺻�� ������ Ŭ���� �ȿ� ���� > ����ڽ� 
new �����ڸ� ������ �ʴ��� ���� �����ϳ�, new�� ��ü�� �����Ͽ� �־��ִ� ���� ����(���� ���� �ľ��� �� �ִ�. )
�� �⺻��(���� �ϳ�, ���� �����ϴ� ����) ����, Ŭ������ �����[����ȯ]���ν�, �������� ������ ����� �� ������, �޼ҵ带 ����� �� �ֵ��� �Ѵ�.  [��ü ��� ����]

�����ڽ� 
��ü�� ����ִ� ������ �������� ��
�� �⺻������ ���ƿ� [��ü ��� �Ұ�]
 */
public class AutoBoxingTest {

	public static void main(String[] args) {
		//1.4: ���� ������ ���� ������. 
		int var_int1 = 3; 
		Integer intObj1 = new Integer(var_int1);
		System.out.println(intObj1);
		
		//1.5 update
		intObj1 = var_int1; 
		System.out.println(3.14);

		Double intObj2 = new Double(5.1264f);
		System.out.println(3+intObj2);
		// ���ڿ��� �ش��ϴ� �κ���, ��ü�� �ٲ����ν� ���������� ����ȯ
		int var_int2 = intObj2.intValue(); // intValue(): Integer Ŭ�������� int�� �� �̾Ƴ��� �Լ�.
		System.out.println(var_int2);
		//1.5 update
		//var_int2 = intObj2;
	}

}
