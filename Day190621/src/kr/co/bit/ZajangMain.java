package kr.co.bit;

import java.util.Scanner;

public class ZajangMain {

	public static void main(String[] args) {
		ZajangProcess zp = new ZajangProcess(); // [1]
		Scanner sc = new Scanner(System.in); // [2]
		
		while(true) {
			System.out.println("찾을 메뉴 이름을 입력해주세요: ");
			String productName = sc.next(); // [3]
			
			boolean searchResult = zp.productProcess(productName); // [4]
					// [5] 실행 후 돌아옴 
			if(searchResult)
				break; 
			
			System.out.println("찾는 메뉴가 없습니다. ");
			
		}
	}

}
