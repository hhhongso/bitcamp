package kr.co.bit;
/* ����for �� [����]
 * for ( �ʱⰪ1 ; ���ǹ�2 ; ������9)
 *    for (�ʱⰪ3,10(�ʱ�ȭ��); ���ǹ�4, 7, 11; ������6,13)
 *    �����ڵ�5,8,12
 */
public class For_test5_multifor_star {

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
