package kr.co.bit;
/* ������ �迭 �׽�Ʈ 
 * �簢�� ����� = �ܰ� �κ��� ��� 1, ������ 0
 */
public class Array_Test7 {

	public static void main(String[] args) {
		int [][] recArray = new int[5][5]; // default��: 25�� ĭ ��� 0 (������ ����� �� ��)
		for (int i = 0; i < recArray.length; i++) { // [i] �� ���� ==> 0�� 1~4��, 1�� 1~4��, .... 
			for(int j = 0; j < recArray[i].length; j++) {
				if(i == 0 || i == recArray.length -1 || j == 0 || j == recArray[i].length -1) {
					recArray[i][j] = 1; 
					//i = 0 > 0��, .length(����:5)-1 => 4�࿡ �ش��ϴ� �κ�. ==> ����, ������ 11111 
					// j = 0 > [i].length- -1 => �ش� ���� 4�� ==> 0��, 4���� 11111 
				}
			}
		}
		for(int i = 0; i <recArray.length; i++) {
			for(int j = 0; j < recArray[i].length; j++) {
				System.out.print(recArray[i][j]);
			}
			System.out.println();
		}
	}
}
