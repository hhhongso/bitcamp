package Prac0621.haksa;

import java.util.Scanner;

// 등록 함수

/*
 * 1. 학생/ 교수/ 관리자 /이전메뉴 선택 
 * 2. 학생 선택 시 
 * 2-2. 교수 
 * 2-3. 관리자 
 * 2-4. 이전메뉴 
 */

public class Register {
	Scanner sc = new Scanner();
	public Domain domain;
	
	public Register() {
		domain = new Domain();
		
		System.out.println("=====메뉴 선택=====");
		System.out.println("1. 학생");
		System.out.println("2. 교수");
		System.out.println("3. 관리자");
		System.out.println("4. 이전메뉴");
		System.out.println("번호를 선택해 주세요.. ");
		int choice = sc.nextInt();
		
		public int register(int choice) {
			if(choice == 1) {
			} else if (choice == 2) {
				
			} else if (choice == 3) {
				
			} else if (choice == 4) {
			
			}
		}
	
//		for (int i = 0; i < domain.haksaList.size(); i++) {
//			if() {
			
			
		}
	}



	
	
}
