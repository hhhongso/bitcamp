package kr.co.bit;

/* ������
 * ���������
 * �񱳿�����
 * ��������: and &&, or ||, not ! 
 * ���׿�����(����������): ++, --
 * 
 */
public class First3 {

	public static void main(String[] args) {
		int number1 = 10; 
		number1++;
		System.out.println(number1);
		
		int number2 = 10; int sum = 0;  
		sum = number2++; //�� ���� : number2�� sum�� ���Ե� ��, ���߿� number2 + 1 
		System.out.println(sum + ":" + number2);
		sum = ++number2; //�� ����: nubmer2 + 1 ���� ���� ��, sum1�� ���� 
		System.out.println(sum + ":" + number2);
	}

}
