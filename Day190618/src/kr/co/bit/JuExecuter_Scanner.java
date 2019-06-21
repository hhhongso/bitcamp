package kr.co.bit;

import java.util.Scanner;

public class JuExecuter_Scanner {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("주문하세요 Y/N");
			char ju = input.next().charAt(0); // 문자열 nexT() 에서 한글자만 가져옴 charAt()
			if(ju == 'y' || ju == 'Y') {
				System.out.println("주문선택");
				System.out.println("메뉴 1.자장면 2.짬뽕 3.탕수육");
				int menu = input.nextInt();
				if(menu == 1) {
					System.out.println("자장면 선택");
					System.out.println("곱배기 선택 여부 Y/N");
					char gob = input.next().charAt(0);
					if(gob == 'y' || gob == 'Y') {
						System.out.println("곱배기 선택");
					} else {
						System.out.println("보통 선택");
					}
				} else if (menu == 2) {
					System.out.println("짬뽕 선택");
					System.out.println("곱배기 선택 여부 Y/N");
					char gob = input.next().charAt(0);
					if(gob == 'y' || gob == 'Y') {
						System.out.println("곱배기 선택");
					} else {
						System.out.println("보통 선택");
					}
				} else if (menu == 3) {
					System.out.println("탕수육 선택");
					System.out.println("1. 대 2. 중 3. 소");
					int tang = input.nextInt();
					if (tang == 1) {
						System.out.println("탕수육 대");
					} else if (tang == 2) {
						System.out.println("탕수육 중");
					} else if (tang == 3) {
						System.out.println("탕수육 소");
					}
				}
			} else {
				System.out.println("주문취소");
				break;
			}
			
		}


	}

}
