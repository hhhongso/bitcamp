package kr.co.bit;

import java.util.Scanner;

public class MaccaMain {

	public static void main(String[] args) {
		MaccaProcess mp = new MaccaProcess();
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("ã�� ��ǰ �̸�: ");
			String productName = sc.next();
			
			boolean searchResult = mp.productProcess(productName);
			if (searchResult) {
				break;
			} else {
				System.out.println("ã�� ��ǰ�� �����ϴ�. ");
			}
			
		} while(true) ;
	}

}
