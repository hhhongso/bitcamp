package Prac0701;
/*
 * throw ?
 * throw: [1��]
 * 1) ������ ���ܸ� �߻���Ų��.  
 *  - RuntimeExp: ���� �� ���� �߻�. �ڵ� �������� ���� ���� �׾����� ����. (ex)Nullpointer, Numberformat ==> ȣ��� ��[���θ޼ҵ�]���� ����ó�� 
 *  - CompileExp: ������ �� ���� �߻�. �ڵ� ������ ���� ���� �׾���.  ==> ����� ��[�ڱ��ڽ�]���� ����ó��
 *  
 *  
 * throws: [2�� �̻�]
 * [��������] ���� �޼ҵ忡�� -> �ڽ��� ȣ���ϴ� ���� �޼ҵ�� ���ܸ� ������ ��. ==> ���� �޼ҵ忡 å�� ����
 * �޼ҵ峪 �����ڸ� ������ �� �߻��ϴ� exception�� ������ �� ��� 
 * �޼ҵ� ����ο� ����Ͽ� �ش� �޼ҵ带 ����� �� �߻��� �� �ִ� ���ܸ� �̸� ����Ѵ�. 
 * -> ����ڰ� ���ܸ� ������ �� ������, �׿� ���� ó������ ������ �� �ִ�. 
 *
 */


public class ExpTest {
	
	public void expMethod1() {
		try {
			throw new ClassNotFoundException();
		} catch (ClassNotFoundException e) {
			System.out.println("������>> ����� ��[�ڱ��ڽ� �޼ҵ�]���� ���� ó��");
		}
	}

	public static void main(String[] args) {
		 ExpTest test1 = new ExpTest();
		 test1.expMethod1();
		 
	
}
}
