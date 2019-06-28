package kr.co.bit;
 /*
  * �������̽��� �ҿ����� Ÿ��, Ŭ������ �ƴϸ�, ��ü�� ������ �� ����. ����, �Լ� ����� ����.
  * ** ���⼺�� �ش�ȭ **
  * 
  */
interface Interface1 {
	public int interVar =10; 
		//�������̽��� static�� �Ⱦ����� �ڵ����� �����Ϸ�
		//Ȯ�� ����/�Լ��� �״�� ��ӵǸ�
	public abstract void interfaceMethod(); 
		//��Ȯ���Լ��� implements > override 
}
				
				/* ���߻��ó�� ����ϰ� ������, java�� ��õ������ �Ұ��� (�θ�� 1����)
				 *  ==>  Interface�� ����� ���̸� ���� �κ��� �����ϸ� Interface�� ��ӹ޴� �� ó�� ������ �����ϴ�. 
				 *  �������̽��� �ϳ��� ���. �������̽��� ��� ������ override implements(����) �� �����ϴ�. 
				 *  ex) 
				 *  �޴��� == �������̽�; 
				 *  �޴� & ���� 
				 *  
				 */

interface Interface2{
	public abstract void interfaceMethod2();
}

				//extend �߻�Ŭ���� ��� ? >> 
			//extends Object �� �����Ǿ� ���� >>> ���߻��(Object, Interface1) 
class InterfaceIMP1 implements Interface1, Interface2 {
				
	@Override
	public void interfaceMethod() {
		System.out.println("interfaceMehod ����");
	}

	@Override
	public void interfaceMethod2() {
		System.out.println("interfaceMathod2 ����");
		
	}
	
}

public class InterfaceTest1 {

	public static void main(String[] args) {
		InterfaceIMP1 inIMP1 = new InterfaceIMP1();
							// static �Լ�/������ Ŭ���� Ÿ������ ȣ���ϴϱ� 
		System.out.println(InterfaceIMP1.interVar);
		inIMP1.interfaceMethod();
		inIMP1.interfaceMethod2();

		Interface1 inTMP1 = new InterfaceIMP1(); // �������̽� Ÿ�� Interface1�� Ŭ���� Ÿ�� InterfaceIMP1 �� 
		inTMP1.interfaceMethod();
		
		Interface2 in = new InterfaceIMP1();
		in.interfaceMethod2();
	}

}
