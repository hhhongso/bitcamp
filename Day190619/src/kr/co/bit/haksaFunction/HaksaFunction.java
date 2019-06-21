package kr.co.bit.haksaFunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaFunction {
 public static int register(Scanner input, ArrayList<HashMap<String, String>> haksaList, int protocol) { //등록 함수 만들기 

	 if(protocol == 1) { // 학생 
	 HashMap<String, String> haksaHash = new HashMap<String, String>(); //메모리컨트롤 (기억시키기)
	 
		System.out.print("나이: ");
		String age = input.next();
		System.out.print("이름: ");
		String name = input.next();
		System.out.print("학번: ");
		String hakbun = input.next();
		
		haksaHash.put("age", age);
		haksaHash.put("name", name);
		haksaHash.put("hakbun", hakbun);
		haksaHash.put("type", "1"); 
		
		haksaList.add(haksaHash);
		System.out.println("학생이 등록 되었습니다. ");
		
	
	} else if (protocol == 2) { //교수 
		HashMap<String, String> haksaHash = new HashMap<String, String>();
		System.out.print("나이: ");
		String age = input.next();
		System.out.print("이름: ");
		String name = input.next();
		System.out.print("과목: ");
		String subject = input.next();
		
		haksaHash.put("age", age);
		haksaHash.put("name", name);
		haksaHash.put("subject", subject);
		haksaHash.put("type", "2"); // type2 = professor
		haksaList.add(haksaHash);
		System.out.println("교수가 등록 되었습니다. ");
		
	} else if (protocol == 3) { //관리자 
		HashMap<String, String> haksaHash = new HashMap<String, String>();
		System.out.print("나이: ");
		String age = input.next();
		System.out.print("이름: ");
		String name = input.next();
		System.out.print("부서: ");
		String part = input.next();
		
		haksaHash.put("age", age);
		haksaHash.put("name", name);
		haksaHash.put("part", part);
		haksaHash.put("type", "3"); // manager
		haksaList.add(haksaHash);
		System.out.println("관리자가 등록 되었습니다. ");
		}
	 
	 return protocol;
 	} // 등록 함수 끝 
 
  public static void search (Scanner input, ArrayList<HashMap<String, String>> haksaList) { // 찾기 함수 
	 // search 함수를 arrayList 배열 안에 넣어서 null값이 나오지 않도록 함 
			System.out.println("찾을 이름을 입력하세요: ");
			String nameSearch = input.next();
			System.out.println("1. 학생 2. 교수 3. 관리자");
			String type = input.next();
			System.out.print("나이\t 이름\t 학번 \t 과목 \t 부서 \n");
			for(int i = 0; i <  haksaList.size(); i++) {
				HashMap<String, String> haksaHash = haksaList.get(i);
				if(haksaHash.get("type").equals(type)) { // 학생찾기 
					if (nameSearch.equals(haksaHash.get("name"))) {
						System.out.print(haksaHash.get("age")+ "\t");
						System.out.print(haksaHash.get("name")+ "\t");
						System.out.print(haksaHash.get("hakbun")+ "\n");
					} 
				}else if (haksaHash.get("type").equals(type)) {// 교수찾기
					if(nameSearch.equals(haksaHash.get("name"))) {
						System.out.print(haksaHash.get("age")+ "\t");
						System.out.print(haksaHash.get("name")+ "\t");
						System.out.print(haksaHash.get("subject")+ "\n");
					}
				} else if(haksaHash.get("type").equals(type)) {
					if(nameSearch.equals(haksaHash.get("name"))) {
						System.out.print(haksaHash.get("age")+ "\t");
						System.out.print(haksaHash.get("name")+ "\t");
						System.out.print(haksaHash.get("part")+ "\n");
					}
				}
				
			}
			
		}// 찾기 함수 끝 

  
  public static void delete (Scanner input, ArrayList<HashMap<String, String>> haksaList) { //삭제 함수
	  System.out.println("삭제할 이름을 입력하세요: ");
		String nameDelete = input.next();
		
		for (int i = 0; i < haksaList.size();i++) {
			HashMap<String, String> haksaHash = haksaList.get(i);
			if(haksaHash.get("type").equals("1")) { // 학생 삭제  // 학사해시에서 ->type = stu에 일치하면 
				if (nameDelete.equals(haksaHash.get("name"))) { // => nameDelete가 학사해시(stu)의 name과 일치하면 
					haksaList.remove(i); // 해당 i번째 열의 ArrayList를 삭제한다. 
					System.out.println(nameDelete + "님이 삭제되었습니다. ");
					i = i -1; // 혹은 key 값을 하나 추가해서, 동일 key값을 한번에 지울 수 있도록 (동명이인 처리하기) 
				}
			} else if(haksaHash.get("type").equals("2")) { //교수 삭제
				if(nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println(nameDelete + "님이 삭제되었습니다. ");
				}
			} else if(haksaHash.get("type").equals("3")) { // 관리자 삭제
				if (nameDelete.equals(haksaHash.get("name"))) {
					haksaList.remove(i);
					System.out.println(nameDelete + "님이 삭제되었습니다. ");
				}
			}
		}
} //삭제 함수 끝
 public static void list (ArrayList<HashMap<String, String>> haksaList) { //전체 출력 함수
	 System.out.println("전체 출력"); //배열: n개에 해당되는 갯수가 선언되어 있음 => 반복할 횟수가 정해져 있음. =. for
		System.out.println("나이 \t 이름 \t 학번 \t 과목 \t 부서 \n");
		for(int i = 0; i < haksaList.size(); i++) { 	// length: 공간의 길이 / size: 공간의 크기(몇 개의 공간이 있는지)
			HashMap<String, String> haksaHash = haksaList.get(i);
			if(haksaHash.get("type").equals("1")) { 
				System.out.print(haksaHash.get("age")+ "\t");
				System.out.print(haksaHash.get("name")+ "\t");
				System.out.print(haksaHash.get("hakbun")+ "\n"); // 학생 전체출력 
			} else if (haksaHash.get("type").equals("2")) {
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t \t");
				System.out.print(haksaHash.get("subject") + "\n");
			} else if (haksaHash.get("type").equals("3")) {
				System.out.print(haksaHash.get("age") + "\t");
				System.out.print(haksaHash.get("name") + "\t \t \t");
				System.out.print(haksaHash.get("part") + "\n");
			}
			
		}
 } // 전체 출력 끝 
}
