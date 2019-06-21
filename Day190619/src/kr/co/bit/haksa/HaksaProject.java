package kr.co.bit.haksa;
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
			
			if(protocol == 1) { // 등록
								
				System.out.println("=====메뉴 선택====="); 
				System.out.println("1. 학생");
				System.out.println("2. 교수");
				System.out.println("3. 관리자");
				System.out.println("4. 이전메뉴");
				System.out.println("번호를 선택해 주세요.. ");
				protocol = input.nextInt();
				
				if(protocol == 1) { //학생
					HashMap<String, String> haksaHash = new HashMap<String, String>(); //메모리컨트롤 (기억시키기)
					//2차원배열(행, 렬) (key)String, (값;value)String 임
					// String, Integer 도 가능. 단, 이경우 변수 int는 클래스 Integer로 선언해야 
					
					/* HashMap 클래스 ?
					 * 키와 값을 묶어 하나의 entry 로 저장, 컬렉션 클래스를 구현한다 . 
					 * key 는 2개가 될 수 없으며, value는 중복 가능. 
					 * 1개의 hashMap 의 배열이 끝난 뒤에는 새로이 메모리 공간을 설정하여야.
					 * hashing (검색방법)을 사용하여 많은 양의 데이터를 검색 할 수 있다. 
					 */
					
					System.out.print("나이: ");
					String age = input.next();
					System.out.print("이름: ");
					String name = input.next();
					System.out.print("학번: ");
					String hakbun = input.next();
					
					              //key  value
					haksaHash.put("age", age);
					haksaHash.put("name", name); // key 값이 또 age가 될 수는 없다(중복 불가)
					haksaHash.put("hakbun", hakbun);
					haksaHash.put("type", "1"); 
					/*  null 값을 처리하기 위함. 
					 *  ex) type = stu ==> 학생에 해당하는 age, name, hakbun만 들어있는것 
					 *  ==> subject, part에 해당하는 것은 애초에 stu type에 존재하지 않는 것이기 때문에 , 출력 시 stu의 값만 찍기. 
					 */
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
					
				} else { //이전메뉴 
					System.out.println("이전메뉴로 돌아갑니다. ");
					continue;                   // '//등록' 반복문으로 올라간다. 
				}
				
			} else if(protocol == 2) { //찾기
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
				
			} else if (protocol == 3) { //삭제
				System.out.println("삭제할 이름을 입력하세요: ");
				String nameDelete = input.next();
				//System.out.println("1. 학생 2. 교수 3. 관리자");
				//String Type = input.next();	
				
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
				
				
			} else if (protocol == 4) { //전체 출력
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
				
				
			} else { //종료
				System.out.println("종료합니다. ");
				System.exit(0); // 시스템 종료. if- break 와 같은 역할 
			}
			
		} // while(true){}

	}

}
