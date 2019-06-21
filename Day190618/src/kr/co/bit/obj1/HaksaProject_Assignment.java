package kr.co.bit.obj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HaksaProject_Assignment {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("====메뉴 선택====");
			System.out.println("1. 등록");
			System.out.println("2. 찾기");
			System.out.println("3. 삭제");
			System.out.println("4. 전체 출력");
			System.out.println("----------------");
			System.out.println("0. 종료");
			System.out.println("----------------");
			System.out.println("번호를 선택해 주세요: ");
			int protocol = scan.nextInt();
			
			if(protocol == 1) { // 등록
				System.out.println("=====메뉴 선택====="); 
				System.out.println("1. 학생");
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.println("번호를 선택해 주세요: ");
				protocol = scan.nextInt();
				
				if (protocol == 1) { // 학생
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					
					System.out.print("나이: ");
					String age = scan.next();
					System.out.print("이름: ");
					String name = scan.next();
					System.out.print("학번: ");
					String idNum = scan.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("idNum", idNum);
					haksaList.add(haksaHash);
					System.out.println("학생 등록이 완료 되었습니다. ");
					
				} else if (protocol == 2) { // 교수
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					System.out.print("나이: ");
					String age = scan.next();
					System.out.print("이름: ");
					String name = scan.next();
					System.out.print("과목: ");
					String subject = scan.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("subject", subject);
					haksaList.add(haksaHash);
					System.out.println("교수 등록이 완료 되었습니다. ");
					
				} else if (protocol == 3) { // 관리자
					HashMap<String, String> haksaHash = new HashMap<String, String>();
					System.out.print("나이: ");
					String age = scan.next();
					System.out.print("이름: ");
					String name = scan.next();
					System.out.print("부서: ");
					String part = scan.next();
					
					haksaHash.put("age", age);
					haksaHash.put("name", name);
					haksaHash.put("part", part);
					haksaList.add(haksaHash);
					System.out.println("관리자 등록이 완료 되었습니다. ");
					
				} else { //이전메뉴
					System.out.println("이전메뉴로 돌아갑니다. ");
					continue; 
				}
				
			} else if(protocol == 2) { //찾기 
				while(true) {
				System.out.print("이름을 입력해 주세요.: ");
				String inputName = scan.next();
				int index = -1;
				
					for(int i = 0; i < haksaList.size(); i++) {
						if(haksaList.get(i).get("name").equals(inputName)) {
							index = i; 
				//haksaList 를 그대로 못불러오니까 .get 으로 haksaHash의 (i)행 을 불러오고, 그 안에 있는 요소들 중 name 값을 또 불러온다. 		
						}
					}
					if (index != -1) { // 학생 or 교수 or 관리자
						if (haksaList.get(index).get("idNum") != null) { // idNum
							System.out.println("이름: " + haksaList.get(index).get("name") +"\t"
									+ "나이: " + haksaList.get(index).get("age") +"\t"
									+ "학번: " + haksaList.get(index).get("idNum"));
						} else if (haksaList.get(index).get("subject") != null) { //subject
							System.out.println("이름: " + haksaList.get(index).get("name") +"\t"
									+ "나이: " + haksaList.get(index).get("age") +"\t"
									+ "과목: " + haksaList.get(index).get("subject"));
						} else if (haksaList.get(index).get("part") != null) { //part
							System.out.println("이름: " + haksaList.get(index).get("name") +"\t"
									+ "나이: " + haksaList.get(index).get("age") +"\t"
									+ "부서: " + haksaList.get(index).get("part"));
						}
					} else { // index = -1, 값 없음 
						System.out.println("등록된 이름이 아닙니다. ");
					}
					
					System.out.println("계속하시려면 1, 종료하시려면 0을 입력해주세요. ");
					int choice = scan.nextInt();
					if (choice == 0) {
						System.out.println("종료합니다. ");
						break;
						
					} else {  // else if (protocol == 2) { 로 가야하는 것 아닌가? 
					}
					
				}	
			
			} else if(protocol == 3) { //삭제
				while (true) {
				System.out.println("삭제할 사람을 입력해 주세요. ");
				String inputName = scan.next();
				int index = -1;
				
					for (int i = 0 ; i <haksaList.size(); i++) {
						if (haksaList.get(i).get("name").equals(inputName)) {
						index = i; 
						haksaList.remove(index);
						System.out.println(inputName + "님을 삭제 하였습니다.");
						
						} else {
							System.out.println("등록된 이름이 아닙니다. ");
						}
					}
					
					System.out.println("계속하시려면 1, 종료하시려면 0을 입력해주세요. ");
					int choice = scan.nextInt();
					
					if (choice == 0) {
						System.out.println("종료합니다. ");
						break; 
					} else {
						
					}
				} // while문 종료 
				
				
			} else if(protocol == 4) { //전체 출력
				for(int i = 0; i < haksaList.size(); i++) { 
					if (haksaList.get(i).get("idNum") != null) { // idNum
						System.out.println("이름: " + haksaList.get(i).get("name") +"\t"
								+ "나이: " + haksaList.get(i).get("age") +"\t"
								+ "학번: " + haksaList.get(i).get("idNum"));
					} else if (haksaList.get(i).get("subject") != null) { //subject
						System.out.println("이름: " + haksaList.get(i).get("name") +"\t"
								+ "나이: " + haksaList.get(i).get("age") +"\t"
								+ "과목: " + haksaList.get(i).get("subject"));
					} else if (haksaList.get(i).get("part") != null) { //part
						System.out.println("이름: " + haksaList.get(i).get("name") +"\t"
								+ "나이: " + haksaList.get(i).get("age") +"\t"
								+ "부서: " + haksaList.get(i).get("part"));
					}
				}
			} else if(protocol == 0) { // 종료합니다. 
				System.out.println("종료합니다. ");
				System.exit(0);
	
			
		} 
	}// while문 종료
		
	

}
}

