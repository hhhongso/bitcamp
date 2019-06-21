package kr.co.bit;
/* 다중for 문 [순서]
 * for ( 초기값1 ; 조건문2 ; 증감식9)
 *    for (초기값3,10(초기화됨); 조건문4, 7, 11; 증감식6,13)
 *    실행코드5,8,12
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
