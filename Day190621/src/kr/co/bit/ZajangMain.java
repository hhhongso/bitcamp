package kr.co.bit;

import java.util.Scanner;

public class ZajangMain {

	public static void main(String[] args) {
		ZajangProcess zp = new ZajangProcess(); // [1]
		Scanner sc = new Scanner(System.in); // [2]
		
		while(true) {
			System.out.println("ã�� �޴� �̸��� �Է����ּ���: ");
			String productName = sc.next(); // [3]
			
			boolean searchResult = zp.productProcess(productName); // [4]
					// [5] ���� �� ���ƿ� 
			if(searchResult)
				break; 
			
			System.out.println("ã�� �޴��� �����ϴ�. ");
			
		}
	}

}
