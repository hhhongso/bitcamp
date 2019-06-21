package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Search {
	
	private String nameSearch;
	
	public Search() { // 초기화
		nameSearch = null; 
	}
	
	public void setSearchName() {
		System.out.println("찾을 이름을 입력하세요: ");
		String nameSearch = Register.input.next(); // Register배열방에서 끌어옴  => 멤버변수 선언했던 곳
	}
	
	public void setSearchNameType() {
		System.out.println("1. 학생 2. 교수 3. 관리자");
		String type = Register.input.next();
		System.out.print("나이\t 이름\t 학번 \t 과목 \t 부서 \n");
	}
	
	public void displaySearchStudent(HashMap<String, String> haksaHash) {
		
			
				System.out.print(haksaHash.get("age")+ "\t");
				System.out.print(haksaHash.get("name")+ "\t");
				System.out.print(haksaHash.get("hakbun")+ "\n");
			} 
		
	
	
	public void displaySearchProfessor(HashMap<String, String> haksaHash) {
		
			System.out.print(haksaHash.get("age")+ "\t");
			System.out.print(haksaHash.get("name")+ "\t");
			System.out.print(haksaHash.get("subject")+ "\n");
	}
	
		
	public void displaySearchManager(HashMap<String, String> haksaHash) {
		
			System.out.print(haksaHash.get("age")+ "\t");
			System.out.print(haksaHash.get("name")+ "\t");
			System.out.print(haksaHash.get("part")+ "\n");
		}
	
	
	public void searchProcess () { // 찾기 함수 
		 // search 함수를 arrayList 배열 안에 넣어서 null값이 나오지 않도록 함 
				
				setSearchName();
				setSearchNameType();
				
				
				for(int i = 0; i <  Register.haksaList.size(); i++) {
					HashMap<String, String> haksaHash = Register.haksaList.get(i);
					// if(haksaHash.get("name").equals(nameSearch)) {
					if(haksaHash.get("type").equals("1")) { // 학생찾기 
					displaySearchStudent(haksaHash);
					
					} else if (haksaHash.get("type").equals("2")) {// 교수찾기
						displaySearchProfessor(haksaHash);
					} else if(haksaHash.get("type").equals("3")) {
						displaySearchManager(haksaHash);
					}
	
				}
				
			//}
}// 찾기 함수 끝 

}