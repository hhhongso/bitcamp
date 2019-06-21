package kr.co.bit;

import java.util.Scanner;

public class MemberSearchMain {

	public static void main(String[] args) {
		MemberSearch ms = new MemberSearch();
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("이름을 입력하세요: ");
			String name = sc.next();
			
			// t/F 을 리턴하여 데려옴 (true 면 찾았음 ) =  찾았으면 memberSearch 클래스의 searchMember함수 실행 
			boolean searchResult = ms.searchMember(name); // boolean searchResult 값이 true 면
			if(searchResult) // 
				break; 
						// boolean searchResult 값이 false 면
			System.out.println("찾는 회원이 없습니다. ");
		} while(true);			
	}
}
