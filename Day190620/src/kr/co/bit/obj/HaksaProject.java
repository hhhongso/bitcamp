package kr.co.bit.obj;
// pptx page 113
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>(); 
		// 배열. haksaList라는 배열을 선언 
		// ArrayList에 hashMap 을 탑재 
		
		Scanner input = new Scanner(System.in);
		HaksaFunction haska = new HaksaFunction(); // >> HaksaFunction 객체 생성 
		
		while(true) {
			System.out.println("=====메뉴 선택=====");
			System.out.println("1. 등록"); //ctrl +alt + 아래방향키 = 복사
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("----------------");
			System.out.println("0. 종료");
			System.out.println("----------------");
			System.out.println("번호를 선택해 주세요.. ");
			int protocol = input.nextInt();
			
			if(protocol == 1) {		
				System.out.println("=====메뉴 선택====="); 
				System.out.println("1. 학생");
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.println("번호를 선택해 주세요.. ");
				protocol = input.nextInt();
				
				haska.register(input, haksaList, protocol); // 객체생성한 haksa 클래스.함수
			 	if (protocol == 4) { // 이전메뉴
				System.out.println("이전메뉴로 돌아갑니다. ");
				continue; // '//등록' 반복문으로 올라간다.
				}

			} else if (protocol == 2) { // 찾기
				haska.search(input, haksaList);

			} else if (protocol == 3) { // 삭제
				haska.delete(input, haksaList);

			} else if (protocol == 4) { // 전체 출력
				haska.list(haksaList);

			} else { //종료
				System.out.println("종료합니다. ");
				System.exit(0); // 시스템 종료. if- break 와 같은 역할 
			}
			
		} // while(true){}

	}

}

