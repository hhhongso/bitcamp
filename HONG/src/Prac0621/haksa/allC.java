package Prac0621.haksa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class allC {

	public static void main(String[] args) {
		ArrayList<HashMap<String, String>> haksaList = new ArrayList<HashMap<String, String>>();
		
		Scanner scan = new Scanner(System.in);
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
			int choice = scan.nextInt();
			
			if (choice == 1) { // 등록 메뉴 선택 
					System.out.println("=====메뉴 선택=====");
					System.out.println("1. 학생");
					System.out.println("2. 교수");
					System.out.println("3. 관리자");
					System.out.println("4. 이전메뉴");
					System.out.println("번호를 선택해 주세요.. ");
					choice = scan.nextInt();
					
					if(choice == 1) { // 학생 등록
						HashMap<String, String> haksa = new HashMap<String, String>();
						
						System.out.print("이름: ");
						String name = scan.next();
						System.out.print("나이: ");
						String age = scan.next();
						System.out.print("학번: ");
						String idNum = scan.next();
						
						haksa.put("name", name);
						haksa.put("age", age);
						haksa.put("idNum", idNum);
						haksa.put("type", "stu");
						
						haksaList.add(haksa);
						
						
						System.out.println("학생 등록이 완료되었습니다.");
						
					} else if (choice == 2) { // 교수 등록
						HashMap<String, String> haksa = new HashMap<String, String>();
						
						System.out.print("이름: ");
						String name = scan.next();
						System.out.print("나이: ");
						String age = scan.next();
						System.out.print("과목: ");
						String subject = scan.next();

						haksa.put("name", name);
						haksa.put("age", age);
						haksa.put("subject", subject);
						haksa.put("type", "prof");
						
						haksaList.add(haksa);
						
						System.out.println("교수 등록이 완료되었습니다.");
						
					} else if (choice == 3) { // 관리자 등록
						HashMap<String, String> haksa = new HashMap<String, String>();
						
						System.out.print("이름: ");
						String name = scan.next();
						System.out.print("나이: ");
						String age = scan.next();
						System.out.print("부서: ");
						String part = scan.next();

						haksa.put("name", name);
						haksa.put("age", age);
						haksa.put("part", part);
						haksa.put("type", "mng");

						haksaList.add(haksa);
						
						System.out.println("관리자 등록이 완료되었습니다.");
						
					} else if (choice == 4) { // 이전 메뉴로
						System.out.println("이전 메뉴로 돌아갑니다.");
						continue;
					}
				} // 등록 if문
	
			 else if (choice == 2) { // 찾기 메뉴 선택 
					System.out.println("찾을 이름을 입력해주세요: ");
					String name = scan.next();
					
					for(int i = 0; i < haksaList.size(); i++) {
						HashMap<String, String> haksa = haksaList.get(i);
						if(haksa.get("name").equals(name)) { // 검색한 이름이 있다. 
							System.out.println(name +"님을 찾았습니다. ");
							if(haksa.get("type").equals("stu")) { // 그 이름이 학생이다 .
								System.out.print("이름: " + haksa.get("name") +  "\t");
								System.out.print("나이: " + haksa.get("age") + "\t");
								System.out.print("학번: " + haksa.get("idNum") + "\t");
								System.out.println();
							} else if (haksa.get("type").equals("prof")) {
								System.out.print("이름: " + haksa.get("name") +  "\t");
								System.out.print("나이: " + haksa.get("age") + "\t");
								System.out.print("과목: " + haksa.get("subject") + "\t");
								System.out.println();
							} else if (haksa.get("type").equals("mng")) {
								System.out.print("이름: " + haksa.get("name") +  "\t");
								System.out.print("나이: " + haksa.get("age") + "\t");
								System.out.print("부서: " + haksa.get("part") + "\t");
								System.out.println();
							}
							
						//} else {
						//	System.out.println("찾으실 이름이 없습니다.");
						}
					}
					
					
			} // 찾기 if 문 끝
			else if (choice == 3) { // 삭제 메뉴 선택 
				System.out.println("삭제할 이름을 입력해주세요: ");
				String name = scan.next();
				
				for(int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksa = haksaList.get(i);
					if(haksa.get("name").equals(name)) {
						if(haksa.get("type").equals("stu")) {
							haksaList.remove(i);
							System.out.println("해당 이름이 삭제 되었습니다. ");
						} else if (haksa.get("type").equals("prof")) {
							haksaList.remove(i);
							System.out.println("해당 이름이 삭제 되었습니다. ");
						} else if (haksa.get("type").equals("mng")) {
							haksaList.remove(i);
							System.out.println("해당 이름이 삭제 되었습니다. ");
					}
						
					//} else {
					//	System.out.println("찾으실 이름이 없습니다. ");
					}
				}
					
			} // 삭제 if문 끝 
			
			else if (choice == 4) { // 전체 출력 메뉴 선택 
				for(int i = 0; i < haksaList.size(); i++) {
					HashMap<String, String> haksa = haksaList.get(i);
						if(haksa.get("type").equals("stu")) {
							System.out.println("이름: " + haksa.get("name") + "나이: " + haksa.get("age") + "학번: " + haksa.get("idNum"));
						} else if (haksa.get("type").equals("prof")) {
							System.out.println("이름: " + haksa.get("name") + "나이: " + haksa.get("age") + "과목: " + haksa.get("subject"));
						} else if (haksa.get("type").equals("mng")) {
							System.out.println("이름: " + haksa.get("name") + "나이: " + haksa.get("age") + "부서: " + haksa.get("part"));
						}
				}
				
			} // 전체출력 if문 끝
			
			else if (choice == 0) { // 종료 메뉴 선택
				System.out.println("종료합니다. ");
				break;
			} else { // 잘못된 선택 
				System.out.println("잘못되었습니다. 다시 선택해주세요. ");
			}
			
		} // while문 
	}

}
