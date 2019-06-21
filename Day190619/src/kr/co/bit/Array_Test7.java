package kr.co.bit;
/* 다차원 배열 테스트 
 * 사각형 만들기 = 외곽 부분은 모두 1, 안쪽은 0
 */
public class Array_Test7 {

	public static void main(String[] args) {
		int [][] recArray = new int[5][5]; // default값: 25개 칸 모두 0 (공간만 만들어 진 것)
		for (int i = 0; i < recArray.length; i++) { // [i] 가 제외 ==> 0행 1~4열, 1행 1~4열, .... 
			for(int j = 0; j < recArray[i].length; j++) {
				if(i == 0 || i == recArray.length -1 || j == 0 || j == recArray[i].length -1) {
					recArray[i][j] = 1; 
					//i = 0 > 0행, .length(길이:5)-1 => 4행에 해당하는 부분. ==> 맨위, 마지막 11111 
					// j = 0 > [i].length- -1 => 해당 행의 4열 ==> 0열, 4열의 11111 
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
