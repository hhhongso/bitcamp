package kr.co.bit;
/*
 * �����ε� (�Ķ���� Ÿ���� �ٸ��� �Լ� �̸��� �����ϰ� ����� �� �ִ�. )

������ : �ϳ��� ���(���� Ŭ���� �̸�)�� �ð�, ��ҿ� ���� �ٸ� ����� �Ѵ�. 

1) �ߺ� (�����ε�)
�ϳ��� Ŭ�������� �پ��� ����� �۾��� �� �� ��� 
�Ķ������ Ÿ���̳� ������ �޶�� �Ѵ�. 
 �Ķ������ �̸��� �����ε� ������ ������ ���� ���� ( ���� Ÿ�Կ� �̸��� �ٸ��� X. )
 ����Ÿ���� �����ε� ������ ������ ���� �ʴ´�. 
 public void printInfo (String A);
 public int printInfo(String A);


2) �ߺ� (�������̵�)
�������� Ŭ�������� �پ��� ����� �۾��� ������ �� ��� 

 */
public class Args { // �ϳ��� Ŭ���� �ȿ� 
	public void add(int x) {
		System.out.println("���� 1");
	}

	public void add(String str) { // ���� �Լ�, �ٸ� �Ķ���� (�����ε�)
		System.out.println(str + "���ڿ� �޾Ƽ� ���");
	}
	
	public void add (double sil) { // ���� �Լ�, �ٸ� �Ķ���� (�����ε�)
		System.out.println(sil + "�Ǽ��� �޾Ƽ� ���");
	}
	
	public static void main(String[] args) {
		Args arg = new Args ();
		arg.add(10);
		arg.add(1.5);
		arg.add("������");
		
	}
}
