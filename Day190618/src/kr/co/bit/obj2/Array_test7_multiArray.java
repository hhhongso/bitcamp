package kr.co.bit.obj2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*Int[��][��] multiArray = new int[2][2];
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
				System.out.println("���� �Է�: ");
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
		for(int i = 0; i < multi.length;i++) { // ù���� ��(0) ���� ���� ���� 
			for(int j = 0; j < multi[i].length; j++) { // i �� ���� �� ���� 
				System.out.println(multi[i][j]);		
			}
		}
	 */

		
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("�ȳ��ϼ���", "��Ʈ"); // ��/�� �� ��� ��������� �𸣳�, �����Ǿ� ���� (put)
		System.out.println(hash.get("�ȳ��ϼ���")); // Ű�� �̿��Ͽ� ���� ���� (get)
		
		list.add(hash); //
		
	}

}
