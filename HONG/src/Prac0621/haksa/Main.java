package Prac0621.haksa;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("=====메뉴 선택=====");
			System.out.println("1. 등록"); 
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("----------------");
			System.out.println("0. 종료");
			System.out.println("----------------");
			System.out.println("번호를 선택해 주세요.. ");
			int choice = sc.nextInt();
			
			if (choice == 1) {
				//등록 함수
			} else if (choice == 2) {
				
			} else if (choice == 3) {
				
			} else if (choice == 4) {
				
			} else if (choice == 0) {
				
			} else {
				System.out.println("잘못된 번호입니다. ");
			}
		} // while문 끝

	}

}
