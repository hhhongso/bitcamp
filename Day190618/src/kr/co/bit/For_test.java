package kr.co.bit;
/*�ݺ��� for ��
 * 1~10�� ���� ���϶�
 */
public class For_test {

	public static void main(String[] args) {
		int number1 = 0;
		int sum = 0;
		//     �ʱⰪ         ���ǽ�         ������
		for (int i = 0; i < 100; i++) { // true�� �� �ڵ��� ����
			// i= 0 �ʱⰪ => ; 0< 10 �� True �� �ڵ����� ����{�ϰ�,}�ٽ� �ڵ��� ���� �ö��  => i++ �Ѵ�. 
			number1++; //number1 = number1 + 1 [����]
			sum += number1; // sum = sum+ number1 [����]		
		}
		System.out.println("����: " +number1 + " �հ�: " + sum);

	}

}
