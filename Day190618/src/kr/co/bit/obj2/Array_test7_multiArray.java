package kr.co.bit.obj2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*Int[행][렬] multiArray = new int[2][2];
* ==> [0][0] [0][1] [1][0] [1][1]
* ==> [key][value]
*/
public class Array_test7_multiArray {

	public static void main(String[] args) {
	/*
	 * 	int[][] multi = new int [2][3];
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < multi.length; i++) {
			for(int j = 0; j < multi[i].length; j++) {
				System.out.println("숫자 입력: ");
				multi[i][j] = input.nextInt();
				
				
			}
		}
		/*
		multi[0][1] = 20;
		multi[0][2] = 30;
		multi[1][0] = 40;
		multi[1][1] = 50;
		multi[1][2] = 60;
	 * 
		for(int i = 0; i < multi.length;i++) { // 첫번재 행(0) 부터 행의 갯수 
			for(int j = 0; j < multi[i].length; j++) { // i 행 안의 렬 갯수 
				System.out.println(multi[i][j]);		
			}
		}
	 */

		
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("안녕하세요", "비트"); // 행/렬 중 어느 장소인지는 모르나, 보관되어 있음 (put)
		System.out.println(hash.get("안녕하세요")); // 키를 이용하여 값을 꺼냄 (get)
		
		list.add(hash); //
		
	}

}
