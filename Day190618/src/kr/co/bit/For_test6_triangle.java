package kr.co.bit;
//�ﰢ�� �����
public class For_test6_triangle {

	public static void main(String[] args) {
		int num = 0; 
		for (int i = 1; i<=5; i++) {
			for(int j = 1; j<=i; j++) {
				// Ȥ�� num++; �ϰ� sysout num+\t
				System.out.print(++num + "\t");
			}
			System.out.println();
		}
		
		num = 0; 
		for(int i = 1; i<=5; i++) {
			for (int j = 1; j <= (6-i); j++) { // 6-i �� ����Ͽ� 5���� ��� �ϱ� ���Ͽ� 
				num++;
				System.out.print(num + "\t");
			}
			System.out.println();	
		}
		

	}

}
