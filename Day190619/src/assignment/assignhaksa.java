package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class assignhaksa {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {	
			System.out.println("=====메뉴선택=====");
			System.out.println("1. 등록");
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("---------------");
			System.out.println("0. 종료");
			System.out.println("---------------");
			System.out.print("번호를 선택해 주세요: ");
			int choice = scan.nextInt();
			
			if (choice == 1) { // 등록	
				System.out.println("=====메뉴선택=====");
				System.out.println("1. 학생");
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.print("번호를 선택해 주세요: ");
				
				choice = scan.nextInt();				
				assignhaksa_Function.register(scan, haksaList, choice); //등록함수 를 외부 클래스에서 가져온다.
				
				if(choice == 4) { // 이전메뉴로 돌아가기  
				System.out.println("이전메뉴로 돌아갑니다. ");
				continue; 
				}
				
			} else if (choice == 2) { // 찾기
				assignhaksa_Function.search(scan, haksaList, choice);
				//찾기함수
			} else if (choice == 3) { // 삭제
				assignhaksa_Function.delete(scan, haksaList);
				//삭제함수
			} else if (choice == 4) { //전체출력
				assignhaksa_Function.outputList(haksaList);
				//출력함수
			} else { // 종료
				System.out.println("종료합니다. ");
				System.exit(0);
			}
			
		} //while문 종료 

	}

}
