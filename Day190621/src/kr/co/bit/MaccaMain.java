package kr.co.bit;

import java.util.Scanner;

public class MaccaMain {

	public static void main(String[] args) {
		MaccaProcess mp = new MaccaProcess();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("찾을 상품 이름: ");
			String productName = sc.next();
			
			boolean searchResult = mp.productProcess(productName);
			if (searchResult) {
				break;
			} else {
				System.out.println("찾을 상품이 없습니다. ");
			}
			
		} while(true) ;
	}

}
