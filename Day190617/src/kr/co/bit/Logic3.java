package kr.co.bit;
//���� ���ϱ� 
/*����
 * 1. 4�� �ֱ�� ���ƿ´�. 
 * 2. 100���� �������� �� �������� 0�� �ƴϴ� 
 * 3. or 400������ �������� �� �������� 0�̴� (400�� �ֱ�� ���ƿ´�) 
 */
public class Logic3 {
	public static void main(String[] args) { // args �� �� �ֱ�: run configuration -> arguements 
		int year = Integer.parseInt(args[0]); // ���ڿ��� ���ڷ� �ٲٴ� �Լ� parseInt
		boolean result = false; 
		result = (year % 4 == 0 && year %100 !=0 || year % 400 == 0);
		if(result) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("������ �ƴմϴ�. ");
		}
		

	}

}
