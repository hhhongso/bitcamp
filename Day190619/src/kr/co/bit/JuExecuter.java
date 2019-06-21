package kr.co.bit;
//ctrl+shift+f : 자동 줄맞춤 

import java.util.Scanner;

public class JuExecuter {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("주문하세요. yes/no");
			String ju = scan.next();
			if(ju.equals("yes") || ju.equals("YES")) { // 문자열과 비교하기 .equals() ==> 클래스끼리 비교하는 것 
				System.out.println("주문선택");
				System.out.println("1.자장면 2.짬뽕 3.탕수육");
				int menu = scan.nextInt();
				
				if(menu == 1) {
					System.out.println("자");
					System.out.println("곱배기 yes/no");
					String gob = scan.next();
					if(gob.equals("yes") || gob.equals("YES")) {
						System.out.println("곱 선택");
					} else {
						System.out.println("보통 선택");
					}
					
				} else if (menu ==2) {
					System.out.println("짬");
					System.out.println("곱배기 yes/no");
					String gob = scan.next();
					if(gob.equals("yes") || gob.equals("YES")) {
						System.out.println("곱 선택");
					} else {
						System.out.println("보통 선택");
					}
					
				} else if (menu == 3) {
					System.out.println("탕");
					System.out.println("1.대 2.중 3.소");
					int tang = scan.nextInt();
					if (tang == 1) {
						System.out.println("대 선택");
					} else if (tang == 2) {
						System.out.println("중 선택");
					} else if (tang == 3) {
						System.out.println("소 선택");
					}
					
				}
			} else {
				System.out.println("주문취소");
				break;
			}
			
		} // while문 끝

	}

}
